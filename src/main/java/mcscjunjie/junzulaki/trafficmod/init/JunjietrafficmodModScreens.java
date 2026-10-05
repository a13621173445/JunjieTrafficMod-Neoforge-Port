
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package mcscjunjie.junzulaki.trafficmod.init;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.api.distmarker.Dist;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

import mcscjunjie.junzulaki.trafficmod.JunjietrafficmodMod;

import mcscjunjie.junzulaki.trafficmod.client.gui.BarrierEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.BridgeEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.CrossEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitGSXYeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitNeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitNumberEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitReditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExitplacereportScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyEntrance2Screen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyEntranceG1Screen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyEntranceS1Screen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyExportReportEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwyGeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ExpwySeditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.Fwq21EditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.Fwq22EditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantryExpwyGEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantryExpwySEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantryPileNumberEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.GantrySpeedLimitScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.InterchangeEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.InterchangeInfoEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.IntergoingEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.MileageEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.NextexitEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.PlaceReportScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.RoadNumberEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.ServiceAreaEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.StrictRoadEditScreen;
import mcscjunjie.junzulaki.trafficmod.client.gui.TunnelEditScreen;

@EventBusSubscriber(modid = JunjietrafficmodMod.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JunjietrafficmodModScreens {
	@SubscribeEvent
	public static void registerScreens(RegisterMenuScreensEvent event) {
			event.register(JunjietrafficmodModMenus.INTERCHANGE_EDIT.get(), InterchangeEditScreen::new);
			event.register(JunjietrafficmodModMenus.EXIT_GSX_YEDIT.get(), ExitGSXYeditScreen::new);
			event.register(JunjietrafficmodModMenus.EXIT_REDIT.get(), ExitReditScreen::new);
			event.register(JunjietrafficmodModMenus.EXIT_NEDIT.get(), ExitNeditScreen::new);
			event.register(JunjietrafficmodModMenus.ROAD_NUMBER_EDIT.get(), RoadNumberEditScreen::new);
			event.register(JunjietrafficmodModMenus.EXPWY_GEDIT.get(), ExpwyGeditScreen::new);
			event.register(JunjietrafficmodModMenus.EXPWY_SEDIT.get(), ExpwySeditScreen::new);
			event.register(JunjietrafficmodModMenus.MILEAGE_EDIT.get(), MileageEditScreen::new);
			event.register(JunjietrafficmodModMenus.GANTRY_SPEED_LIMIT.get(), GantrySpeedLimitScreen::new);
			event.register(JunjietrafficmodModMenus.GANTRY_PILE_NUMBER_EDIT.get(), GantryPileNumberEditScreen::new);
			event.register(JunjietrafficmodModMenus.EXPWY_ENTRANCE_G_1.get(), ExpwyEntranceG1Screen::new);
			event.register(JunjietrafficmodModMenus.EXPWY_ENTRANCE_S_1.get(), ExpwyEntranceS1Screen::new);
			event.register(JunjietrafficmodModMenus.EXPWY_ENTRANCE_2.get(), ExpwyEntrance2Screen::new);
			event.register(JunjietrafficmodModMenus.FWQ_21_EDIT.get(), Fwq21EditScreen::new);
			event.register(JunjietrafficmodModMenus.FWQ_22_EDIT.get(), Fwq22EditScreen::new);
			event.register(JunjietrafficmodModMenus.GANTRY_EXPWY_G_EDIT.get(), GantryExpwyGEditScreen::new);
			event.register(JunjietrafficmodModMenus.GANTRY_EXPWY_S_EDIT.get(), GantryExpwySEditScreen::new);
			event.register(JunjietrafficmodModMenus.INTERCHANGE_INFO_EDIT.get(), InterchangeInfoEditScreen::new);
			event.register(JunjietrafficmodModMenus.PLACE_REPORT.get(), PlaceReportScreen::new);
			event.register(JunjietrafficmodModMenus.STRICT_ROAD_EDIT.get(), StrictRoadEditScreen::new);
			event.register(JunjietrafficmodModMenus.CROSS_EDIT.get(), CrossEditScreen::new);
			event.register(JunjietrafficmodModMenus.EXIT_NUMBER_EDIT.get(), ExitNumberEditScreen::new);
			event.register(JunjietrafficmodModMenus.BARRIER_EDIT.get(), BarrierEditScreen::new);
			event.register(JunjietrafficmodModMenus.TUNNEL_EDIT.get(), TunnelEditScreen::new);
			event.register(JunjietrafficmodModMenus.EXITPLACEREPORT.get(), ExitplacereportScreen::new);
			event.register(JunjietrafficmodModMenus.BRIDGE_EDIT.get(), BridgeEditScreen::new);
			event.register(JunjietrafficmodModMenus.NEXTEXIT_EDIT.get(), NextexitEditScreen::new);
			event.register(JunjietrafficmodModMenus.EXPWY_EXPORT_REPORT_EDIT.get(), ExpwyExportReportEditScreen::new);
			event.register(JunjietrafficmodModMenus.INTERGOING_EDIT.get(), IntergoingEditScreen::new);
			event.register(JunjietrafficmodModMenus.SERVICE_AREA_EDIT.get(), ServiceAreaEditScreen::new);
	}
}
