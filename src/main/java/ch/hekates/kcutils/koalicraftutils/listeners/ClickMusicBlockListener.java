package ch.hekates.kcutils.koalicraftutils.listeners;

import ch.hekates.kcutils.koalicraftutils.commands.GetMusicBlockCommand;
import ch.hekates.kcutils.koalicraftutils.menus.MusicBlockInventory;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

//!!! FEATURE NICHT FERTIG !!!//
public class ClickMusicBlockListener implements Listener {

    @EventHandler
    public void onPlayer(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block targetBlock = player.getTargetBlock(null,5);
        if (targetBlock.getType() == Material.DISPENSER){
            Dispenser dispenser = (Dispenser) targetBlock.getState();

            if (dispenser.getPersistentDataContainer().equals(GetMusicBlockCommand.musicBlock.getItemMeta().getPersistentDataContainer())){
            event.setCancelled(true);
            new MusicBlockInventory(player);
            }
            player.sendMessage("Test");
        }
    }
}
