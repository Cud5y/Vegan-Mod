package com.github.Cud5y.vegan.food;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.world.World;

public class AcanthusSyriacusItem extends Item {
    public AcanthusSyriacusItem(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);

        if (stack.isEmpty()) {
            user.sendSystemMessage(Text.of("That was the rarest item in the game and you ate it..."),Util.NIL_UUID);
            return new ItemStack(Items.DEAD_BUSH);
        }
            return stack;
    }
}