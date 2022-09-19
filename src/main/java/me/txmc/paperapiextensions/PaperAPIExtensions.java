package me.txmc.paperapiextensions;

import lombok.Getter;
import lombok.SneakyThrows;
import me.txmc.paperapiextensions.mixin.MixinManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class PaperAPIExtensions extends JavaPlugin {
    private static PaperAPIExtensions instance;

    public static PaperAPIExtensions getInstance() {
        return instance;
    }


    @Override
    @SneakyThrows
    public void onLoad() {
        instance = this;
        new MixinManager().init();
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
