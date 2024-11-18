package dev.tunix.untitled4.command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamemodeCommandExecutor implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player p)){
            sender.sendMessage("Низя консоль :<");
            return true;
        }
        if (args.length < 1) {
            return false;
        }

        Player target = p;
        if (args.length > 1) {
            Player foundPlayer = Bukkit.getPlayer(args[1]);
            if (foundPlayer != null) {
                target = foundPlayer;
            }
        }


        switch (args[0]) {
            case "0", "survival" -> {
                Player player = target.getPlayer();
                if (player != null) {
                    player.setGameMode(GameMode.SURVIVAL);
                }
                return true;
            }
            case "1", "creative" -> {
                Player player = target.getPlayer();
                if (player != null) {
                    player.setGameMode(GameMode.CREATIVE);
                }
                return true;
            }
            case "2", "adventure" -> {
                Player player = target.getPlayer();
                if (player != null) {
                    player.setGameMode(GameMode.ADVENTURE);
                }
                return true;
            }
            case "3", "spectator" -> {
                Player player = target.getPlayer();
                if (player != null) {
                    player.setGameMode(GameMode.SPECTATOR);
                }
                return true;
            }

    }


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1){
            final List<String> result = new ArrayList<>();
            final String arg = args[0].toUpperCase();
            for (int i = 0; i <= 3; i++) {
                if(String.valueOf(i).startsWith(args[0])){
                    result.add(String.valueOf(i));
                }
            }
            for (GameMode gm: GameMode.values()){
                final String name = gm.name();
                if(name.startsWith(arg)){
                    result.add(name.toLowerCase());
                }
            }

            return result;
        }
        if (args.length == 2){
            final List<String> result = new ArrayList<>();
            final String arg = args[1].toUpperCase();
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
