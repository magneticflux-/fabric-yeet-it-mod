package com.skaggsm.yeetit.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public class MixinBowItem {
    @Inject(method = "onStoppedUsing(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Lnet/minecraft/entity/LivingEntity;I)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/ProjectileEntity;setProperties(Lnet/minecraft/entity/Entity;FFFFF)V", shift = At.Shift.AFTER),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void onShoot(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1, int int_1, CallbackInfo ci, PlayerEntity playerEntity_1, boolean boolean_1, ItemStack itemStack_2, int int_2, float float_1, boolean boolean_2, ArrowItem arrowItem_1, ProjectileEntity projectileEntity_1) {
        projectileEntity_1.setProperties(playerEntity_1, playerEntity_1.pitch, playerEntity_1.yaw, 0.0F, float_1 * 3.75F, 1.0F);
    }
}
