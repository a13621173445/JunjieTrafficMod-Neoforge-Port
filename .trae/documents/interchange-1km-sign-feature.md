# 互通1km标志牌添加告示牌功能

## Context
模组是 MCreator 生成的 Forge 1.20.1 模组（modid `junjietrafficmod`）。用户希望给 `interchange_1km`（互通1km高速标志牌）加类似原版告示牌的功能：右键打开编辑界面输入 **1 行文字**，文字保存在方块实体（BlockEntity）中并在牌面上实时渲染。

牌面模型：`models/custom/interchange1km.json` 中 `board` 元素 from [-15,0,5] to [31,32,6]，正面朝 FACING 方向（blockstates：N=0°/E=90°/S=180°/W=270°），牌面中心约 x=8px、y=16px。

## 方案总览
新增 6 个文件（MCreator 不会再生成，安全），只改动 1 个生成文件 `Interchange1kmBlock.java`（implements EntityBlock + use()）。包名 `mcscjunjie.junzulaki.trafficmod`。

## 新建文件
1. **`init/JunjietrafficmodModBlockEntities.java`**
   `DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID)`，字段 `INTERCHANGE_1KM_BE`：
   `BlockEntityType.Builder.of(Interchange1kmSignBlockEntity::new, JunjietrafficmodModBlocks.INTERCHANGE_1KM.get()).build(null)`

2. **`blockentity/Interchange1kmSignBlockEntity.java`**
   `extends BlockEntity`；`private String text = ""` + getter/setter；`saveAdditional`/`load` 存取 `"Text"`；同步四件套：`getUpdatePacket()` → `ClientboundBlockEntityDataPacket.create(this)`、`getUpdateTag()` → `saveWithoutMetadata()`、`onDataPacket`、`handleUpdateTag` 均走 `load`。

3. **`network/ModNetwork.java`**
   `@Mod.EventBusSubscriber(modid, bus = MOD)`；`FMLCommonSetupEvent` 中 `enqueueWork` 里通过主类现有 `JunjietrafficmodMod.addNetworkMessage(...)` 注册两条消息：
   - S2C `OpenSignEditorMessage(BlockPos pos, String text)`：客户端收到后 `DistExecutor.unsafeRunWhenOn(CLIENT, ...)` 打开编辑界面（避免专用服务器加载客户端类）
   - C2S `SaveSignTextMessage(BlockPos pos, String text)`：服务端校验 `distanceToSqr < 64`、长度 ≤ 32、过滤 `§`，写 BE → `setChanged()` + `level.sendBlockUpdated(pos, state, state, 3)`

4. **`client/JunjietrafficmodModClient.java`**
   `@Mod.EventBusSubscriber(modid, bus = MOD, value = Dist.CLIENT)`；监听 `EntityRenderersEvent.RegisterRenderers` 注册 BER；静态方法 `openSignEditor(BlockPos, String)` 调 `Minecraft.getInstance().setScreen(...)`。

5. **`client/InterchangeSignEditScreen.java`**
   `extends Screen`；单个 `EditBox`（`setMaxLength(32)`）+ "完成"按钮 → `PACKET_HANDLER.sendToServer(new SaveSignTextMessage(...))` 并关闭；Esc 直接关闭不保存。

6. **`client/Interchange1kmSignRenderer.java`**
   `implements BlockEntityRenderer<Interchange1kmSignBlockEntity>`；`shouldRenderOffScreen() → true`（牌面超出方块体）。
   render 流程：pushPose → translate 到方块原点 → 按 FACING 的 y 角度旋转（YP.rotationDegrees 取负，方向实测校准）→ 在模型坐标 z=5/16−0.004、水平居中 x=0.5、y≈1.0 处，按 `min(1.2, 2.4*16/font.width(text))` 缩放，`font.drawInBatch(text, ..., Font.DisplayMode.POLYGON_OFFSET, 0, LevelRenderer.getLightColor(level, pos))` 绘制白色文字。

## 修改的生成文件
- **`block/Interchange1kmBlock.java`**（唯一被改的生成文件）：
  - `implements EntityBlock`，实现 `newBlockEntity(pos, state)` 返回新 BE（getTicker 不需要）
  - 新增 `use(...)`：主手 + 服务端 → `PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) player), new OpenSignEditorMessage(pos, be.getText()))`，返回 `InteractionResult.SUCCESS/CONSUME`
  - ⚠️ 此文件被 MCreator 再生成会丢失改动 → 完成后提醒用户在 MCreator 中对该元素**锁定代码**
- **`JunjietrafficmodMod.java`** 构造函数的 `// Start of user code block mod init` 区内加一行 `JunjietrafficmodModBlockEntities.REGISTRY.register(bus);`（该区再生成时保留，安全）

## 验证
1. `gradlew build` 编译通过
2. `gradlew runClient` 手动测试：放置方块 → 空手右键弹出编辑框 → 输入文字 → 完成 → 牌面居中显示白色文字；四个朝向各测一次（重点校验旋转方向/镜像）；退出重进文本仍在；破坏方块无报错
3. `gradlew runServer`（如有需要）确认专用服务器不因客户端类崩溃
