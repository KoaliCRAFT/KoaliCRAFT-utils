package ch.hekates.kcutils.koalicraftutils.tablist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class TablistManager {

    private static Scoreboard sb;

    public static void setScoreboard() {

        sb = Bukkit.getScoreboardManager().getNewScoreboard();

        //Erstellung der Teams
        sb.registerNewTeam("000Testworld");
        sb.registerNewTeam("001World");
        sb.registerNewTeam("002Nether");
        sb.registerNewTeam("003End");

        //zuweisung der Präfixen zu den Teams
        sb.getTeam("000Testworld").setPrefix("§7 [§8□§7] §8| §7");
        sb.getTeam("001World").setPrefix("§7 [§2■§7] §8| §7");
        sb.getTeam("002Nether").setPrefix("§7 [§4■§7] §8| §7");
        sb.getTeam("003End").setPrefix("§7 [§e■§7] §8| §7");


        for (Player all : Bukkit.getOnlinePlayers()) {
            setTeams(all);
        }
    }

    private static void setTeams(Player player) {
        String team;

        //Weist die Teams zu, je nach Welt
        if (player.getWorld().getName().equals("testwelt")) {
            team = "000Testworld";
        } else if (player.getWorld().getName().equals("world")) {
            team = "001World";
        } else if (player.getWorld().getName().equals("world_nether")) {
            team = "002Nether";
        } else {
            team = "003End";
        }
        sb.getTeam(team).addEntry(player.getName());
        player.setScoreboard(sb);
    }

    //TABLIST//
    public static void sendTablistHeaderAndFooter(Player player) {
        String welt;

        //Setzt den Name der Welt je nach Welt
        if(player.getWorld().getName().contains("world")){
            welt = "Survival";
        } else {
            welt = "Testwelt";
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
        player.setPlayerListFooter(" " + "\n§8>> §7Profil §8x §7"
                + player.getDisplayName() + "§8 <<"
                + "\n \n§8>> §7Webseite: §8x §ekoalicraft.eu§8 <<"
                + "\n§8>> §7Hoster: §8x §ezap-hosting.com/koalicraft§8 <<\n "
        );
    }

}
