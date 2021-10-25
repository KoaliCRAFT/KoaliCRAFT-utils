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
            if(event.getClickedBlock().getLocation().getBlockY() == 202){
                if(event.getClickedBlock().getLocation().getBlockZ() == -279){
                    if(event.getClickedBlock().getLocation().getBlockX() == 415){
                        player.sendMessage(PluginUtils.rules);
                    }else if(event.getClickedBlock().getLocation().getBlockX() == 413){

                        for (OfflinePlayer whitelistedPlayer : Bukkit.getServer().getWhitelistedPlayers()) {
                            player.sendMessage(whitelistedPlayer.getName());
                        }

                    }else if(event.getClickedBlock().getLocation().getBlockX() == 411){
                        player.sendMessage(PluginUtils.adddons);
                    }else {
                        return;
                    }
                }
            }
        }
    }
}