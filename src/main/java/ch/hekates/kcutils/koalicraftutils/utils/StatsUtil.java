package ch.hekates.kcutils.koalicraftutils.utils;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

public class StatsUtil {

    public static String sendStats(Player player){
        StringBuilder stringbuilder = new StringBuilder();
        String stats = "";

        player.sendMessage("§8--§e§lStatistics§r§8--§r\n");
        //Spawnpoint
        if (player.getBedSpawnLocation() != null) {
            stringbuilder.append("§8>> §7Respawnpoint: §8x §e" + player.getBedSpawnLocation().getX() + " " + player.getBedSpawnLocation().getY() + " " + player.getBedSpawnLocation().getZ() + "\n");
        } else {
            stringbuilder.append("§8>> §7Respawnpoint: §8x §c§lNICHT VORHANDEN\n");
        }
        //Ping
        stringbuilder.append("§8>> §7Ping: §8x §e" + player.getPing() + " ms\n");

        //Playtime
        stringbuilder.append("§8>> §7Playtime: §8x §e" + player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 72000 + " h\n");

        //Kills
        stringbuilder.append("§8>> §7Kills: §8x §e" + player.getStatistic(Statistic.PLAYER_KILLS) + "\n");

        ///Build///
        stats = stringbuilder.toString();
        return stats;

    }
}