# Junjie的交通模组 — NeoForge 1.21.1 移植版

中国式交通标志牌模组（作者 B 站 JunZulaki）从 **Forge 1.20.1 / MCreator** 移植到 **NeoForge 1.21.1** 的版本。
功能对齐原 1.0.3：144 个方块、144 个对应物品、59 个方块实体、30 个标志牌编辑界面、`TextEngine` 标志牌文字渲染。

## 环境要求

| 项目 | 版本 |
|---|---|
| Minecraft | 1.21.1 |
| 加载器 | NeoForge **21.1.x**（工程按 21.1.255 验证） |
| JDK | **21**（1.21.1 必须，17 无法构建） |
| Gradle | 由仓库自带 wrapper 提供（8.9，已指向腾讯云镜像） |
| 构建插件 | ModDevGradle `net.neoforged.moddev` 2.0.78 |

## 构建

```bash
# Windows
gradlew.bat build

# macOS / Linux
./gradlew build
```

首次构建会联网下载 Minecraft 与 NeoForge 依赖（约数百 MB，之后走本地缓存）。

产物：

```
build/libs/junjietrafficmod-1.0.3.jar
```

仓库 `dist/` 目录下已附带一份预先构建好的同名 jar，可直接使用。

## 安装到游戏

1. 安装 Minecraft 1.21.1 + NeoForge 21.1.x（官方安装器）；
2. 把 `junjietrafficmod-1.0.3.jar` 放入 `.minecraft/mods/`；
3. 启动 NeoForge 1.21.1 配置。

> 该 jar 只能在 **NeoForge 1.21.1** 下运行，不能与 Forge 1.20.1 版本混用，也不支持 Forge 1.21.1。

## 本地开发运行

```bash
gradlew.bat runClient    # 客户端
gradlew.bat runServer    # 服务端（首次需接受 run/eula.txt）
gradlew.bat runData      # 数据生成
```

## 关于 `legacy-1.20.1-mcreator/`

原 MCreator（Forge 1.20.1）工程的**元素定义文件**保留在此目录，未做改动：
`elements/`（177 个 mod 元素）、`models/`、`junjietrafficmod.mcreator`、`.mcreator/`、IDE 配置文件。

这些文件不参与本仓库的 Gradle 构建。若在 MCreator 中继续修改元素并重新生成代码，输出的仍是 Forge 1.20.1 代码，**不会自动同步**到本工程的 `src/`。

## 移植涉及的主要 API 变更

| 1.20.1 Forge | 1.21.1 NeoForge |
|---|---|
| `net.minecraftforge.*` | `net.neoforged.{fml, bus, api.distmarker, neoforge}.*` |
| `RegistryObject` | `DeferredHolder` / `DeferredBlock` / `DeferredItem` |
| `ForgeRegistries.BLOCKS` / `ITEMS` | `DeferredRegister.createBlocks()` / `createItems()` |
| `IForgeMenuType` | `IMenuTypeExtension` |
| `FMLJavaModLoadingContext.get().getModEventBus()` | 构造函数注入 `IEventBus` |
| `@Mod.EventBusSubscriber` | 顶层 `@EventBusSubscriber(modid=…, bus=…)` |
| `LazyOptional` + `getCapability(Capability, Direction)` | `RegisterCapabilitiesEvent.registerBlockEntity(Capabilities.ItemHandler.BLOCK, …)` |
| `SimpleChannel` / `NetworkRegistry.newSimpleChannel` | `CustomPacketPayload` + `StreamCodec` + `RegisterPayloadHandlersEvent` / `PacketDistributor` |
| `NetworkHooks.openScreen(…)` | 原生 `ServerPlayer.openMenu(provider, buf -> …)` |
| `BlockBehaviour.use(…)` | 拆分为 `useWithoutItem(…)` 与 `useItemOn(…)`（两者都已实现以保持手持物品右键也能打开界面） |
| `BlockEntity.load / saveAdditional / getUpdateTag` | 增加 `HolderLookup.Provider` 参数 |
| `MenuScreens.register`（已私有） | `RegisterMenuScreensEvent` |
| `EditBox.tick()`、`moveCursorTo(int)` | 移除 / 改为 `moveCursorTo(int, boolean)` |
| 数据包目录 `loot_tables`、`tags/blocks` | `loot_table`、`tags/block`（1.21 重命名，不改会静默失效） |
| `mods.toml` | `META-INF/neoforge.mods.toml`（`loaderVersion=[3,)`，依赖 `neoforge [21.1.0,)` + `minecraft [1.21.1]`） |

## 已验证内容

- `javac` 全量编译 274 个源文件：0 错误；`gradlew build` 成功
- 产物字节码扫描：492 个 class 中 `net/minecraftforge` 引用 **0 处**
- 资源交叉校验：144 个方块的 blockstate / item model /  loot table 全部存在，模型 parent 与贴图引用、`mineable/pickaxe` 标签条目、227 个界面 lang key 零缺失
- 本地 `runServer` 以 NeoForge 21.1.255 启动 Minecraft 1.21.1：模组正常注册与加载，无异常

## 尚待客户端实测

图形界面相关部分仅通过编译验证，需在真实客户端确认：编辑界面布局与交互、`TextEngine` 文字渲染效果（位置/字号/颜色/加粗）、方块掉落。如遇问题请附上截图或 `logs/latest.log` 中的报错行。

## 许可

模组源码与美术资源版权归 **JunZulaki** 所有（All Rights Reserved），详见 `LICENSE`。
