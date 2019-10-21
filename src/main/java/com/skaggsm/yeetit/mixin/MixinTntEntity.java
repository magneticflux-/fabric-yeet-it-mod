package com.skaggsm.yeetit.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TntEntity.class)
public abstract class MixinTntEntity extends Entity {
    public MixinTntEntity(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Inject(method = "tick()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/TntEntity;setVelocity(Lnet/minecraft/util/math/Vec3d;)V", shift = At.Shift.AFTER, ordinal = 0))
    private void modifyGravity(CallbackInfo ci) {
        // Add the rest of the acceleration to reach 0.08
        this.setVelocity(this.getVelocity().add(0.0D, (-0.08D - -0.04D), 0.0D));
    }
}
