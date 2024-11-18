package dev.tunix.untitled4;

import dev.tunix.untitled4.event.BreakOreEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public final class BukkitListener implements Listener {
    @EventHandler
    private void on(PlayerJoinEvent event){
        final Player player = event.getPlayer();
        player.sendMessage("Добро пожаловать на сервер " + ChatColor.AQUA + player.getName());
    }
    private boolean IsOre(Block block){
        String blockname = String.valueOf(block.getType());
        return blockname.contains("_ORE");
    }
    @EventHandler
    private void on(BlockBreakEvent event){
        final Block block = event.getBlock();
        if(IsOre(block)){
            final BreakOreEvent e = new BreakOreEvent(event.getPlayer(),block);
            Bukkit.getPluginManager().callEvent(e);
            if (e.isCancelled()){
                event.setCancelled(true);
            }

        }
    }
    @EventHandler
    private void on(BreakOreEvent event){
        Player player = event.getPlayer();
        String blockname = String.valueOf(event.getBlock().getType());
        String blocknameformat = blockname.replace("_ORE","");

        if(Math.random() >= 0.5){
            event.setCancelled(true);
            player.sendMessage("Не получилось сломать" + ChatColor.AQUA + blocknameformat);
        }
        else {
            player.sendMessage("Ты сломал руду " + ChatColor.AQUA + blocknameformat);
        }
    }
}