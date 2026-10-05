
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mcscjunjie.junzulaki.trafficmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import mcscjunjie.junzulaki.trafficmod.client.gui.TunnelEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.StrictRoadEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ServiceAreaEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.RoadNumberEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.PlaceReportScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.NextexitEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.MileageEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.IntergoingEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.InterchangeInfoEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.InterchangeEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantrySpeedLimitScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantryPileNumberEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantryExpwySEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantryExpwyGEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.Fwq22EditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.Fwq21EditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwySeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyGeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyExportReportEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyEntranceS1Screen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyEntranceG1Screen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyEntrance2Screen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitplacereportScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitReditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitNumberEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitNeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitGSXYeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.CrossEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.BridgeEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.BarrierEditScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JunjietrafficmodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(JunjietrafficmodModMenus.INTERCHANGE_EDIT.get(), InterchangeEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXIT_GSX_YEDIT.get(), ExitGSXYeditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXIT_REDIT.get(), ExitReditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXIT_NEDIT.get(), ExitNeditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.ROAD_NUMBER_EDIT.get(), RoadNumberEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXPWY_GEDIT.get(), ExpwyGeditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXPWY_SEDIT.get(), ExpwySeditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.MILEAGE_EDIT.get(), MileageEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.GANTRY_SPEED_LIMIT.get(), GantrySpeedLimitScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.GANTRY_PILE_NUMBER_EDIT.get(), GantryPileNumberEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXPWY_ENTRANCE_G_1.get(), ExpwyEntranceG1Screen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXPWY_ENTRANCE_S_1.get(), ExpwyEntranceS1Screen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXPWY_ENTRANCE_2.get(), ExpwyEntrance2Screen::new);
			MenuScreens.register(JunjietrafficmodModMenus.FWQ_21_EDIT.get(), Fwq21EditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.FWQ_22_EDIT.get(), Fwq22EditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.GANTRY_EXPWY_G_EDIT.get(), GantryExpwyGEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.GANTRY_EXPWY_S_EDIT.get(), GantryExpwySEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.INTERCHANGE_INFO_EDIT.get(), InterchangeInfoEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.PLACE_REPORT.get(), PlaceReportScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.STRICT_ROAD_EDIT.get(), StrictRoadEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.CROSS_EDIT.get(), CrossEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXIT_NUMBER_EDIT.get(), ExitNumberEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.BARRIER_EDIT.get(), BarrierEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.TUNNEL_EDIT.get(), TunnelEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXITPLACEREPORT.get(), ExitplacereportScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.BRIDGE_EDIT.get(), BridgeEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.NEXTEXIT_EDIT.get(), NextexitEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.EXPWY_EXPORT_REPORT_EDIT.get(), ExpwyExportReportEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.INTERGOING_EDIT.get(), IntergoingEditScreen::new);
			MenuScreens.register(JunjietrafficmodModMenus.SERVICE_AREA_EDIT.get(), ServiceAreaEditScreen::new);
		});
	}
}
