package mcscjunjie.junzulaki.trafficmod;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.phys.Vec3;

import mcscjunjie.junzulaki.trafficmod.block.Interchange1kmBlock;
import mcscjunjie.junzulaki.trafficmod.block.Interchange2kmBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitgBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitsBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitxyBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitrBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitnBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadGBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadSBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadXYBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadSideGBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadSideSBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadSideXYBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExpwyGBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExpwySBlock;
import mcscjunjie.junzulaki.trafficmod.block.LimitCarBlock;
import mcscjunjie.junzulaki.trafficmod.block.LimitTruckBlock;
import mcscjunjie.junzulaki.trafficmod.block.EntranceE1GBlock;
import mcscjunjie.junzulaki.trafficmod.block.EntranceE1SBlock;
import mcscjunjie.junzulaki.trafficmod.block.EntranceE2Block;
import mcscjunjie.junzulaki.trafficmod.block.Fwq21Block;
import mcscjunjie.junzulaki.trafficmod.block.Fwq22Block;
import mcscjunjie.junzulaki.trafficmod.block.MileageRBlock;
import mcscjunjie.junzulaki.trafficmod.block.MileageRGBlock;
import mcscjunjie.junzulaki.trafficmod.block.MileageRSBlock;
import mcscjunjie.junzulaki.trafficmod.block.MileageRXYBlock;
import mcscjunjie.junzulaki.trafficmod.block.MileageRNBlock;
import mcscjunjie.junzulaki.trafficmod.block.HORplacereportBlock;
import mcscjunjie.junzulaki.trafficmod.block.InterchangeA1Block;
import mcscjunjie.junzulaki.trafficmod.block.InterchangeA2Block;
import mcscjunjie.junzulaki.trafficmod.block.InterchangeB1Block;
import mcscjunjie.junzulaki.trafficmod.block.InterchangeB2Block;
import mcscjunjie.junzulaki.trafficmod.block.GantryExpwyGnumberBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryExpwySnumberBlock;
import mcscjunjie.junzulaki.trafficmod.block.SIDEexitnumberBlock;
import mcscjunjie.junzulaki.trafficmod.block.SIDEtunnelBlock;
import mcscjunjie.junzulaki.trafficmod.block.SIDEbarrierBlock;
import mcscjunjie.junzulaki.trafficmod.block.StrictRoadBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryPileNumberBlock;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross1Block;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross2Block;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross3Block;
import mcscjunjie.junzulaki.trafficmod.block.SIDEcross4Block;
import mcscjunjie.junzulaki.trafficmod.block.ServiceAreaEntranceBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitNumberShowBlock;
import mcscjunjie.junzulaki.trafficmod.block.BridgeBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExitreportBlock;
import mcscjunjie.junzulaki.trafficmod.block.NextexitBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExpwyExitStraightBlock;
import mcscjunjie.junzulaki.trafficmod.block.ExpwyExitRightBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadExitStraightBlock;
import mcscjunjie.junzulaki.trafficmod.block.RoadExitRightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryGInterStraightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryGInterRightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantryGInterLeftBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantrySInterStraightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantrySInterRightBlock;
import mcscjunjie.junzulaki.trafficmod.block.GantrySInterLeftBlock;
import mcscjunjie.junzulaki.trafficmod.block.StrictRoad2Block;

import java.util.function.Supplier;
import net.neoforged.fml.common.EventBusSubscriber;
import mcscjunjie.junzulaki.trafficmod.JunjietrafficmodMod;

