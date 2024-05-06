package com.christianbutnot.betterenderpearls.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class FrameItem extends Item {

	public FrameItem(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void appendHoverText(ItemStack stack, @Nullable TooltipContext level, List<Component> components, TooltipFlag flag) {
		{
            components.add(Component.literal("Utility Item").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.ITALIC));
        } 

        super.appendHoverText(stack, level, components, flag);
    }

}
