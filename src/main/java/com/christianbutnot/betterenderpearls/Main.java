package com.christianbutnot.betterenderpearls;

import com.christianbutnot.betterenderpearls.init.ItemInit;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Main.MODID)
public class Main {
    public static final String MODID = "betterenderpearls";

    public Main(IEventBus eventBus, ModContainer container) {
        
    	ItemInit.register(eventBus);
    	
    	

        eventBus.addListener(this::addCreative);
    	
    }
    
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.TECHNICAL_ENDERPEARL);
            event.accept(ItemInit.ADVANCED_ENDERPEARL);
            event.accept(ItemInit.ENERGIZED_ENDERPEARL);
            event.accept(ItemInit.IMMORTAL_ENDERPEARL);
            event.accept(ItemInit.CREATIVE_ENDERPEARL);
        }
    }
    
}
