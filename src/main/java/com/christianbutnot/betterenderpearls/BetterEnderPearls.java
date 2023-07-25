package com.christianbutnot.betterenderpearls;

import com.christianbutnot.betterenderpearls.init.ItemInit;
import com.christianbutnot.betterenderpearls.init.ReplaceInit;

import net.minecraftforge.common.MinecraftForge;
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

        ReplaceInit.register(modEventBus);
        ItemInit.register(modEventBus);

        
        MinecraftForge.EVENT_BUS.register(this);
    }

}
