package com.christianbutnot.betterenderpearls.items.eyes;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.item.EnderEyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class PoisonedEyeItem extends EnderEyeItem {

	public PoisonedEyeItem(Item.Properties p_41180_) {
		super(p_41180_);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level p_41184_, Player p_41185_, InteractionHand p_41186_) {
		ItemStack itemstack = p_41185_.getItemInHand(p_41186_);
		itemstack.setDamageValue(itemstack.getDamageValue() + 1);
		if (itemstack.getDamageValue() >= itemstack.getMaxDamage())
			itemstack.setCount(0);
		HitResult hitresult = getPlayerPOVHitResult(p_41184_, p_41185_, ClipContext.Fluid.NONE);
		if (hitresult.getType() == HitResult.Type.BLOCK
				&& p_41184_.getBlockState(((BlockHitResult) hitresult).getBlockPos()).is(Blocks.END_PORTAL_FRAME)) {
			return InteractionResultHolder.pass(itemstack);
		} else {
			p_41185_.startUsingItem(p_41186_);
			if (p_41184_ instanceof ServerLevel) {
				ServerLevel serverlevel = (ServerLevel) p_41184_;
				BlockPos blockpos = serverlevel.findNearestMapStructure(StructureTags.EYE_OF_ENDER_LOCATED,
						p_41185_.blockPosition(), 100, false);
				if (blockpos != null) {
					EyeOfEnder eyeofender = new EyeOfEnder(p_41184_, p_41185_.getX(), p_41185_.getY(0.5D),
							p_41185_.getZ());
					eyeofender.setItem(itemstack);
					eyeofender.signalTo(blockpos);
					p_41184_.gameEvent(GameEvent.PROJECTILE_SHOOT, eyeofender.position(),
							GameEvent.Context.of(p_41185_));
					p_41184_.addFreshEntity(eyeofender);
					if (p_41185_ instanceof ServerPlayer) {
						CriteriaTriggers.USED_ENDER_EYE.trigger((ServerPlayer) p_41185_, blockpos);

					}

					p_41184_.playSound((Player) null, p_41185_.getX(), p_41185_.getY(), p_41185_.getZ(),
							SoundEvents.ENDER_EYE_LAUNCH, SoundSource.NEUTRAL, 0.5F,
							0.4F / (p_41184_.getRandom().nextFloat() * 0.4F + 0.8F));
					p_41184_.levelEvent((Player) null, 1003, p_41185_.blockPosition(), 0);
					if (!p_41185_.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					p_41185_.awardStat(Stats.ITEM_USED.get(this));
					p_41185_.swing(p_41186_, true);
					return InteractionResultHolder.success(itemstack);
				}
			}

			return InteractionResultHolder.consume(itemstack);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
		{
			components.add(Component
					.literal("10 Uses")
					.withStyle(ChatFormatting.GRAY).withStyle(ChatFormatting.ITALIC));
		}

		super.appendHoverText(stack, level, components, flag);
	}

}
