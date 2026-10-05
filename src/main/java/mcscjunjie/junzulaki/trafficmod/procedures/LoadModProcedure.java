package mcscjunjie.junzulaki.trafficmod.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import mcscjunjie.junzulaki.trafficmod.JunjietrafficmodMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LoadModProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		JunjietrafficmodMod.LOGGER.info("\u6B22\u8FCE\u4F7F\u7528JunjieTrafficMod\uFF08Junjie\u7684\u4EA4\u901A\u6A21\u7EC4\uFF09awa");
	}
}
