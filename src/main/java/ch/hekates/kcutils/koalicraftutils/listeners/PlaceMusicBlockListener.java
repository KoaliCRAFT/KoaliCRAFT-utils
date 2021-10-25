package ch.hekates.kcutils.koalicraftutils.listeners;

import ch.hekates.kcutils.koalicraftutils.ExtraBlocks;
import ch.hekates.kcutils.koalicraftutils.KoaliCraft;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlaceMusicBlockListener implements Listener {

    //!!! FEATURE NICHT FERTIG !!!//
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();

        if (event.getBlock().getType() != Material.DISPENSER) return;
        if (!(event.getBlock().getState() instanceof TileState)) return;
        TileState state = (TileState) event.getBlock().getState();
        PersistentDataContainer container = state.getPersistentDataContainer();
        if (item.isSimilar(ExtraBlocks.MusicBlock)){
            container.set(new NamespacedKey(KoaliCraft.getPlugin(), "ismusicblock"), PersistentDataType.INTEGER, 1);
            state.update();
            player.sendMessage("test");
            if (!(player.getInventory().getItemInMainHand().equals(Material.AIR))){
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
            }
        }
    }
}
