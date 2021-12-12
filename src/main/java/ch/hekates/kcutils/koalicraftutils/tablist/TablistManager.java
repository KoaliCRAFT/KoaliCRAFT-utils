package ch.hekates.kcutils.koalicraftutils.tablist;

import ch.hekates.kcutils.koalicraftutils.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class TablistManager {

    public static Scoreboard sb;

    public static void setScoreboard() {

        sb = Bukkit.getScoreboardManager().getNewScoreboard();

        //Erstellung der Teams
        sb.registerNewTeam("001World");
        sb.registerNewTeam("002Nether");
        sb.registerNewTeam("003End");
        sb.registerNewTeam("004Live");
        sb.registerNewTeam("004Rec");
        sb.registerNewTeam("004Cam");
        sb.registerNewTeam("004Axo");
        sb.registerNewTeam("004Geber");

        //zuweisung der Präfixen zu den Teams
        sb.getTeam("001World").setPrefix(" §2■ §8| ");
        sb.getTeam("002Nether").setPrefix(" §4■ §8| ");
        sb.getTeam("003End").setPrefix(" §e■ §8| ");
        sb.getTeam("004Live").setSuffix(" §d[Live]");
        sb.getTeam("004Rec").setSuffix(" §c[Rec]");
        sb.getTeam("004Cam").setSuffix(" §7[Cam]");
        sb.getTeam("004Axo").setSuffix(" §d[Axolotl]");
        sb.getTeam("004Geber").setSuffix(" §3[Geber]");


        for (Player all : Bukkit.getOnlinePlayers()) {
            setTeams(all);
        }
    }

    private static void setTeams(Player player) {
        String team;

        //Weist die Teams zu, je nach Welt
        if (!player.getScoreboard().getTeams().contains("004")){
            sb.getTeam("001World").addEntry(player.getName());
            player.setScoreboard(sb);
        }

        if (player.getWorld().getName().equals("world") && (sb.getTeam("002Nether").getPlayers().contains(player) || sb.getTeam("003End").getPlayers().contains(player)) && !(sb.getTeam("001World").getPlayers().contains(player))) {
            team = "001World";
            sb.getTeam(team).addEntry(player.getName());
            player.setScoreboard(sb);
        } else if (player.getWorld().getName().equals("world_nether") && (sb.getTeam("001World").getPlayers().contains(player) || sb.getTeam("003End").getPlayers().contains(player)) && !(sb.getTeam("002Nether").getPlayers().contains(player))) {
            team = "002Nether";
            sb.getTeam(team).addEntry(player.getName());
            player.setScoreboard(sb);
        } else if (player.getWorld().getName().equals("world_the_end") && (sb.getTeam("001World").getPlayers().contains(player) || sb.getTeam("002Nether").getPlayers().contains(player)) && !(sb.getTeam("003End").getPlayers().contains(player))){
            team = "003End";
            sb.getTeam(team).addEntry(player.getName());
            player.setScoreboard(sb);
        } else return;
    }

    //TABLIST//
    public static void sendTablistHeaderAndFooter(Player player) {
        String welt;

        //Setzt den Name der Welt je nach Welt
        if (player.getWorld().getName().equals("world")) {
            welt = "Survival";
        } else if (player.getWorld().getName().equals("world_nether")){
            welt = "Nether";
        } else {
            welt = "End";
        }

        //Tablist Header
        player.setPlayerListHeader(
                " \n§8>> §9Koali§7§lCRAFT §r§8x §7Dein lieblings §eSMP§8 <<\n§8>> §7Du spielst auf §8x §e"
                        + welt +
                        "§8 <<\n§8>> §7Spieler online §8x §e"
                        + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getWhitelistedPlayers().size()
                        + "§8 <<\n "
        );

        //Tablist Footer
        player.setPlayerListFooter(" " + "\n§8>> §7Playtime §8x §7"
                + (PluginUtils.timeConvert(player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 1200)) + "§8 <<"
                + "\n \n§8>> §7Webseite: §8x §ekoalicraft.eu§8 <<"
                + "\n§8>> §7Hoster: §8x §enitrado.net§8 <<\n "
        );
    }

}
