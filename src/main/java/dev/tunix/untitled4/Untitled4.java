package dev.tunix.untitled4;

import org.bukkit.plugin.java.JavaPlugin;

public final class Untitled4 extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BukkitListener(), this);
    }
    @Override
    public void onDisable() {
        getServer().getLogger().info("Отключен");
    }
}
