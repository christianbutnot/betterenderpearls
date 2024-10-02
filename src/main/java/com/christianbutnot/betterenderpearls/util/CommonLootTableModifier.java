package com.christianbutnot.betterenderpearls.util;

import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class CommonLootTableModifier extends LootModifier {
	public static final Supplier<MapCodec<CommonLootTableModifier>> CODEC = Suppliers
			.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
					.and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(m -> m.item))
					.apply(inst, CommonLootTableModifier::new)));

	private final Item item;

	protected CommonLootTableModifier(LootItemCondition[] conditionsIn, Item item) {
		super(conditionsIn);
		this.item = item;
	}

	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot,
			LootContext context) {
		if(context.getRandom().nextFloat() >= 0.7f) {
            generatedLoot.add(new ItemStack(item));
        }

        return generatedLoot;
	}

	@Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}