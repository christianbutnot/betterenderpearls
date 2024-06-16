package com.christianbutnot.betterenderpearls.items.pearls;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.item.EnderpearlItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;

public class ExpensivePearlItem extends EnderpearlItem {

	public ExpensivePearlItem(Properties p_41180_) {
		super(p_41180_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41190_, Player p_41191_, InteractionHand p_41192_) {
		ItemStack itemstack = p_41191_.getItemInHand(p_41192_);
		p_41190_.playSound((Player) null, p_41191_.getX(), p_41191_.getY(), p_41191_.getZ(),
				SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F,
				0.4F / (p_41190_.getRandom().nextFloat() * 0.4F + 0.8F));
		p_41191_.getCooldowns().addCooldown(this, 100);
		if (!p_41190_.isClientSide) {
			ThrownEnderpearl thrownenderpearl = new ThrownEnderpearl(p_41190_, p_41191_);
			thrownenderpearl.setItem(itemstack);
			thrownenderpearl.shootFromRotation(p_41191_, p_41191_.getXRot(), p_41191_.getYRot(), 0.0F, 1.5F, 1.0F);
			p_41190_.addFreshEntity(thrownenderpearl);
			
			ItemStack stack = p_41191_.getItemInHand(p_41192_);
			stack.setDamageValue(stack.getDamageValue() + 1);
			if (stack.getDamageValue() >= stack.getMaxDamage()) stack.setCount(0);
		}

		return InteractionResultHolder.sidedSuccess(itemstack, p_41190_.isClientSide());
	}
	
	@Override
    public void appendHoverText(ItemStack stack, @Nullable TooltipContext level, List<Component> components, TooltipFlag flag) {
		{
            components.add(Component.literal("32 Uses").withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
        } 

        super.appendHoverText(stack, level, components, flag);
    }
	
	@Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

}
