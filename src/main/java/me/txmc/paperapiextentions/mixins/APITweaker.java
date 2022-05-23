package me.txmc.paperapiextentions.mixins;

import me.txmc.rtmixin.CallbackInfo;
import me.txmc.rtmixin.mixin.At;
import me.txmc.rtmixin.mixin.Inject;
import me.txmc.rtmixin.mixin.MethodInfo;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

/**
 * @author 254n_m
 * @since 5/22/22/ 4:27 PM
 * This file was created as a part of PaperAPIExtensions
 */
public class APITweaker {
    @Inject(
            info = @MethodInfo(_class = SimplePluginManager.class, name = "registerEvents", sig = {Listener.class, Plugin.class}, rtype = void.class),
            at = @At(pos = At.Position.HEAD))
    public static void modifyRegisterMethod(CallbackInfo ci) {

    }
}
