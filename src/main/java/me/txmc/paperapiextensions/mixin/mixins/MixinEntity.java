package me.txmc.paperapiextensions.mixin.mixins;

import me.txmc.paperapiextensions.events.EntityCreateEvent;
import me.txmc.rtmixin.CallbackInfo;
import me.txmc.rtmixin.mixin.At;
import me.txmc.rtmixin.mixin.Inject;
import me.txmc.rtmixin.mixin.MethodInfo;
import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.World;
import org.bukkit.Bukkit;

/**
 * @author 254n_m
 * @since 2022/12/14 9:05 PM
 * This file was created as a part of PaperAPIExtensions
 */
public class MixinEntity {
    @Inject(info = @MethodInfo(_class = Entity.class, name = "<init>", sig = World.class, rtype = void.class), at = @At(pos = At.Position.TAIL))
    public static void mixinConstructEntity(CallbackInfo ci) {
        Entity entity = (Entity) ci.getSelf();
        EntityCreateEvent event = new EntityCreateEvent(entity);
        Bukkit.getPluginManager().callEvent(event);
        if (event.isCancelled()) entity.die();
    }
}
