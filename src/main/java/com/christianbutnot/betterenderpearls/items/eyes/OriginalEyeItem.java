package com.christianbutnot.betterenderpearls.items.eyes;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnderEyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class OriginalEyeItem extends EnderEyeItem {

	public OriginalEyeItem(Item.Properties p_41180_) {
		super(p_41180_);
	}

	@Override
	public InteractionResult useOn(UseOnContext p_41182_) {
		return InteractionResult.FAIL;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41184_, Player p_41185_, InteractionHand p_41186_) {
		ItemStack itemstack = p_41185_.getItemInHand(p_41186_);

			return InteractionResultHolder.fail(itemstack);
	}
}
