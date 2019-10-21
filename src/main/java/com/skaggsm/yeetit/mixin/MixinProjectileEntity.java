package com.skaggsm.yeetit.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

/**
 * Created by Mitchell Skaggs on 10/20/2019.
 */
@Mixin(ProjectileEntity.class)
public abstract class MixinProjectileEntity extends Entity {
    public MixinProjectileEntity(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Inject(method = "tick()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/ProjectileEntity;setVelocity(DDD)V"),
            locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    private void modifyGravity(CallbackInfo ci, boolean boolean_1, Vec3d vec3d_1, float float_3, Vec3d vec3d_4) {
        // Add the rest of the acceleration to reach 0.08
        this.setVelocity(vec3d_4.x, vec3d_4.y - (0.08D - 0.05000000074505806D), vec3d_4.z);
    }
}
