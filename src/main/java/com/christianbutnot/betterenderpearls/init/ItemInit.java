package com.christianbutnot.betterenderpearls.init;

import com.christianbutnot.betterenderpearls.BetterEnderPearls;
import com.christianbutnot.betterenderpearls.items.pearls.AdvancedPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.EnergizedPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.ImmortalPearlItem;
import com.christianbutnot.betterenderpearls.items.pearls.TechnicalPearlItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterEnderPearls.MODID);
	
	public static final RegistryObject<Item> TECHNICAL_ENDERPEARL = ITEMS.register("technical_enderpearl",
			() -> new TechnicalPearlItem(
					new Item.Properties().stacksTo(1).durability(8)));
	public static final RegistryObject<Item> ADVANCED_ENDERPEARL = ITEMS.register("advanced_enderpearl",
			() -> new AdvancedPearlItem(
					new Item.Properties().stacksTo(1).durability(12)));
	public static final RegistryObject<Item> ENERGIZED_ENDERPEARL = ITEMS.register("energized_enderpearl",
			() -> new EnergizedPearlItem(
					new Item.Properties().stacksTo(1).durability(16)));
	public static final RegistryObject<Item> IMMORTAL_ENDERPEARL = ITEMS.register("immortal_enderpearl",
			() -> new ImmortalPearlItem(
					new Item.Properties().stacksTo(1).durability(64)));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}