package com.christianbutnot.betterenderpearls.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class ResourceItem extends Item {

	public ResourceItem(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}@Override
    public void appendHoverText(ItemStack stack, @Nullable TooltipContext level, List<Component> components, TooltipFlag flag) {
		{
            components.add(Component.literal("Resource Item").withStyle(ChatFormatting.LIGHT_PURPLE).withStyle(ChatFormatting.ITALIC));
        } 

        super.appendHoverText(stack, level, components, flag);
    }
	
	

}
