package mcscjunjie.junzulaki.trafficmod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import mcscjunjie.junzulaki.trafficmod.init.JunjietrafficmodModTabs;
import mcscjunjie.junzulaki.trafficmod.init.JunjietrafficmodModMenus;
import mcscjunjie.junzulaki.trafficmod.init.JunjietrafficmodModItems;
import mcscjunjie.junzulaki.trafficmod.init.JunjietrafficmodModBlocks;
import mcscjunjie.junzulaki.trafficmod.init.JunjietrafficmodModBlockEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("junjietrafficmod")
public class JunjietrafficmodMod {
	public static final Logger LOGGER = LogManager.getLogger(JunjietrafficmodMod.class);
	public static final String MODID = "junjietrafficmod";

	public JunjietrafficmodMod(IEventBus bus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		NeoForge.EVENT_BUS.register(this);
		JunjietrafficmodModBlocks.REGISTRY.register(bus);
		JunjietrafficmodModBlockEntities.REGISTRY.register(bus);
		JunjietrafficmodModItems.REGISTRY.register(bus);
		JunjietrafficmodModTabs.REGISTRY.register(bus);
		JunjietrafficmodModMenus.REGISTRY.register(bus);
		// Start of user code block mod init
		if (net.neoforged.fml.loading.FMLEnvironment.dist == net.neoforged.api.distmarker.Dist.CLIENT) {
			bus.addListener(this::registerEntityRenderers);
		}
		// End of user code block mod init
	}

	// Start of user code block mod methods
	private void registerEntityRenderers(net.neoforged.neoforge.client.event.EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.INTERCHANGE_1KM.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.INTERCHANGE_2KM.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXITG.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXITS.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXITXY.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXITR.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXITN.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_G.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_S.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_XY.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_SIDE_G.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_SIDE_S.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_SIDE_XY.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXPWY_G.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXPWY_S.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.MILEAGE_R.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.MILEAGE_RG.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.MILEAGE_RS.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.MILEAGE_RXY.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.MILEAGE_RN.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.LIMIT_CAR.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.LIMIT_TRUCK.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_PILE_NUMBER.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ENTRANCE_E_1_G.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ENTRANCE_E_1_S.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ENTRANCE_E_2.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.FWQ_21.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.FWQ_22.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.HO_RPLACEREPORT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.INTERCHANGE_A_1.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.INTERCHANGE_A_2.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.INTERCHANGE_B_1.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.INTERCHANGE_B_2.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_EXPWY_GNUMBER.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_EXPWY_SNUMBER.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.STRICT_ROAD.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_EBARRIER.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_ETUNNEL.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_EEXITNUMBER.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_ECROSS_1.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_ECROSS_2.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_ECROSS_3.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SID_ECROSS_4.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.SERVICE_AREA_ENTRANCE.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXIT_NUMBER_SHOW.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.BRIDGE.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXITREPORT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.NEXTEXIT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXPWY_EXIT_STRAIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.EXPWY_EXIT_RIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_EXIT_STRAIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.ROAD_EXIT_RIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_G_INTER_STRAIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_G_INTER_RIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_G_INTER_LEFT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_S_INTER_STRAIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_S_INTER_RIGHT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.GANTRY_S_INTER_LEFT.get(), TextEngine.SignLineRenderer::new);
		event.registerBlockEntityRenderer(JunjietrafficmodModBlockEntities.STRICT_ROAD_2.get(), TextEngine.SignLineRenderer::new);
	}

	// End of user code block mod methods

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setValue(work.getValue() - 1);
			if (work.getValue() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getKey().run());
		workQueue.removeAll(actions);
	}
}
