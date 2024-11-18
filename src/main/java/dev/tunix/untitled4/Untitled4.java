package dev.tunix.untitled4;

import dev.tunix.untitled4.command.GamemodeCommandExecutor;
import dev.tunix.untitled4.command.HealCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Untitled4 extends JavaPlugin {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BukkitListener(), this);
        getCommand("gamemode").setExecutor(new GamemodeCommandExecutor());
        getCommand("heal").setExecutor(new HealCommandExecutor());
    }
    @Override
    public void onDisable() {
        getServer().getLogger().info("Отключен");
    }
}