@EventBusSubscriber(modid = JunjietrafficmodMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TextEngine {

	public static final String SIGN_TEXT_NBT_KEY = "SignText";
	public static final int SIGN_LINE_COUNT = 6;
	public static final int CROSS_SLOT_COUNT = 10;
	public static final double CROSS_Z = 0.16D;
	public static final int MAX_TEXT_LENGTH = 64;
	private static final double MAX_EDIT_DISTANCE_SQR = 64.0D;

	public static final LineStyle INTERCHANGE_STYLE = new LineStyle(-0.62D, 0.37D, 0.2D, 0.04D, 0.7D, 0xFF004700);

	public static final LineStyle[] EXITG_STYLES = createExitStyles(0xFFBEBEBE);
	public static final LineStyle[] EXITSXY_STYLES = createExitStyles(0xFF000000);

	public static final LineStyle[] EXITR_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] EXITN_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	static {
		EXITR_STYLES[1] = new LineStyle(0.0D, 1.35D, 0.13D, 0.05D, 1.4D, 0xFFBEBEBE);
		EXITR_STYLES[2] = new LineStyle(0.0D, 0.5D, 0.13D, 0.05D, 2.5D, 0xFFBEBEBE);
		EXITN_STYLES[3] = new LineStyle(0.0D, 1.35D, 0.13D, 0.05D, 2.5D, 0xFFBEBEBE);
		EXITN_STYLES[4] = new LineStyle(0.0D, 0.5D, 0.13D, 0.05D, 2.5D, 0xFFBEBEBE);
	}

	public static final LineStyle[] ROADG_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] ROAD_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] ROADSIDE_G_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] ROADSIDE_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] EXPWY_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	static {
		ROADG_STYLES[1] = new LineStyle(0.03D, 0.42D, 0.2D, 0.09D, 1.4D, 0xFFBEBEBE, false);
		ROAD_STYLES[1] = new LineStyle(0.03D, 0.42D, 0.2D, 0.09D, 1.4D, 0xFF000000, false);
		ROADSIDE_G_STYLES[1] = new LineStyle(0.03D, 0.42D, 0.13D, 0.09D, 1.4D, 0xFFBEBEBE, false);
		ROADSIDE_STYLES[1] = new LineStyle(0.03D, 0.42D, 0.13D, 0.09D, 1.4D, 0xFF000000, false);
		EXPWY_STYLES[1] = new LineStyle(0.03D, 0.9D, 0.2D, 0.09D, 1.4D, 0xFFBEBEBE);
		EXPWY_STYLES[2] = new LineStyle(0.03D, 0.35D, 0.2D, 0.03D, 1.5D, 0xFFBEBEBE);
		EXPWY_STYLES[3] = new LineStyle(0.03D, 1.7D, 0.2D, 0.03D, 1.5D, 0xFF000000);
	}

	public static final LineStyle[] MILEAGE_RG_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] MILEAGE_RSXY_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] MILEAGE_RN_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] LIMIT_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	static {
		LineStyle mileageSlot = new LineStyle(0.0D, 0.7D, 0.13D, 0.03D, 0.9D, 0xFFBEBEBE);
		MILEAGE_RG_STYLES[1] = mileageSlot;
		MILEAGE_RSXY_STYLES[1] = mileageSlot;
		MILEAGE_RN_STYLES[1] = mileageSlot;
		MILEAGE_RG_STYLES[2] = new LineStyle(0.0D, 0.45D, 0.13D, 0.013D, 0.35D, 0xFFBEBEBE);
		MILEAGE_RSXY_STYLES[2] = new LineStyle(0.0D, 0.45D, 0.13D, 0.013D, 0.35D, 0xFF000000);
		MILEAGE_RN_STYLES[2] = new LineStyle(0.0D, 0.45D, 0.13D, 0.013D, 0.65D, 0xFFBEBEBE);
		LIMIT_STYLES[1] = new LineStyle(-0.79D, 0.6D, -0.43D, 0.05D, 0.5D, 0xFF000000);
		LIMIT_STYLES[2] = new LineStyle(0.79D, 0.6D, -0.43D, 0.05D, 0.5D, 0xFFBEBEBE);
	}

	public static final LineStyle[] ENTRANCE_G_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] ENTRANCE_S_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] ENTRANCE_2_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] FWQ21_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] FWQ22_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	static {
		LineStyle entranceNumber = new LineStyle(0.01D, 0.27D, 0.13D, 0.05D, 0.7D, 0xFFBEBEBE, false);
		ENTRANCE_G_STYLES[1] = entranceNumber;
		ENTRANCE_S_STYLES[1] = entranceNumber;
		ENTRANCE_S_STYLES[2] = new LineStyle(0.01D, 0.64D, 0.13D, 0.015D, 0.7D, 0xFF000000, false);
		ENTRANCE_2_STYLES[1] = new LineStyle(0.05D, 0.5D, 0.13D, 0.06D, 2.5D, 0xFFBEBEBE);
		LineStyle fwqName = new LineStyle(-0.6D, 0.45D, 0.13D, 0.06D, 1.5D, 0xFFBEBEBE);
		FWQ21_STYLES[1] = fwqName;
		FWQ22_STYLES[1] = fwqName;
		FWQ22_STYLES[2] = new LineStyle(0.8D, 0.35D, 0.13D, 0.04D, 1.0D, 0xFFBEBEBE);
	}

	public static final LineStyle[] PLACE_REPORT_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] INTERCHANGE_A_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] INTERCHANGE_B_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] GANTRY_GNUMBER_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] GANTRY_SNUMBER_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	static {
		PLACE_REPORT_STYLES[1] = new LineStyle(-1.2D, 1.45D, 0.2D, 0.06D, 1.5D, 0xFFBEBEBE, true, LineStyle.ALIGN_LEFT);
		PLACE_REPORT_STYLES[2] = new LineStyle(-1.2D, 0.5D, 0.2D, 0.06D, 1.5D, 0xFFBEBEBE, true, LineStyle.ALIGN_LEFT);
		PLACE_REPORT_STYLES[3] = new LineStyle(-1.2D, -0.45D, 0.2D, 0.06D, 1.5D, 0xFFBEBEBE, true, LineStyle.ALIGN_LEFT);
		PLACE_REPORT_STYLES[4] = new LineStyle(1.2D, 1.4D, 0.2D, 0.05D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		PLACE_REPORT_STYLES[5] = new LineStyle(1.2D, 0.45D, 0.2D, 0.05D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		PLACE_REPORT_STYLES[6] = new LineStyle(1.2D, -0.5D, 0.2D, 0.05D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		INTERCHANGE_A_STYLES[1] = new LineStyle(0.02D, 1.6D, 0.2D, 0.04D, 2.5D, 0xFFBEBEBE);
		INTERCHANGE_A_STYLES[2] = new LineStyle(-0.97D, 0.85D, 0.2D, 0.04D, 0.65D, 0xFFBEBEBE);
		INTERCHANGE_A_STYLES[3] = new LineStyle(0.97D, 0.85D, 0.2D, 0.04D, 0.65D, 0xFFBEBEBE);
		INTERCHANGE_B_STYLES[1] = new LineStyle(-1.2D, 1.6D, 0.2D, 0.04D, 2.5D, 0xFFBEBEBE, true, LineStyle.ALIGN_LEFT);
		INTERCHANGE_B_STYLES[2] = new LineStyle(-0.1D, 1.1D, 0.2D, 0.04D, 1.4D, 0xFFBEBEBE, true, LineStyle.ALIGN_LEFT);
		INTERCHANGE_B_STYLES[3] = new LineStyle(-0.1D, 0.7D, 0.2D, 0.04D, 1.4D, 0xFFBEBEBE, true, LineStyle.ALIGN_LEFT);
		LineStyle gantryNumber = new LineStyle(0.0D, 1.0D, -0.42D, 0.06D, 1.7D, 0xFFBEBEBE);
		LineStyle gantryName = new LineStyle(0.02D, 0.45D, -0.42D, 0.045D, 1.7D, 0xFFBEBEBE);
		GANTRY_GNUMBER_STYLES[1] = gantryNumber;
		GANTRY_GNUMBER_STYLES[2] = gantryName;
		GANTRY_SNUMBER_STYLES[1] = gantryNumber;
		GANTRY_SNUMBER_STYLES[2] = gantryName;
		GANTRY_SNUMBER_STYLES[3] = new LineStyle(0.02D, 1.63D, -0.42D, 0.035D, 1.7D, 0xFF000000);
	}

	public static final LineStyle[] EXITNUMBER_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] BARRIER_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] TUNNEL_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] STRICTROAD_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	public static final LineStyle[] PILE_STYLES = new LineStyle[SIGN_LINE_COUNT + 1];
	static {
		EXITNUMBER_STYLES[1] = new LineStyle(0.19D, 0.22D, 0.14D, 0.03D, 0.3D, 0xFF008000);
		BARRIER_STYLES[1] = new LineStyle(0.7D, 0.95D, 0.16D, 0.04D, 1.2D, 0xFFBEBEBE, false);
		TUNNEL_STYLES[1] = new LineStyle(0.3D, 1.57D, 0.16D, 0.04D, 2.0D, 0xFFBEBEBE);
		TUNNEL_STYLES[2] = new LineStyle(0.7D, 0.95D, 0.16D, 0.04D, 1.2D, 0xFFBEBEBE, false);
		STRICTROAD_STYLES[1] = new LineStyle(0.02D, 0.45D, 0.20D, 0.02D, 0.85D, 0xFF000000);
		STRICTROAD_STYLES[2] = new LineStyle(0.02D, 0.2D, 0.20D, 0.023D, 0.85D, 0xFF000000, false);
		PILE_STYLES[1] = new LineStyle(-0.03D, 0.33D, -0.43D, 0.035D, 2.1D, 0xFF000000);
	}

	public static final LineStyle CROSS_DIRECTION_STYLE =
			new LineStyle(-1.33D, 1.79D, CROSS_Z, 0.025D, 0.2D, 0xFF1F427D, false, LineStyle.ALIGN_LEFT);
	public static final LineStyle[] CROSS_A_STYLES = new LineStyle[CROSS_SLOT_COUNT + 1];
	public static final LineStyle[] CROSS_B_STYLES = new LineStyle[CROSS_SLOT_COUNT + 1];
	public static final LineStyle[] CROSS_C_STYLES = new LineStyle[CROSS_SLOT_COUNT + 1];
	public static final LineStyle[] CROSS_D_STYLES = new LineStyle[CROSS_SLOT_COUNT + 1];
	static {
		CROSS_A_STYLES[1] = new LineStyle(0.03D, 0.53D, CROSS_Z, 0.025D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_A_STYLES[2] = new LineStyle(-1.3D, 1.0D, CROSS_Z, 0.03D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_A_STYLES[3] = new LineStyle(-1.3D, 0.75D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_A_STYLES[4] = new LineStyle(-1.3D, 0.5D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_A_STYLES[5] = new LineStyle(0.03D, 1.7D, CROSS_Z, 0.03D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_A_STYLES[6] = new LineStyle(0.03D, 1.45D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_A_STYLES[7] = new LineStyle(0.8D, 1.7D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_A_STYLES[8] = new LineStyle(1.3D, 1.0D, CROSS_Z, 0.03D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_A_STYLES[9] = new LineStyle(1.3D, 0.75D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_A_STYLES[10] = new LineStyle(1.3D, 0.5D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);

		CROSS_B_STYLES[1] = new LineStyle(0.5D, 0.55D, CROSS_Z, 0.025D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_B_STYLES[2] = new LineStyle(-1.3D, 1.0D, CROSS_Z, 0.03D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_B_STYLES[3] = new LineStyle(-1.3D, 0.75D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_B_STYLES[4] = new LineStyle(-1.3D, 0.5D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_B_STYLES[5] = new LineStyle(0.5D, 1.7D, CROSS_Z, 0.03D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_B_STYLES[6] = new LineStyle(0.5D, 1.45D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_B_STYLES[7] = new LineStyle(-0.3D, 1.7D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);

		CROSS_C_STYLES[1] = new LineStyle(-0.47D, 0.55D, CROSS_Z, 0.025D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_C_STYLES[4] = new LineStyle(1.3D, 0.5D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_C_STYLES[5] = new LineStyle(-0.45D, 1.7D, CROSS_Z, 0.03D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_C_STYLES[6] = new LineStyle(-0.45D, 1.45D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_C_STYLES[7] = new LineStyle(0.4D, 1.7D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_C_STYLES[8] = new LineStyle(1.3D, 1.0D, CROSS_Z, 0.03D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_C_STYLES[9] = new LineStyle(1.3D, 0.75D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_C_STYLES[10] = new LineStyle(1.3D, 1.34D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);

		CROSS_D_STYLES[1] = new LineStyle(0.03D, 1.35D, CROSS_Z, 0.025D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		CROSS_D_STYLES[2] = new LineStyle(-1.3D, 1.0D, CROSS_Z, 0.03D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_D_STYLES[3] = new LineStyle(-1.3D, 0.75D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_D_STYLES[4] = new LineStyle(-1.3D, 1.34D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_LEFT);
		CROSS_D_STYLES[8] = new LineStyle(1.3D, 1.0D, CROSS_Z, 0.03D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_D_STYLES[9] = new LineStyle(1.3D, 0.75D, CROSS_Z, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		CROSS_D_STYLES[10] = new LineStyle(1.3D, 1.34D, CROSS_Z, 0.03D, 0.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
	}

	private static LineStyle[] createExitStyles(int slot1Color) {
		LineStyle[] styles = new LineStyle[SIGN_LINE_COUNT + 1];
		styles[1] = new LineStyle(0.0D, 1.35D, 0.13D, 0.05D, 1.0D, slot1Color);
		styles[2] = new LineStyle(0.0D, 0.5D, 0.13D, 0.05D, 2.5D, 0xFFBEBEBE);
		for (int i = 3; i <= SIGN_LINE_COUNT; i++)
			styles[i] = new LineStyle(0.0D, 0.5D, 0.13D, 0.05D, 1.0D, 0xFFBEBEBE);
		return styles;
	}

	public static final int MAX_SIGN_LINE = 12;
	public static final LineStyle[] DEBUG_STYLES = new LineStyle[100];

	public static final LineStyle[] SERVICE_AREA_T = new LineStyle[3];
	public static final LineStyle[] EXIT_NUMBER_SHOW_T = new LineStyle[2];
	public static final LineStyle[] BRIDGE_T = new LineStyle[4];
	public static final LineStyle[] EXPORT_REPORT_T = new LineStyle[13];
	public static final LineStyle[] NEXT_EXIT_T = new LineStyle[4];
	public static final LineStyle[] EXIT_PLACE_T = new LineStyle[5];
	public static final LineStyle[] INTER_GOING_G_T = new LineStyle[7];
	public static final LineStyle[] INTER_GOING_S_T = new LineStyle[7];
	public static final LineStyle[] STRICT_ROAD_T = new LineStyle[3];
 	static {
		// 1-2 服务区入口
		DEBUG_STYLES[1] = new LineStyle(0.0D, 1.3D, 0.20D, 0.02D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[2] = new LineStyle(0.02D, 1.6D, 0.20D, 0.04D, 1.0D, 0xFFBEBEBE, true, LineStyle.ALIGN_CENTER);
		SERVICE_AREA_T[1] = DEBUG_STYLES[1];
		SERVICE_AREA_T[2] = DEBUG_STYLES[2];
		// 3 出口编号
		DEBUG_STYLES[3] = new LineStyle(0.0D, 0.97D, 0.20D, 0.035D, 0.6D, 0xFF005F00, false, LineStyle.ALIGN_CENTER);
		EXIT_NUMBER_SHOW_T[1] = DEBUG_STYLES[3];
		// 4-6 桥梁
		DEBUG_STYLES[4] = new LineStyle(0.45D, 1.1D, 0.13D, 0.025D, 1.7D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[5] = new LineStyle(0.5D, 0.45D, 0.13D, 0.04D, 0.7D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[6] = new LineStyle(0.45D, 1.5D, 0.13D, 0.04D, 1.7D, 0xFFBEBEBE, true, LineStyle.ALIGN_CENTER);
		BRIDGE_T[1] = DEBUG_STYLES[4];
		BRIDGE_T[2] = DEBUG_STYLES[5];
		BRIDGE_T[3] = DEBUG_STYLES[6];
		// 7-18 绕城高速出口预告
		DEBUG_STYLES[7] = new LineStyle(-1.06D, 1.08D, 0.13D, 0.026D, 0.4D, 0xFF005F00, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[8] = new LineStyle(-1.06D, 0.67D, 0.13D, 0.026D, 0.4D, 0xFF005F00, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[9] = new LineStyle(-1.06D, 0.26D, 0.13D, 0.026D, 0.4D, 0xFF005F00, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[10] = new LineStyle(-0.15D, 1.08D, 0.13D, 0.035D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[11] = new LineStyle(-0.15D, 0.67D, 0.13D, 0.035D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[12] = new LineStyle(-0.15D, 0.26D, 0.13D, 0.035D, 1.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[13] = new LineStyle(0.9D, 1.08D, 0.13D, 0.035D, 0.3D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		DEBUG_STYLES[14] = new LineStyle(0.9D, 0.67D, 0.13D, 0.035D, 0.3D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		DEBUG_STYLES[15] = new LineStyle(0.9D, 0.26D, 0.13D, 0.035D, 0.3D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		DEBUG_STYLES[16] = new LineStyle(-1.1D, 1.58D, 0.13D, 0.03D, 0.35D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[17] = new LineStyle(-0.82D, 1.56D, 0.13D, 0.02D, 0.2D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[18] = new LineStyle(0.37D, 1.63D, 0.13D, 0.035D, 1.8D, 0xFF000000, true, LineStyle.ALIGN_CENTER);
		for (int i = 7; i <= 18; i++)
			EXPORT_REPORT_T[i - 6] = DEBUG_STYLES[i];
		// 19-21 下一出口
		DEBUG_STYLES[19] = new LineStyle(-0.63D, 0.39D, 0.13D, 0.035D, 0.6D, 0xFF007F00, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[20] = new LineStyle(1.0D, 0.39D, 0.13D, 0.04D, 1.0D, 0xFFBEBEBE, false, LineStyle.ALIGN_RIGHT);
		DEBUG_STYLES[21] = new LineStyle(0.02D, 0.8D, 0.13D, 0.035D, 2.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		NEXT_EXIT_T[1] = DEBUG_STYLES[19];
		NEXT_EXIT_T[2] = DEBUG_STYLES[20];
		NEXT_EXIT_T[3] = DEBUG_STYLES[21];
		// 22-25 出口去向（面板前缘 z=0.4375，四方块共享）
		DEBUG_STYLES[22] = new LineStyle(0.35D, 0.75D, 0.13D, 0.04D, 1.7D, 0xFFBEBEBE, true, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[23] = new LineStyle(0.35D, 1.55D, 0.13D, 0.04D, 1.7D, 0xFFBEBEBE, true, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[24] = new LineStyle(0.35D, 1.15D, 0.13D, 0.025D, 1.7D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[25] = new LineStyle(0.35D, 0.35D, 0.13D, 0.025D, 1.7D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		EXIT_PLACE_T[1] = DEBUG_STYLES[22];
		EXIT_PLACE_T[2] = DEBUG_STYLES[23];
		EXIT_PLACE_T[3] = DEBUG_STYLES[24];
		EXIT_PLACE_T[4] = DEBUG_STYLES[25];
		// 26-31 枢纽去向（面板前缘 z=1.0）
		DEBUG_STYLES[26] = new LineStyle(-0.26D, 1.23D, -0.42D, 0.055D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[27] = new LineStyle(-0.26D, 1.64D, -0.42D, 0.015D, 0.8D, 0xFF000000, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[28] = new LineStyle(0.58D, 1.35D, -0.42D, 0.04D, 0.36D, 0xFF007F00, true, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[29] = new LineStyle(-0.8D, -0.6D, -0.42D, 0.05D, 0.8D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[30] = new LineStyle(0.02D, 0.55D, -0.42D, 0.05D, 2.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		DEBUG_STYLES[31] = new LineStyle(0.02D, 0.0D, -0.42D, 0.05D, 2.5D, 0xFFBEBEBE, false, LineStyle.ALIGN_CENTER);
		INTER_GOING_S_T[1] = DEBUG_STYLES[26];
		INTER_GOING_S_T[2] = DEBUG_STYLES[27];
		INTER_GOING_S_T[3] = DEBUG_STYLES[28];
		INTER_GOING_S_T[4] = DEBUG_STYLES[29];
		INTER_GOING_S_T[5] = DEBUG_STYLES[30];
		INTER_GOING_S_T[6] = DEBUG_STYLES[31];
		INTER_GOING_G_T[1] = DEBUG_STYLES[26];
		INTER_GOING_G_T[3] = DEBUG_STYLES[28];
		INTER_GOING_G_T[4] = DEBUG_STYLES[29];
		INTER_GOING_G_T[5] = DEBUG_STYLES[30];
		INTER_GOING_G_T[6] = DEBUG_STYLES[31];
		// 99 严管路段下方文本（slot 2，strict_road/strict_road_2 共享）
		DEBUG_STYLES[99] = new LineStyle(0.02D, 0.2D, 0.20D, 0.015D, 0.95D, 0xFF000000, true, LineStyle.ALIGN_CENTER);
		STRICT_ROAD_T[1] = new LineStyle(0.02D, 0.45D, 0.20D, 0.02D, 0.85D, 0xFF000000, true, LineStyle.ALIGN_CENTER);
		STRICT_ROAD_T[2] = DEBUG_STYLES[99];
	}

	public static class LineStyle {
		public static final int ALIGN_LEFT = -1;
		public static final int ALIGN_CENTER = 0;
		public static final int ALIGN_RIGHT = 1;

		private final double x;
		private final double y;
		private final double z;
		private final double size;
		private final double widthLimit;
		private final int color;
		private final boolean bold;
		private final int align;

		public LineStyle(double x, double y, double z, double size, double widthLimit, int color) {
			this(x, y, z, size, widthLimit, color, true, ALIGN_CENTER);
		}

		public LineStyle(double x, double y, double z, double size, double widthLimit, int color, boolean bold) {
			this(x, y, z, size, widthLimit, color, bold, ALIGN_CENTER);
		}

		public LineStyle(double x, double y, double z, double size, double widthLimit, int color, boolean bold, int align) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.size = size;
			this.widthLimit = widthLimit;
			this.color = color;
			this.bold = bold;
			this.align = align;
		}

		public double x() { return x; }
		public double y() { return y; }
		public double z() { return z; }
		public double size() { return size; }
		public double widthLimit() { return widthLimit; }
		public int color() { return color; }
		public boolean bold() { return bold; }
		public int align() { return align; }
	}

	@SubscribeEvent
	public static void onRegisterPayloads(RegisterPayloadHandlersEvent event) {
		event.registrar(JunjietrafficmodMod.MODID).versioned(PROTOCOL_VERSION).optional()
				.playToServer(SaveSignTextMessage.TYPE, SaveSignTextMessage.STREAM_CODEC, SaveSignTextMessage::handle);
	}

	public static void onEditButtonPressed(int x, int y, int z, String text) {
		onEditButtonPressed(x, y, z, 1, text);
	}

	public static final String PROTOCOL_VERSION = "1";

	public static void onEditButtonPressed(int x, int y, int z, int line, String text) {
		String safe = text == null ? "" : text.trim();
		if (safe.length() > MAX_TEXT_LENGTH)
			safe = safe.substring(0, MAX_TEXT_LENGTH);
		PacketDistributor.sendToServer(new SaveSignTextMessage(new BlockPos(x, y, z), line, safe));
	}

	@OnlyIn(Dist.CLIENT)
	public static void prefillEditBox(int x, int y, int z, EditBox box) {
		prefillEditBox(x, y, z, 1, box);
	}

	@OnlyIn(Dist.CLIENT)
	public static void prefillEditBox(int x, int y, int z, int line, EditBox box) {
		Level level = Minecraft.getInstance().level;
		if (level == null)
			return;
		BlockEntity blockEntity = level.getBlockEntity(new BlockPos(x, y, z));
		if (blockEntity == null)
			return;
		String value = blockEntity.getPersistentData().getString(crossNbtKey(line));
		box.setValue(value);
	}

	public static String crossNbtKey(int line) {
		return line == 0 ? SIGN_TEXT_NBT_KEY + "Direction" : SIGN_TEXT_NBT_KEY + line;
	}

	public record SaveSignTextMessage(BlockPos pos, int line, String text) implements CustomPacketPayload {
		public static final CustomPacketPayload.Type<SaveSignTextMessage> TYPE = new CustomPacketPayload.Type<>(
				ResourceLocation.fromNamespaceAndPath(JunjietrafficmodMod.MODID, "save_sign_text"));

		public static final StreamCodec<RegistryFriendlyByteBuf, SaveSignTextMessage> STREAM_CODEC = StreamCodec.of(
				(buf, msg) -> {
					buf.writeBlockPos(msg.pos());
					buf.writeVarInt(msg.line());
					buf.writeUtf(msg.text(), MAX_TEXT_LENGTH);
				},
				buf -> new SaveSignTextMessage(buf.readBlockPos(), buf.readVarInt(), buf.readUtf(MAX_TEXT_LENGTH)));

		@Override
		public Type<? extends CustomPacketPayload> type() {
			return TYPE;
		}

		public static void handle(SaveSignTextMessage msg, IPayloadContext ctx) {
			ctx.enqueueWork(() -> {
				if (!(ctx.player() instanceof ServerPlayer player))
					return;
				Level level = player.level();
				BlockPos pos = msg.pos();
				if (player.distanceToSqr(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D) > MAX_EDIT_DISTANCE_SQR)
					return;
				BlockEntity blockEntity = level.getBlockEntity(pos);
				if (blockEntity == null)
					return;
				int line = Math.max(0, Math.min(MAX_SIGN_LINE, msg.line()));
				blockEntity.getPersistentData().putString(crossNbtKey(line), msg.text());
				blockEntity.setChanged();
				if (level instanceof ServerLevel serverLevel) {
					ClientboundBlockEntityDataPacket packet = ClientboundBlockEntityDataPacket.create(blockEntity);
					for (ServerPlayer viewer : serverLevel.getChunkSource().chunkMap.getPlayers(new ChunkPos(pos), false))
						viewer.connection.send(packet);
				}
			});
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class SignLineRenderer implements BlockEntityRenderer<BlockEntity> {

		private final Font font;

		public SignLineRenderer(BlockEntityRendererProvider.Context context) {
			this.font = context.getFont();
		}

		@Override
		public void render(BlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
			BlockState state = blockEntity.getBlockState();
			boolean interchange = state.getBlock() instanceof Interchange1kmBlock || state.getBlock() instanceof Interchange2kmBlock;
			boolean exit = state.getBlock() instanceof ExitgBlock || state.getBlock() instanceof ExitsBlock
					|| state.getBlock() instanceof ExitxyBlock || state.getBlock() instanceof ExitrBlock
					|| state.getBlock() instanceof ExitnBlock || state.getBlock() instanceof RoadGBlock
					|| state.getBlock() instanceof RoadSBlock || state.getBlock() instanceof RoadXYBlock
					|| state.getBlock() instanceof RoadSideGBlock || state.getBlock() instanceof RoadSideSBlock
					|| state.getBlock() instanceof RoadSideXYBlock || state.getBlock() instanceof ExpwyGBlock
					|| state.getBlock() instanceof ExpwySBlock || state.getBlock() instanceof MileageRBlock
					|| state.getBlock() instanceof MileageRGBlock || state.getBlock() instanceof MileageRSBlock
					|| state.getBlock() instanceof MileageRXYBlock || state.getBlock() instanceof MileageRNBlock
					|| state.getBlock() instanceof LimitCarBlock || state.getBlock() instanceof LimitTruckBlock;
			boolean entrance = state.getBlock() instanceof EntranceE1GBlock || state.getBlock() instanceof EntranceE1SBlock
					|| state.getBlock() instanceof EntranceE2Block || state.getBlock() instanceof Fwq21Block
					|| state.getBlock() instanceof Fwq22Block;
			boolean tunableGroup = state.getBlock() instanceof HORplacereportBlock
					|| state.getBlock() instanceof InterchangeA1Block || state.getBlock() instanceof InterchangeA2Block
					|| state.getBlock() instanceof InterchangeB1Block || state.getBlock() instanceof InterchangeB2Block
					|| state.getBlock() instanceof GantryExpwyGnumberBlock || state.getBlock() instanceof GantryExpwySnumberBlock
					|| state.getBlock() instanceof SIDEexitnumberBlock || state.getBlock() instanceof SIDEtunnelBlock
					|| state.getBlock() instanceof SIDEbarrierBlock
					|| state.getBlock() instanceof GantryPileNumberBlock;
			boolean crossGroup = state.getBlock() instanceof SIDEcross1Block || state.getBlock() instanceof SIDEcross2Block
					|| state.getBlock() instanceof SIDEcross3Block || state.getBlock() instanceof SIDEcross4Block;
			boolean debugGroup = state.getBlock() instanceof ServiceAreaEntranceBlock
					|| state.getBlock() instanceof ExitNumberShowBlock || state.getBlock() instanceof BridgeBlock
					|| state.getBlock() instanceof ExitreportBlock || state.getBlock() instanceof NextexitBlock
					|| state.getBlock() instanceof ExpwyExitStraightBlock || state.getBlock() instanceof ExpwyExitRightBlock
					|| state.getBlock() instanceof RoadExitStraightBlock || state.getBlock() instanceof RoadExitRightBlock
					|| state.getBlock() instanceof GantryGInterStraightBlock || state.getBlock() instanceof GantryGInterRightBlock
					|| state.getBlock() instanceof GantryGInterLeftBlock
					|| state.getBlock() instanceof GantrySInterStraightBlock || state.getBlock() instanceof GantrySInterRightBlock
					|| state.getBlock() instanceof GantrySInterLeftBlock
					|| state.getBlock() instanceof StrictRoadBlock || state.getBlock() instanceof StrictRoad2Block;
			if (!interchange && !exit && !entrance && !tunableGroup && !crossGroup && !debugGroup)
				return;
			Direction facing = readFacing(state);
			if (facing == null)
				return;
			Vec3 cameraPos = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition();
			double relX = cameraPos.x - (blockEntity.getBlockPos().getX() + 0.5);
			double relY = cameraPos.y - (blockEntity.getBlockPos().getY() + 0.5);
			double relZ = cameraPos.z - (blockEntity.getBlockPos().getZ() + 0.5);
			double facingDot = relX * facing.getStepX() + relY * facing.getStepY() + relZ * facing.getStepZ();
			if (facingDot <= 0.0)
				return;
			poseStack.pushPose();
			poseStack.translate(0.5F, 0.0F, 0.5F);
			poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));
			if (interchange) {
				String text = blockEntity.getPersistentData().getString(SIGN_TEXT_NBT_KEY + 1);
				if (text.isEmpty())
					text = blockEntity.getPersistentData().getString(SIGN_TEXT_NBT_KEY);
				if (!text.isEmpty())
					drawSlot(text, INTERCHANGE_STYLE, poseStack, buffer, packedLight);
			} else if (crossGroup) {
			String dirText = blockEntity.getPersistentData().getString(crossNbtKey(0));
			if (!dirText.isEmpty())
				drawSlot(dirText, CROSS_DIRECTION_STYLE, poseStack, buffer, packedLight);
			LineStyle[] styles = selectCrossStyles(state);
			for (int slot = 1; slot <= CROSS_SLOT_COUNT; slot++) {
				if (styles[slot] == null)
					continue;
				String text = blockEntity.getPersistentData().getString(crossNbtKey(slot));
				if (!text.isEmpty())
					drawSlot(text, styles[slot], poseStack, buffer, packedLight);
			}
		} else if (debugGroup) {
			LineStyle[] styles = selectTunableStyles(state);
			int slots = tunableSlotCount(state);
			for (int slot = 1; slot <= slots; slot++) {
				if (styles[slot] == null)
					continue;
				String text = blockEntity.getPersistentData().getString(SIGN_TEXT_NBT_KEY + slot);
				if (!text.isEmpty())
					drawSlot(text, styles[slot], poseStack, buffer, packedLight);
			}
		} else {
			LineStyle[] styles = selectStyles(state);
			for (int slot = 1; slot <= SIGN_LINE_COUNT; slot++) {
					if (styles[slot] == null)
						continue;
					String text = blockEntity.getPersistentData().getString(SIGN_TEXT_NBT_KEY + slot);
					if (!text.isEmpty())
						drawSlot(text, styles[slot], poseStack, buffer, packedLight);
				}
			}
			poseStack.popPose();
		}

		@Override
		public boolean shouldRenderOffScreen(BlockEntity blockEntity) {
			return true;
		}

		private Direction readFacing(BlockState state) {
			if (state.getBlock() instanceof Interchange1kmBlock)
				return state.getValue(Interchange1kmBlock.FACING);
			if (state.getBlock() instanceof Interchange2kmBlock)
				return state.getValue(Interchange2kmBlock.FACING);
			if (state.getBlock() instanceof ExitgBlock)
				return state.getValue(ExitgBlock.FACING);
			if (state.getBlock() instanceof ExitsBlock)
				return state.getValue(ExitsBlock.FACING);
			if (state.getBlock() instanceof ExitxyBlock)
				return state.getValue(ExitxyBlock.FACING);
			if (state.getBlock() instanceof ExitrBlock)
				return state.getValue(ExitrBlock.FACING);
			if (state.getBlock() instanceof ExitnBlock)
				return state.getValue(ExitnBlock.FACING);
			if (state.getBlock() instanceof RoadGBlock)
				return state.getValue(RoadGBlock.FACING);
			if (state.getBlock() instanceof RoadSBlock)
				return state.getValue(RoadSBlock.FACING);
			if (state.getBlock() instanceof RoadXYBlock)
				return state.getValue(RoadXYBlock.FACING);
			if (state.getBlock() instanceof RoadSideGBlock)
				return state.getValue(RoadSideGBlock.FACING);
			if (state.getBlock() instanceof RoadSideSBlock)
				return state.getValue(RoadSideSBlock.FACING);
			if (state.getBlock() instanceof RoadSideXYBlock)
				return state.getValue(RoadSideXYBlock.FACING);
			if (state.getBlock() instanceof ExpwyGBlock)
				return state.getValue(ExpwyGBlock.FACING);
			if (state.getBlock() instanceof ExpwySBlock)
				return state.getValue(ExpwySBlock.FACING);
			if (state.getBlock() instanceof MileageRBlock)
				return state.getValue(MileageRBlock.FACING);
			if (state.getBlock() instanceof MileageRGBlock)
				return state.getValue(MileageRGBlock.FACING);
			if (state.getBlock() instanceof MileageRSBlock)
				return state.getValue(MileageRSBlock.FACING);
			if (state.getBlock() instanceof MileageRXYBlock)
				return state.getValue(MileageRXYBlock.FACING);
			if (state.getBlock() instanceof MileageRNBlock)
				return state.getValue(MileageRNBlock.FACING);
			if (state.getBlock() instanceof LimitCarBlock)
				return state.getValue(LimitCarBlock.FACING);
			if (state.getBlock() instanceof LimitTruckBlock)
				return state.getValue(LimitTruckBlock.FACING);
			if (state.getBlock() instanceof EntranceE1GBlock)
				return state.getValue(EntranceE1GBlock.FACING);
			if (state.getBlock() instanceof EntranceE1SBlock)
				return state.getValue(EntranceE1SBlock.FACING);
			if (state.getBlock() instanceof EntranceE2Block)
				return state.getValue(EntranceE2Block.FACING);
			if (state.getBlock() instanceof Fwq21Block)
				return state.getValue(Fwq21Block.FACING);
			if (state.getBlock() instanceof Fwq22Block)
				return state.getValue(Fwq22Block.FACING);
			if (state.getBlock() instanceof HORplacereportBlock)
				return state.getValue(HORplacereportBlock.FACING);
			if (state.getBlock() instanceof InterchangeA1Block)
				return state.getValue(InterchangeA1Block.FACING);
			if (state.getBlock() instanceof InterchangeA2Block)
				return state.getValue(InterchangeA2Block.FACING);
			if (state.getBlock() instanceof InterchangeB1Block)
				return state.getValue(InterchangeB1Block.FACING);
			if (state.getBlock() instanceof InterchangeB2Block)
				return state.getValue(InterchangeB2Block.FACING);
			if (state.getBlock() instanceof GantryExpwyGnumberBlock)
				return state.getValue(GantryExpwyGnumberBlock.FACING);
			if (state.getBlock() instanceof GantryExpwySnumberBlock)
				return state.getValue(GantryExpwySnumberBlock.FACING);
			if (state.getBlock() instanceof SIDEexitnumberBlock)
				return state.getValue(SIDEexitnumberBlock.FACING);
			if (state.getBlock() instanceof SIDEtunnelBlock)
				return state.getValue(SIDEtunnelBlock.FACING);
			if (state.getBlock() instanceof SIDEbarrierBlock)
				return state.getValue(SIDEbarrierBlock.FACING);
			if (state.getBlock() instanceof StrictRoadBlock)
				return state.getValue(StrictRoadBlock.FACING);
			if (state.getBlock() instanceof GantryPileNumberBlock)
				return state.getValue(GantryPileNumberBlock.FACING);
			if (state.getBlock() instanceof SIDEcross1Block)
				return state.getValue(SIDEcross1Block.FACING);
			if (state.getBlock() instanceof SIDEcross2Block)
				return state.getValue(SIDEcross2Block.FACING);
			if (state.getBlock() instanceof SIDEcross3Block)
				return state.getValue(SIDEcross3Block.FACING);
			if (state.getBlock() instanceof SIDEcross4Block)
			return state.getValue(SIDEcross4Block.FACING);
		if (state.getBlock() instanceof StrictRoad2Block)
			return state.getValue(StrictRoad2Block.FACING);
		if (state.getBlock() instanceof ServiceAreaEntranceBlock)
			return state.getValue(ServiceAreaEntranceBlock.FACING);
		if (state.getBlock() instanceof ExitNumberShowBlock)
			return state.getValue(ExitNumberShowBlock.FACING);
		if (state.getBlock() instanceof BridgeBlock)
			return state.getValue(BridgeBlock.FACING);
		if (state.getBlock() instanceof ExitreportBlock)
			return state.getValue(ExitreportBlock.FACING);
		if (state.getBlock() instanceof NextexitBlock)
			return state.getValue(NextexitBlock.FACING);
		if (state.getBlock() instanceof ExpwyExitStraightBlock)
			return state.getValue(ExpwyExitStraightBlock.FACING);
		if (state.getBlock() instanceof ExpwyExitRightBlock)
			return state.getValue(ExpwyExitRightBlock.FACING);
		if (state.getBlock() instanceof RoadExitStraightBlock)
			return state.getValue(RoadExitStraightBlock.FACING);
		if (state.getBlock() instanceof RoadExitRightBlock)
			return state.getValue(RoadExitRightBlock.FACING);
		if (state.getBlock() instanceof GantryGInterStraightBlock)
			return state.getValue(GantryGInterStraightBlock.FACING);
		if (state.getBlock() instanceof GantryGInterRightBlock)
			return state.getValue(GantryGInterRightBlock.FACING);
		if (state.getBlock() instanceof GantryGInterLeftBlock)
			return state.getValue(GantryGInterLeftBlock.FACING);
		if (state.getBlock() instanceof GantrySInterStraightBlock)
			return state.getValue(GantrySInterStraightBlock.FACING);
		if (state.getBlock() instanceof GantrySInterRightBlock)
			return state.getValue(GantrySInterRightBlock.FACING);
		if (state.getBlock() instanceof GantrySInterLeftBlock)
			return state.getValue(GantrySInterLeftBlock.FACING);
		return null;
	}

		private LineStyle[] selectStyles(BlockState state) {
			if (state.getBlock() instanceof ExitgBlock)
				return EXITG_STYLES;
			if (state.getBlock() instanceof ExitsBlock || state.getBlock() instanceof ExitxyBlock)
				return EXITSXY_STYLES;
			if (state.getBlock() instanceof ExitrBlock)
				return EXITR_STYLES;
			if (state.getBlock() instanceof ExitnBlock)
				return EXITN_STYLES;
			if (state.getBlock() instanceof RoadGBlock)
				return ROADG_STYLES;
			if (state.getBlock() instanceof RoadSBlock || state.getBlock() instanceof RoadXYBlock)
				return ROAD_STYLES;
			if (state.getBlock() instanceof RoadSideGBlock)
				return ROADSIDE_G_STYLES;
			if (state.getBlock() instanceof RoadSideSBlock || state.getBlock() instanceof RoadSideXYBlock)
				return ROADSIDE_STYLES;
			if (state.getBlock() instanceof MileageRGBlock)
				return MILEAGE_RG_STYLES;
			if (state.getBlock() instanceof MileageRSBlock || state.getBlock() instanceof MileageRXYBlock)
				return MILEAGE_RSXY_STYLES;
			if (state.getBlock() instanceof MileageRBlock || state.getBlock() instanceof MileageRNBlock)
				return MILEAGE_RN_STYLES;
			if (state.getBlock() instanceof LimitCarBlock || state.getBlock() instanceof LimitTruckBlock)
				return LIMIT_STYLES;
			if (state.getBlock() instanceof EntranceE1GBlock)
				return ENTRANCE_G_STYLES;
			if (state.getBlock() instanceof EntranceE1SBlock)
				return ENTRANCE_S_STYLES;
			if (state.getBlock() instanceof EntranceE2Block)
				return ENTRANCE_2_STYLES;
			if (state.getBlock() instanceof Fwq21Block)
				return FWQ21_STYLES;
			if (state.getBlock() instanceof Fwq22Block)
				return FWQ22_STYLES;
			if (state.getBlock() instanceof HORplacereportBlock)
				return PLACE_REPORT_STYLES;
			if (state.getBlock() instanceof InterchangeA1Block || state.getBlock() instanceof InterchangeA2Block)
				return INTERCHANGE_A_STYLES;
			if (state.getBlock() instanceof InterchangeB1Block || state.getBlock() instanceof InterchangeB2Block)
				return INTERCHANGE_B_STYLES;
			if (state.getBlock() instanceof GantryExpwyGnumberBlock)
				return GANTRY_GNUMBER_STYLES;
			if (state.getBlock() instanceof GantryExpwySnumberBlock)
				return GANTRY_SNUMBER_STYLES;
			if (state.getBlock() instanceof SIDEexitnumberBlock)
				return EXITNUMBER_STYLES;
			if (state.getBlock() instanceof SIDEbarrierBlock)
				return BARRIER_STYLES;
			if (state.getBlock() instanceof SIDEtunnelBlock)
				return TUNNEL_STYLES;
		if (state.getBlock() instanceof GantryPileNumberBlock)
			return PILE_STYLES;
		return EXPWY_STYLES;
	}

	private LineStyle[] selectTunableStyles(BlockState state) {
		if (state.getBlock() instanceof ServiceAreaEntranceBlock)
			return SERVICE_AREA_T;
		if (state.getBlock() instanceof ExitNumberShowBlock)
			return EXIT_NUMBER_SHOW_T;
		if (state.getBlock() instanceof BridgeBlock)
			return BRIDGE_T;
		if (state.getBlock() instanceof ExitreportBlock)
			return EXPORT_REPORT_T;
		if (state.getBlock() instanceof NextexitBlock)
			return NEXT_EXIT_T;
		if (state.getBlock() instanceof ExpwyExitStraightBlock || state.getBlock() instanceof ExpwyExitRightBlock
				|| state.getBlock() instanceof RoadExitStraightBlock || state.getBlock() instanceof RoadExitRightBlock)
			return EXIT_PLACE_T;
		if (state.getBlock() instanceof GantryGInterStraightBlock || state.getBlock() instanceof GantryGInterRightBlock
				|| state.getBlock() instanceof GantryGInterLeftBlock)
			return INTER_GOING_G_T;
		if (state.getBlock() instanceof GantrySInterStraightBlock || state.getBlock() instanceof GantrySInterRightBlock
				|| state.getBlock() instanceof GantrySInterLeftBlock)
			return INTER_GOING_S_T;
		if (state.getBlock() instanceof StrictRoadBlock || state.getBlock() instanceof StrictRoad2Block)
			return STRICT_ROAD_T;
		return SERVICE_AREA_T;
	}

	private int tunableSlotCount(BlockState state) {
		if (state.getBlock() instanceof ExitNumberShowBlock)
			return 1;
		if (state.getBlock() instanceof ServiceAreaEntranceBlock)
			return 2;
		if (state.getBlock() instanceof BridgeBlock || state.getBlock() instanceof NextexitBlock)
			return 3;
		if (state.getBlock() instanceof ExpwyExitStraightBlock || state.getBlock() instanceof ExpwyExitRightBlock
				|| state.getBlock() instanceof RoadExitStraightBlock || state.getBlock() instanceof RoadExitRightBlock)
			return 4;
		if (state.getBlock() instanceof GantryGInterStraightBlock || state.getBlock() instanceof GantryGInterRightBlock
				|| state.getBlock() instanceof GantryGInterLeftBlock
				|| state.getBlock() instanceof GantrySInterStraightBlock || state.getBlock() instanceof GantrySInterRightBlock
				|| state.getBlock() instanceof GantrySInterLeftBlock)
			return 6;
		if (state.getBlock() instanceof ExitreportBlock)
			return 12;
		if (state.getBlock() instanceof StrictRoadBlock || state.getBlock() instanceof StrictRoad2Block)
			return 2;
		return 1;
	}

	private void drawSlot(String text, LineStyle style, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		drawSlotRaw(text, style.x(), style.y(), style.z(), style.size(), style.widthLimit(), style.color(), style.bold(), style.align(), poseStack, buffer, packedLight);
	}

	private LineStyle[] selectCrossStyles(BlockState state) {
		if (state.getBlock() instanceof SIDEcross1Block)
			return CROSS_A_STYLES;
		if (state.getBlock() instanceof SIDEcross2Block)
			return CROSS_B_STYLES;
		if (state.getBlock() instanceof SIDEcross3Block)
			return CROSS_C_STYLES;
		if (state.getBlock() instanceof SIDEcross4Block)
			return CROSS_D_STYLES;
		return CROSS_A_STYLES;
	}

	private void drawSlotRaw(String text, double x, double y, double z, double size, double widthLimit, int color, boolean bold, int align, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
			Style textStyle = bold ? Style.EMPTY.withBold(true) : Style.EMPTY;
			Component component = Component.literal(text).withStyle(textStyle);
			float w = font.width(component);
			float scaleY = (float) size;
			float scaleX = Math.min(scaleY, (float) widthLimit / Math.max(1, w));
			float offsetX = align < 0 ? 0.0F : align > 0 ? -w : -w / 2.0F;
			poseStack.pushPose();
			poseStack.translate((float) x, (float) y, (float) z);
			poseStack.scale(scaleX, -scaleY, scaleY);
			font.drawInBatch(component, offsetX, -font.lineHeight / 2.0F, color, false,
					poseStack.last().pose(), buffer, Font.DisplayMode.POLYGON_OFFSET, 0, packedLight);
			poseStack.popPose();
		}
	}
}
