package com.github.Cud5y.vegan;

import com.github.Cud5y.vegan.entity.client.JohnWickRenderer;
import com.github.Cud5y.vegan.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class VeganClientInit implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.JOHN_WICK, JohnWickRenderer::new);
    }
}
