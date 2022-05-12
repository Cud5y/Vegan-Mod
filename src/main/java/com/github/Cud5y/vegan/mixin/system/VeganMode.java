package com.github.Cud5y.vegan.mixin.system;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.CyclingButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateWorldScreen.class)
public class VeganMode extends Screen {
    protected VeganMode(Text title) {super(title);}

    Screen screen = (Screen) ((Object)this);
    @Inject(at=@At("TAIL"),method = "render")
    private void renderVeganButton(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo info){
        int width = screen.width;
        int height = screen.height;
    }
}
