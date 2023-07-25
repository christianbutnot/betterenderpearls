package com.christianbutnot.betterenderpearls.init;

import com.christianbutnot.betterenderpearls.items.NewEnderEyeItem;
import com.christianbutnot.betterenderpearls.items.NewEnderPearlItem;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ReplaceInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");
	
	public static final RegistryObject<Item> ENDER_PEARL = ITEMS.register("ender_pearl",
			() -> new NewEnderPearlItem(
					new Item.Properties().stacksTo(1).durability(4).tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> ENDER_EYE = ITEMS.register("ender_eye",
			() -> new NewEnderEyeItem(
					new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}