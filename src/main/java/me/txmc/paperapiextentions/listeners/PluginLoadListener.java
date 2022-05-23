package me.txmc.paperapiextentions.listeners;

import me.txmc.protocolapi.reflection.GetField;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

/**
 * @author 254n_m
 * @since 5/14/22/ 7:30 PM
 * This file was created as a part of PaperAPIExtensions
 */
public class PluginLoadListener implements Listener {
    @GetField(clazz = JavaPlugin.class, name = "file")
    private Field fileF;

    @EventHandler
    public void onLoad(PluginEnableEvent event) {
        JavaPlugin plugin = (JavaPlugin) event.getPlugin();
//        File pluginFile =
    }
}
