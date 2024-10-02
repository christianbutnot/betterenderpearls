package com.christianbutnot.betterenderpearls.util;

import com.christianbutnot.betterenderpearls.Main;
import com.mojang.serialization.MapCodec;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class LootTableAdditiveMethod {

	public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister
			.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Main.MODID);

	// common items
	public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<CommonLootTableModifier>> ADD_COMMON_ITEM = LOOT_MODIFIER_SERIALIZERS
			.register("add_common_item", CommonLootTableModifier.CODEC);
	
	public static void register(IEventBus bus) {
		LOOT_MODIFIER_SERIALIZERS.register(bus);
	}
}
