package ch.hekates.kcutils.koalicraftutils.listeners;

import ch.hekates.kcutils.koalicraftutils.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MapClickListener implements Listener {

    //Knöpfe am spawn für dinge
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        
        Player player = event.getPlayer();
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getClickedBlock().getLocation().getBlockY() == 201){
                if(event.getClickedBlock().getLocation().getBlockZ() == 328){
                    if(event.getClickedBlock().getLocation().getBlockX() == 29){
                        player.sendMessage(PluginUtils.rules);
                    }else if(event.getClickedBlock().getLocation().getBlockX() == 30){
                        player.sendMessage("§8--§e§lSpieler§r§8--§r\n");
                        for (OfflinePlayer whitelistedPlayer : Bukkit.getServer().getWhitelistedPlayers()) {
                            player.sendMessage("§7" + whitelistedPlayer.getName());
                        }

                    }else if(event.getClickedBlock().getLocation().getBlockX() == 31){
                        player.sendMessage(PluginUtils.adddons);
                    }else {
                        return;
                    }
                }
            }
        }
    }
}