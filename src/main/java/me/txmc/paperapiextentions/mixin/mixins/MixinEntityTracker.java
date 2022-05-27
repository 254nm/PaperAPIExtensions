package me.txmc.paperapiextentions.mixin.mixins;

import me.txmc.rtmixin.CallbackInfo;
import me.txmc.rtmixin.mixin.At;
import me.txmc.rtmixin.mixin.Inject;
import me.txmc.rtmixin.mixin.MethodInfo;
import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityProjectile;
import net.minecraft.server.v1_12_R1.EntityTracker;

/**
 * @author 254n_m
 * @since 5/27/22/ 2:01 AM
 * This file was created as a part of PaperAPIExtensions
 */
public class MixinEntityTracker {
    @Inject(info = @MethodInfo(_class = EntityTracker.class, name = "track",sig = Entity.class, rtype = void.class), at = @At(pos = At.Position.HEAD))
    public static void onUntrack(CallbackInfo ci) {
        Entity e = (Entity) ci.getParameters()[0];
        if (e instanceof EntityProjectile) {
            EntityProjectile projectile = (EntityProjectile) e;
            System.out.println(projectile);
        }
//        System.out.println("Entity untracked " + ci.getParameters()[0]);
    }
}
