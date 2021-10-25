package ch.hekates.kcutils.koalicraftutils.listeners;

import ch.hekates.kcutils.koalicraftutils.tablist.TablistManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class ChangeWorldListener implements Listener {

    //Reloadet dinge beim Worldchange
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        TablistManager.setScoreboard();
        TablistManager.sendTablistHeaderAndFooter(event.getPlayer());
    }
}
