package com.github.Cud5y.vegan;

import com.github.Cud5y.vegan.entity.ModEntities;
import com.github.Cud5y.vegan.entity.custom.JohnWickEntity;
import com.github.Cud5y.vegan.food.AcanthusSyriacusItem;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameRules;

public class Register {
    //Items
    public static final Item JOHN = new CustomSpawnEggItem(ModEntities.JOHN_WICK,new Item.Settings().group(ItemGroup.MISC));
    public static final Item VEGAN_BURGER = new Item(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(16).food(new FoodComponent.Builder().hunger(20).saturationModifier(20.0f).build()));
    public static final AcanthusSyriacusItem ACANTHUS_SYRIACUS = new AcanthusSyriacusItem(new FabricItemSettings().group(ItemGroup.FOOD).maxCount(1).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build()));

    //GameRule
    public static GameRules.Key<GameRules.BooleanRule> VEGAN_MODE;


    public static void register(){
        registerItems();
        registerAttributes();
        registerGameRules();
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

}

