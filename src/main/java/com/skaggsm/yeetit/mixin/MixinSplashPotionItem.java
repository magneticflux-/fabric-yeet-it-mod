package com.skaggsm.yeetit.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.thrown.ThrownPotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(SplashPotionItem.class)
public class MixinSplashPotionItem {
    @Inject(method = "use(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/TypedActionResult;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/thrown/ThrownPotionEntity;setProperties(Lnet/minecraft/entity/Entity;FFFFF)V", shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onShoot(World world_1, PlayerEntity playerEntity_1, Hand hand_1, CallbackInfoReturnable<TypedActionResult> cir, ItemStack itemStack_1, ItemStack itemStack_2, ThrownPotionEntity thrownPotionEntity_1) {
        thrownPotionEntity_1.setProperties(playerEntity_1, playerEntity_1.pitch, playerEntity_1.yaw, -20.0F, 0.75F, 1.0F);
    }
}
