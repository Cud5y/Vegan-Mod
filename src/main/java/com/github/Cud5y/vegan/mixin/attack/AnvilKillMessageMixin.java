package com.github.Cud5y.vegan.mixin.attack;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class AnvilKillMessageMixin {

    @Inject(method = "onDeath",at = @At("TAIL"))
    private void AnvilKillMessage(DamageSource source, CallbackInfo info){
        Entity entity = source.getAttacker();
    }
}
