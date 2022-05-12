package com.github.Cud5y.vegan.mixin.system;

import com.github.Cud5y.vegan.Register;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class VeganModeCheck {
    World serverWorld = (World) (Object) this;
    @Inject(at = @At("TAIL"),method = "onPlayerConnect")
    public void veganModeCheck(ClientConnection connection, ServerPlayerEntity player, CallbackInfo info){
        GameRules gameRules = serverWorld.getGameRules();
        boolean veganMode = gameRules.getBoolean(Register.VEGAN_MODE);
    }
}
