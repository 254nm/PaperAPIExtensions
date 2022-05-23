package me.txmc.paperapiextentions;

import lombok.Getter;
import lombok.SneakyThrows;
import me.txmc.paperapiextentions.mixins.EventTweaker;
import me.txmc.rtmixin.RtMixin;
import org.bukkit.command.defaults.ReloadCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.instrument.Instrumentation;

@Getter
public final class PaperAPIExtensions extends JavaPlugin {
    private static Instrumentation inst;


    @Override
    @SneakyThrows
    public void onLoad() {
        Instrumentation inst = RtMixin.attachAgent().orElseThrow(RuntimeException::new);
        PaperAPIExtensions.inst = inst;
        RtMixin.processMixins(EventTweaker.class);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
