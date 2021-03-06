package com.github.Cud5y.vegan.entity;

import com.github.Cud5y.vegan.entity.mob.JohnWickEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    private static ServerBossBar bossBar;
    //Creates entity John Wick as a monster with a bossbar
    public static final EntityType<JohnWickEntity> JOHN_WICK = Registry.register(Registry.ENTITY_TYPE,new Identifier("vegan","john_wick"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, JohnWickEntity::new).dimensions(EntityDimensions.fixed(1.0f,2.0f)).build());

}
