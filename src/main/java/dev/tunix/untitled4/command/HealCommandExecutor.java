package dev.tunix.untitled4.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HealCommandExecutor implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player p)){
            sender.sendMessage("Низя консоль :<");
            return true;
        }
        Player target = p;
        if (args.length > 0) {
            Player foundPlayer = Bukkit.getPlayer(args[0]);
            if (foundPlayer != null) {
                target = foundPlayer;
            }
        }
        target.setHealth(target.getMaxHealth());
        target.setFoodLevel(20);
        target.sendMessage(ChatColor.GREEN+"Вы были похилены!");
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            final List<String> result = new ArrayList<>();
            final String arg = args[0].toLowerCase();
            for(Player player: Bukkit.getOnlinePlayers()){
                if(player.getName().toLowerCase().startsWith(arg)){
                    result.add(player.getName());
                }
            }
            return result;
        }

        return List.of();
    }
}
