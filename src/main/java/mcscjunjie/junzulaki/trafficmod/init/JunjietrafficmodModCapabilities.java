package mcscjunjie.junzulaki.trafficmod.init;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import mcscjunjie.junzulaki.trafficmod.JunjietrafficmodMod;

@EventBusSubscriber(modid = JunjietrafficmodMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class JunjietrafficmodModCapabilities {
	@SubscribeEvent
	public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.BRIDGE.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ENTRANCE_E_1_G.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ENTRANCE_E_1_S.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ENTRANCE_E_2.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXIT_NUMBER_SHOW.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXITG.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXITN.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXITR.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXITREPORT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXITS.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXITXY.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXPWY_EXIT_RIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXPWY_EXIT_STRAIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXPWY_G.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.EXPWY_S.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.FWQ_21.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.FWQ_22.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_EXPWY_GNUMBER.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_EXPWY_SNUMBER.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_G_INTER_LEFT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_G_INTER_RIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_G_INTER_STRAIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_PILE_NUMBER.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_S_INTER_LEFT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_S_INTER_RIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.GANTRY_S_INTER_STRAIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.HO_RPLACEREPORT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.INTERCHANGE_1KM.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.INTERCHANGE_2KM.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.INTERCHANGE_A_1.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.INTERCHANGE_A_2.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.INTERCHANGE_B_1.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.INTERCHANGE_B_2.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.LIMIT_CAR.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.LIMIT_TRUCK.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.MILEAGE_R.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.MILEAGE_RG.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.MILEAGE_RN.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.MILEAGE_RS.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.MILEAGE_RXY.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.NEXTEXIT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_EXIT_RIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_EXIT_STRAIGHT.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_G.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_S.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_SIDE_G.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_SIDE_S.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_SIDE_XY.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.ROAD_XY.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_EBARRIER.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_ECROSS_1.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_ECROSS_2.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_ECROSS_3.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_ECROSS_4.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_EEXITNUMBER.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SID_ETUNNEL.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.SERVICE_AREA_ENTRANCE.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.STRICT_ROAD_2.get(),
					(be, side) -> be.getHandler(side));
			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, JunjietrafficmodModBlockEntities.STRICT_ROAD.get(),
					(be, side) -> be.getHandler(side));
	}
}
