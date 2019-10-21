package com.skaggsm.yeetit.mixin;

import net.minecraft.entity.thrown.ThrownEntity;
import net.minecraft.entity.thrown.ThrownExperienceBottleEntity;
import net.minecraft.entity.thrown.ThrownPotionEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Created by Mitchell Skaggs on 10/20/2019.
 */
@Mixin(value = {ThrownEntity.class, ThrownPotionEntity.class, ThrownExperienceBottleEntity.class})
public abstract class MixinThrownEntities {
    @Inject(at = @At("TAIL"), method = "getGravity", cancellable = true)
    private void onGetGravity(CallbackInfoReturnable<Float> cir) {
        cir.setReturnValue(0.08F);
    }
}
