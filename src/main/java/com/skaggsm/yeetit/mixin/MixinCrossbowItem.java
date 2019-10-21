package com.skaggsm.yeetit.mixin;

import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(CrossbowItem.class)
public class MixinCrossbowItem {
    @Shadow
    private static boolean hasProjectile(ItemStack itemStack_1, Item fireworkRocket) {
        // Never reached
        throw new UnsupportedOperationException();
    }

    @Inject(method = "getSpeed(Lnet/minecraft/item/ItemStack;)F",
            at = @At("TAIL"),
            cancellable = true)
    private static void changeSpeed(ItemStack itemStack_1, CallbackInfoReturnable<Float> cir) {
        //noinspection ConstantConditions
        cir.setReturnValue(
                itemStack_1.getItem() == Items.CROSSBOW && hasProjectile(itemStack_1, Items.FIREWORK_ROCKET) ? 1.6F : 3.9F
        );
    }
}
