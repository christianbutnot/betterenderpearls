package com.christianbutnot.betterenderpearls;

import com.christianbutnot.betterenderpearls.init.BlockInit;
import com.christianbutnot.betterenderpearls.init.CreativeTabs;
import com.christianbutnot.betterenderpearls.init.ItemInit;
import com.christianbutnot.betterenderpearls.util.LootTableAdditiveMethod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Main.MODID)
public class Main {
	public static final String MODID = "betterenderpearls";

	public Main(IEventBus eventBus, ModContainer container) {

		CreativeTabs.register(eventBus);
		ItemInit.register(eventBus);
		BlockInit.register(eventBus);
		LootTableAdditiveMethod.register(eventBus);	}

}
