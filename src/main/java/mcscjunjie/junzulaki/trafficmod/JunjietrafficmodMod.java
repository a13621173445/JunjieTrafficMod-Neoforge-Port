package mcscjunjie.junzulaki.trafficmod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

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

	public JunjietrafficmodMod() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		JunjietrafficmodModBlocks.REGISTRY.register(bus);
		JunjietrafficmodModBlockEntities.REGISTRY.register(bus);
		JunjietrafficmodModItems.REGISTRY.register(bus);
		JunjietrafficmodModTabs.REGISTRY.register(bus);
		JunjietrafficmodModMenus.REGISTRY.register(bus);
		// Start of user code block mod init
		if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
			bus.addListener(this::registerEntityRenderers);
		}
		// End of user code block mod init
	}

	// Start of user code block mod methods
	private void registerEntityRenderers(net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers event) {
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
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
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
}
