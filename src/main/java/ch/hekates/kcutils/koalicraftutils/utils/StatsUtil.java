package ch.hekates.kcutils.koalicraftutils.utils;

import org.bukkit.Material;
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
        stringbuilder.append("§8>> §7Playtime: §8x §e" + (PluginUtils.timeConvert(player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 1200)) + "\n");

        //Kills
        if (player.getStatistic(Statistic.PLAYER_KILLS) != 0) {
            stringbuilder.append("§8>> §7Kills: §8x §e" + player.getStatistic(Statistic.PLAYER_KILLS) + "\n");
        } else {
            stringbuilder.append("§8>> §7Kills: §8x §c§lKEINE KILLS VORHANDEN\n");
        }

        //Deaths
        if (player.getStatistic(Statistic.DEATHS) != 0) {
            stringbuilder.append("§8>> §7Deaths: §8x §e" + player.getStatistic(Statistic.DEATHS) + "\n");
        } else {
            stringbuilder.append("§8>> §7Deaths: §8x §c§lKEINE DEATHS VORHANDEN\n");
        }

        //Time since death
        if (player.getStatistic(Statistic.DEATHS) != 0) {
            stringbuilder.append("§8>> §7Time since death: §8x §e" + (PluginUtils.timeConvert(player.getStatistic(Statistic.TIME_SINCE_DEATH) / 1200)) + "\n");
        } else {
            stringbuilder.append("§8>> §7Time since death: §8x §c§lKEINE DEATHS VORHANDEN\n");
        }

        ///Build///
        stats = stringbuilder.toString();
        return stats;

    }
}