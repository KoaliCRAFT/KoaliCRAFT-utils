package ch.hekates.kcutils.koalicraftutils.listeners;

import ch.hekates.kcutils.koalicraftutils.KoaliCraft;
import ch.hekates.kcutils.koalicraftutils.menus.MusicBlockInventory;
import ch.hekates.kcutils.koalicraftutils.tablist.TablistManager;
import ch.hekates.kcutils.koalicraftutils.utils.StatsUtil;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        Plugin plugin = KoaliCraft.getPlugin(KoaliCraft.class);

        TablistManager.setScoreboard();
        //Join Message
        event.setJoinMessage("Willkommen §e" + player.getDisplayName() + " §rauf §9Koali§7§lCRAFT");
        //Join Title
        player.sendTitle("Hi §e" + player.getDisplayName(), "Viel spass!", 10, 40, 20);
        //Join Sounds
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 1f, 1f);
        }, 2L);
        //Tablist
        TablistManager.sendTablistHeaderAndFooter( player );
        ///Statistics///
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            player.sendMessage(StatsUtil.sendStats(player) + "\n\n§r§e⚠ §8§oFür genauere Statistiken §r§7/statistics §o§8bzw. §r§7/stats Benutzen §e⚠");
        }, 50L);
        new MusicBlockInventory(player);
    }

}