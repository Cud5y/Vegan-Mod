package com.github.Cud5y.vegan.mixin.system;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.example.GeckoLibMod;

@Mixin(GeckoLibMod.class)
public class DisableGeckoLibExamples
{
    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void disableExamples(CallbackInfo info)
    {
        GeckoLibMod.DISABLE_IN_DEV = true;
    }
}