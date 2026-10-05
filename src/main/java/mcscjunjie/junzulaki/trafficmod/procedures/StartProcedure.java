package mcscjunjie.junzulaki.trafficmod.procedures;

import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import javax.annotation.Nullable;
import net.neoforged.fml.common.EventBusSubscriber;
import mcscjunjie.junzulaki.trafficmod.JunjietrafficmodMod;

@EventBusSubscriber(modid = JunjietrafficmodMod.MODID)
public class StartProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}
