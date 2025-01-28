package com.christianbutnot.betterenderpearls;

import org.slf4j.Logger;

import com.christianbutnot.betterenderpearls.init.BlockInit;
import com.christianbutnot.betterenderpearls.init.CreativeTabs;
import com.christianbutnot.betterenderpearls.init.ItemInit;
import com.christianbutnot.betterenderpearls.util.LootTableAdditiveMethod;
import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(Main.MODID)
public class Main {
	public static final String MODID = "betterenderpearls";

	public Main(IEventBus eventBus, ModContainer container) {

		CreativeTabs.register(eventBus);
		ItemInit.register(eventBus);
		BlockInit.register(eventBus);
		LootTableAdditiveMethod.register(eventBus);	
	}
	
	private static final Logger LOGGER = LogUtils.getLogger();
	   
	@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("[JustAnotherLibrary] BetterEnderPearls reporting for duty.");
        }
    }

}
