package com.christianbutnot.betterenderpearls;

import com.christianbutnot.betterenderpearls.init.ItemInit;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterEnderPearls.MODID)
public class BetterEnderPearls
{
    public static final String MODID = "betterenderpearls";
    
    public BetterEnderPearls()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);

        
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }
    
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.TECHNICAL_ENDERPEARL);
            event.accept(ItemInit.ADVANCED_ENDERPEARL);
            event.accept(ItemInit.ENERGIZED_ENDERPEARL);
            event.accept(ItemInit.IMMORTAL_ENDERPEARL);
        }
    }

}
