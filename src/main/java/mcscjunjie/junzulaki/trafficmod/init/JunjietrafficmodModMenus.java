
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mcscjunjie.junzulaki.trafficmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import mcscjunjie.junzulaki.trafficmod.world.inventory.TunnelEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.StrictRoadEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ServiceAreaEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.RoadNumberEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.PlaceReportMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.NextexitEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.MileageEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.IntergoingEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.InterchangeInfoEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.InterchangeEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.GantrySpeedLimitMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.GantryPileNumberEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.GantryExpwySEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.GantryExpwyGEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.Fwq22EditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.Fwq21EditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwySeditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyGeditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyExportReportEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyEntranceS1Menu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyEntranceG1Menu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyEntrance2Menu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitplacereportMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitReditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitNumberEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitNeditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitGSXYeditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.CrossEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.BridgeEditMenu;
import mcscjunjie.junzulaki.trafficmod.world.inventory.BarrierEditMenu;
import mcscjunjie.junzulaki.trafficmod.JunjietrafficmodMod;

public class JunjietrafficmodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, JunjietrafficmodMod.MODID);
	public static final RegistryObject<MenuType<InterchangeEditMenu>> INTERCHANGE_EDIT = REGISTRY.register("interchange_edit", () -> IForgeMenuType.create(InterchangeEditMenu::new));
	public static final RegistryObject<MenuType<ExitGSXYeditMenu>> EXIT_GSX_YEDIT = REGISTRY.register("exit_gsx_yedit", () -> IForgeMenuType.create(ExitGSXYeditMenu::new));
	public static final RegistryObject<MenuType<ExitReditMenu>> EXIT_REDIT = REGISTRY.register("exit_redit", () -> IForgeMenuType.create(ExitReditMenu::new));
	public static final RegistryObject<MenuType<ExitNeditMenu>> EXIT_NEDIT = REGISTRY.register("exit_nedit", () -> IForgeMenuType.create(ExitNeditMenu::new));
	public static final RegistryObject<MenuType<RoadNumberEditMenu>> ROAD_NUMBER_EDIT = REGISTRY.register("road_number_edit", () -> IForgeMenuType.create(RoadNumberEditMenu::new));
	public static final RegistryObject<MenuType<ExpwyGeditMenu>> EXPWY_GEDIT = REGISTRY.register("expwy_gedit", () -> IForgeMenuType.create(ExpwyGeditMenu::new));
	public static final RegistryObject<MenuType<ExpwySeditMenu>> EXPWY_SEDIT = REGISTRY.register("expwy_sedit", () -> IForgeMenuType.create(ExpwySeditMenu::new));
	public static final RegistryObject<MenuType<MileageEditMenu>> MILEAGE_EDIT = REGISTRY.register("mileage_edit", () -> IForgeMenuType.create(MileageEditMenu::new));
	public static final RegistryObject<MenuType<GantrySpeedLimitMenu>> GANTRY_SPEED_LIMIT = REGISTRY.register("gantry_speed_limit", () -> IForgeMenuType.create(GantrySpeedLimitMenu::new));
	public static final RegistryObject<MenuType<GantryPileNumberEditMenu>> GANTRY_PILE_NUMBER_EDIT = REGISTRY.register("gantry_pile_number_edit", () -> IForgeMenuType.create(GantryPileNumberEditMenu::new));
	public static final RegistryObject<MenuType<ExpwyEntranceG1Menu>> EXPWY_ENTRANCE_G_1 = REGISTRY.register("expwy_entrance_g_1", () -> IForgeMenuType.create(ExpwyEntranceG1Menu::new));
	public static final RegistryObject<MenuType<ExpwyEntranceS1Menu>> EXPWY_ENTRANCE_S_1 = REGISTRY.register("expwy_entrance_s_1", () -> IForgeMenuType.create(ExpwyEntranceS1Menu::new));
	public static final RegistryObject<MenuType<ExpwyEntrance2Menu>> EXPWY_ENTRANCE_2 = REGISTRY.register("expwy_entrance_2", () -> IForgeMenuType.create(ExpwyEntrance2Menu::new));
	public static final RegistryObject<MenuType<Fwq21EditMenu>> FWQ_21_EDIT = REGISTRY.register("fwq_21_edit", () -> IForgeMenuType.create(Fwq21EditMenu::new));
	public static final RegistryObject<MenuType<Fwq22EditMenu>> FWQ_22_EDIT = REGISTRY.register("fwq_22_edit", () -> IForgeMenuType.create(Fwq22EditMenu::new));
	public static final RegistryObject<MenuType<GantryExpwyGEditMenu>> GANTRY_EXPWY_G_EDIT = REGISTRY.register("gantry_expwy_g_edit", () -> IForgeMenuType.create(GantryExpwyGEditMenu::new));
	public static final RegistryObject<MenuType<GantryExpwySEditMenu>> GANTRY_EXPWY_S_EDIT = REGISTRY.register("gantry_expwy_s_edit", () -> IForgeMenuType.create(GantryExpwySEditMenu::new));
	public static final RegistryObject<MenuType<InterchangeInfoEditMenu>> INTERCHANGE_INFO_EDIT = REGISTRY.register("interchange_info_edit", () -> IForgeMenuType.create(InterchangeInfoEditMenu::new));
	public static final RegistryObject<MenuType<PlaceReportMenu>> PLACE_REPORT = REGISTRY.register("place_report", () -> IForgeMenuType.create(PlaceReportMenu::new));
	public static final RegistryObject<MenuType<StrictRoadEditMenu>> STRICT_ROAD_EDIT = REGISTRY.register("strict_road_edit", () -> IForgeMenuType.create(StrictRoadEditMenu::new));
	public static final RegistryObject<MenuType<CrossEditMenu>> CROSS_EDIT = REGISTRY.register("cross_edit", () -> IForgeMenuType.create(CrossEditMenu::new));
	public static final RegistryObject<MenuType<ExitNumberEditMenu>> EXIT_NUMBER_EDIT = REGISTRY.register("exit_number_edit", () -> IForgeMenuType.create(ExitNumberEditMenu::new));
	public static final RegistryObject<MenuType<BarrierEditMenu>> BARRIER_EDIT = REGISTRY.register("barrier_edit", () -> IForgeMenuType.create(BarrierEditMenu::new));
	public static final RegistryObject<MenuType<TunnelEditMenu>> TUNNEL_EDIT = REGISTRY.register("tunnel_edit", () -> IForgeMenuType.create(TunnelEditMenu::new));
	public static final RegistryObject<MenuType<ExitplacereportMenu>> EXITPLACEREPORT = REGISTRY.register("exitplacereport", () -> IForgeMenuType.create(ExitplacereportMenu::new));
	public static final RegistryObject<MenuType<BridgeEditMenu>> BRIDGE_EDIT = REGISTRY.register("bridge_edit", () -> IForgeMenuType.create(BridgeEditMenu::new));
	public static final RegistryObject<MenuType<NextexitEditMenu>> NEXTEXIT_EDIT = REGISTRY.register("nextexit_edit", () -> IForgeMenuType.create(NextexitEditMenu::new));
	public static final RegistryObject<MenuType<ExpwyExportReportEditMenu>> EXPWY_EXPORT_REPORT_EDIT = REGISTRY.register("expwy_export_report_edit", () -> IForgeMenuType.create(ExpwyExportReportEditMenu::new));
	public static final RegistryObject<MenuType<IntergoingEditMenu>> INTERGOING_EDIT = REGISTRY.register("intergoing_edit", () -> IForgeMenuType.create(IntergoingEditMenu::new));
	public static final RegistryObject<MenuType<ServiceAreaEditMenu>> SERVICE_AREA_EDIT = REGISTRY.register("service_area_edit", () -> IForgeMenuType.create(ServiceAreaEditMenu::new));
}
