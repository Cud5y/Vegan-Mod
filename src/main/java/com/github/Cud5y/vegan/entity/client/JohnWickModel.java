package com.github.Cud5y.vegan.entity.client;

import com.github.Cud5y.vegan.entity.mob.JohnWickEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JohnWickModel extends AnimatedGeoModel<JohnWickEntity> {

    @Override
    public Identifier getModelLocation(JohnWickEntity object) {
        return new Identifier("vegan","geo/johnwick.geo.json");
    }

    @Override
    public Identifier getTextureLocation(JohnWickEntity object) {
        return new Identifier("vegan","textures/entity/johnwick/john_wick.png");
    }

    @Override
    public Identifier getAnimationFileLocation(JohnWickEntity animatable) {
        return new Identifier("vegan","animations/johnwick.animation.json");
    }
}
