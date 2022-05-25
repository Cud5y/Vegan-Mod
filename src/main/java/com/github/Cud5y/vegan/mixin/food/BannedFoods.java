package com.github.Cud5y.vegan.mixin.food;

import com.github.Cud5y.vegan.Register;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class BannedFoods {
    //Cause a explosion/damage when you eat meat if veganMode is true
    @Inject(at = @At("INVOKE"), method = "eatFood")
    public void eatFood(World world, ItemStack stack, CallbackInfoReturnable<Item> info){
        GameRules gameRules = world.getGameRules();
        boolean veganMode = gameRules.getBoolean(Register.VEGAN_MODE);
        if(veganMode){
            PlayerEntity player = (PlayerEntity) (Object) this;
            Item[] BannedFoods = {Items.COOKED_BEEF, Items.COOKED_COD, Items.COOKED_CHICKEN, Items.COOKED_MUTTON, Items.COOKED_RABBIT, Items.COOKED_RABBIT, Items.COOKED_PORKCHOP, Items.COOKED_SALMON, Items.BEEF, Items.PORKCHOP, Items.CHICKEN, Items.COD, Items.SALMON, Items.MUTTON, Items.RABBIT, Items.ROTTEN_FLESH, Items.TROPICAL_FISH, Items.PUFFERFISH};
            for(int i = 0; i < 17; i++){
                if(stack.isItemEqual(new ItemStack(BannedFoods[i]))){
                    //if you're in water it will take half your health
                    if(player.isTouchingWater()){
                        int hunger = player.getHungerManager().getFoodLevel();
                        player.getHungerManager().setFoodLevel(hunger - 2);
                        player.damage(DamageSource.STARVE,18.5f);
                        player.sendSystemMessage(Text.of("You're vegan. Meat = bad. Fucking idiot"), Util.NIL_UUID);
                    }
                    //creates a explosion at player's location
                    else {
                        world.createExplosion(player, player.getX(), player.getY(), player.getZ(), 10.0f, Explosion.DestructionType.DESTROY);
                        player.sendSystemMessage(Text.of("You dumbass you're vegan go eat potatoes"), Util.NIL_UUID);
                    }
                }
            }
        }
    }
}