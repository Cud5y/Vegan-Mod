package com.github.Cud5y.vegan.mixin.attack;

import com.github.Cud5y.vegan.Register;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public class BowItemMixin {
    //Disables attacking with a bow when veganMode is true
    @Inject(at = @At("INVOKE"),method = "onStoppedUsing",cancellable = true)
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user,int remainingUseTicks, CallbackInfo info) {
        GameRules gameRules = world.getGameRules();
        boolean veganMode = gameRules.getBoolean(Register.VEGAN_MODE);
        if(veganMode){
            user.sendSystemMessage(new LiteralText("pew pew"), Util.NIL_UUID);
            info.cancel();
        }
    }
}
