package com.skaggsm.yeetit.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(BoatEntity.class)
public abstract class MixinBoatEntity extends Entity {
    public MixinBoatEntity(EntityType<?> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @ModifyConstant(method = "updateVelocity()V",
            constant = @Constant(doubleValue = -0.03999999910593033D, ordinal = 1))
    private double modifyGravity(double acceleration) {
        // Replace the acceleration with 0.08
        return -0.08;
    }

    @ModifyConstant(method = "updateVelocity()V",
            constant = @Constant(doubleValue = 0.06153846016296973D))
    private double modifyBuoyancy(double acceleration) {
        return 0.06153846016296973D * 2;
    }
}
