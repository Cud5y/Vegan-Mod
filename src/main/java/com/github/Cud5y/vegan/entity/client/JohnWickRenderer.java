package com.github.Cud5y.vegan.entity.client;

import com.github.Cud5y.vegan.entity.mob.JohnWickEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class JohnWickRenderer extends GeoEntityRenderer<JohnWickEntity> {
    public JohnWickRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new JohnWickModel());
    }
    @Override
    public Identifier getTextureLocation(JohnWickEntity instance){
        return new Identifier("vegan","textures/entity/johnwick/john_wick.png");
    }
}
