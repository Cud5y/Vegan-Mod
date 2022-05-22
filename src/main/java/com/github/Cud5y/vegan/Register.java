package com.github.Cud5y.vegan;

import com.github.Cud5y.vegan.entity.ModEntities;
import com.github.Cud5y.vegan.entity.mob.JohnWickEntity;
import com.github.Cud5y.vegan.food.AcanthusSyriacusItem;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;

public class Register {
    //Items
    public static final Item JOHN = new CustomSpawnEggItem(ModEntities.JOHN_WICK,new Item.Settings().group(ItemGroup.MISC));
    public static final Item VEGAN_BURGER = new Item(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(16).food(new FoodComponent.Builder().hunger(20).saturationModifier(80.0f).build()));
    public static final AcanthusSyriacusItem ACANTHUS_SYRIACUS = new AcanthusSyriacusItem(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));

    //GameRule
    public static GameRules.Key<GameRules.BooleanRule> VEGAN_MODE;

    //Sounds
    public static final Identifier JOHN_DEATH = new Identifier("vegan:death_sound");
    public static final Identifier JOHN_HURT = new Identifier("vegan:hurt_sound");
    public static final Identifier JOHN_IDLE = new Identifier("vegan:idle_sound");
    public static SoundEvent JOHNWICK_DEATH = new SoundEvent(JOHN_DEATH);
    public static SoundEvent JOHNWICK_HURT = new SoundEvent(JOHN_HURT);
    public static SoundEvent JOHNWICK_IDLE = new SoundEvent(JOHN_IDLE);


    public static void register(){
        registerItems();
        registerAttributes();
        registerGameRules();
        registerSounds();
    }

    private static void registerItems(){
        Registry.register(Registry.ITEM,new Identifier("vegan","vegan_burger"),VEGAN_BURGER);
        Registry.register(Registry.ITEM,new Identifier("vegan","acanthus_syriacus"),ACANTHUS_SYRIACUS);
        Registry.register(Registry.ITEM,new Identifier("vegan","john"),JOHN);
    }

    private static void registerAttributes(){
        FabricDefaultAttributeRegistry.register(ModEntities.JOHN_WICK, JohnWickEntity.setAttributes());
    }

    private static void registerGameRules(){
        VEGAN_MODE = GameRuleRegistry.register("veganMode",GameRules.Category.MISC,GameRuleFactory.createBooleanRule(false));
    }

    private static void registerSounds(){
        Registry.register(Registry.SOUND_EVENT,JOHN_DEATH,JOHNWICK_DEATH);
        Registry.register(Registry.SOUND_EVENT,JOHN_HURT,JOHNWICK_HURT);
        Registry.register(Registry.SOUND_EVENT,JOHN_IDLE,JOHNWICK_IDLE);
    }

}

