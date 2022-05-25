package com.github.Cud5y.vegan.mixin.attack;

import com.github.Cud5y.vegan.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public abstract class NoAttack extends LivingEntity {

    protected NoAttack(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("INVOKE"),method = "attack",cancellable = true)
    public void attack(Entity Target, CallbackInfo info) throws InterruptedException {
        GameRules gameRules = Target.getWorld().getGameRules();
        boolean veganMode = gameRules.getBoolean(Register.VEGAN_MODE);

        //Checks if the gamerule veganMode is true if so it will stop the player from attacking.
        if(veganMode){
            if(!Objects.equals(String.valueOf(Target.getType()), "entity.minecraft.boat")) {
                this.sendSystemMessage(new LiteralText("Why would you attack them you're vegan..."), Util.NIL_UUID);
                info.cancel();
            }
        }
    }
}