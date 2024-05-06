package com.christianbutnot.betterenderpearls.init;

import java.util.function.Supplier;

import com.christianbutnot.betterenderpearls.Main;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockInit {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);
	
	
	public static final DeferredBlock<Block> ERADIUM_ORE = registerBlock("eradium_ore",
			() -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

	private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
		DeferredBlock<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <T extends Block> DeferredItem<BlockItem> registerBlockItem(String name, DeferredBlock<T> block) {
		return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}