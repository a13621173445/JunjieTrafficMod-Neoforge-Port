
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package mcscjunjie.junzulaki.trafficmod.init;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

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
import net.minecraft.core.registries.Registries;

public class JunjietrafficmodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, JunjietrafficmodMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<InterchangeEditMenu>> INTERCHANGE_EDIT = REGISTRY.register("interchange_edit", () -> IMenuTypeExtension.create(InterchangeEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExitGSXYeditMenu>> EXIT_GSX_YEDIT = REGISTRY.register("exit_gsx_yedit", () -> IMenuTypeExtension.create(ExitGSXYeditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExitReditMenu>> EXIT_REDIT = REGISTRY.register("exit_redit", () -> IMenuTypeExtension.create(ExitReditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExitNeditMenu>> EXIT_NEDIT = REGISTRY.register("exit_nedit", () -> IMenuTypeExtension.create(ExitNeditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<RoadNumberEditMenu>> ROAD_NUMBER_EDIT = REGISTRY.register("road_number_edit", () -> IMenuTypeExtension.create(RoadNumberEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExpwyGeditMenu>> EXPWY_GEDIT = REGISTRY.register("expwy_gedit", () -> IMenuTypeExtension.create(ExpwyGeditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExpwySeditMenu>> EXPWY_SEDIT = REGISTRY.register("expwy_sedit", () -> IMenuTypeExtension.create(ExpwySeditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MileageEditMenu>> MILEAGE_EDIT = REGISTRY.register("mileage_edit", () -> IMenuTypeExtension.create(MileageEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GantrySpeedLimitMenu>> GANTRY_SPEED_LIMIT = REGISTRY.register("gantry_speed_limit", () -> IMenuTypeExtension.create(GantrySpeedLimitMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GantryPileNumberEditMenu>> GANTRY_PILE_NUMBER_EDIT = REGISTRY.register("gantry_pile_number_edit", () -> IMenuTypeExtension.create(GantryPileNumberEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExpwyEntranceG1Menu>> EXPWY_ENTRANCE_G_1 = REGISTRY.register("expwy_entrance_g_1", () -> IMenuTypeExtension.create(ExpwyEntranceG1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExpwyEntranceS1Menu>> EXPWY_ENTRANCE_S_1 = REGISTRY.register("expwy_entrance_s_1", () -> IMenuTypeExtension.create(ExpwyEntranceS1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExpwyEntrance2Menu>> EXPWY_ENTRANCE_2 = REGISTRY.register("expwy_entrance_2", () -> IMenuTypeExtension.create(ExpwyEntrance2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Fwq21EditMenu>> FWQ_21_EDIT = REGISTRY.register("fwq_21_edit", () -> IMenuTypeExtension.create(Fwq21EditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Fwq22EditMenu>> FWQ_22_EDIT = REGISTRY.register("fwq_22_edit", () -> IMenuTypeExtension.create(Fwq22EditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GantryExpwyGEditMenu>> GANTRY_EXPWY_G_EDIT = REGISTRY.register("gantry_expwy_g_edit", () -> IMenuTypeExtension.create(GantryExpwyGEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GantryExpwySEditMenu>> GANTRY_EXPWY_S_EDIT = REGISTRY.register("gantry_expwy_s_edit", () -> IMenuTypeExtension.create(GantryExpwySEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InterchangeInfoEditMenu>> INTERCHANGE_INFO_EDIT = REGISTRY.register("interchange_info_edit", () -> IMenuTypeExtension.create(InterchangeInfoEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PlaceReportMenu>> PLACE_REPORT = REGISTRY.register("place_report", () -> IMenuTypeExtension.create(PlaceReportMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StrictRoadEditMenu>> STRICT_ROAD_EDIT = REGISTRY.register("strict_road_edit", () -> IMenuTypeExtension.create(StrictRoadEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CrossEditMenu>> CROSS_EDIT = REGISTRY.register("cross_edit", () -> IMenuTypeExtension.create(CrossEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExitNumberEditMenu>> EXIT_NUMBER_EDIT = REGISTRY.register("exit_number_edit", () -> IMenuTypeExtension.create(ExitNumberEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BarrierEditMenu>> BARRIER_EDIT = REGISTRY.register("barrier_edit", () -> IMenuTypeExtension.create(BarrierEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TunnelEditMenu>> TUNNEL_EDIT = REGISTRY.register("tunnel_edit", () -> IMenuTypeExtension.create(TunnelEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExitplacereportMenu>> EXITPLACEREPORT = REGISTRY.register("exitplacereport", () -> IMenuTypeExtension.create(ExitplacereportMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BridgeEditMenu>> BRIDGE_EDIT = REGISTRY.register("bridge_edit", () -> IMenuTypeExtension.create(BridgeEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NextexitEditMenu>> NEXTEXIT_EDIT = REGISTRY.register("nextexit_edit", () -> IMenuTypeExtension.create(NextexitEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExpwyExportReportEditMenu>> EXPWY_EXPORT_REPORT_EDIT = REGISTRY.register("expwy_export_report_edit", () -> IMenuTypeExtension.create(ExpwyExportReportEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<IntergoingEditMenu>> INTERGOING_EDIT = REGISTRY.register("intergoing_edit", () -> IMenuTypeExtension.create(IntergoingEditMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ServiceAreaEditMenu>> SERVICE_AREA_EDIT = REGISTRY.register("service_area_edit", () -> IMenuTypeExtension.create(ServiceAreaEditMenu::new));
}
