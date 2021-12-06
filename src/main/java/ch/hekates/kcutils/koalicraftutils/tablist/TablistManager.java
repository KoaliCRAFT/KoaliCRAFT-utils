package ch.hekates.kcutils.koalicraftutils.tablist;

import org.bukkit.Bukkit;
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
        sb.registerNewTeam("Live");
        sb.registerNewTeam("Rec");
        sb.registerNewTeam("Cam");
        sb.registerNewTeam("Axo");
        sb.registerNewTeam("Geber");

        //zuweisung der Präfixen zu den Teams
        sb.getTeam("001World").setPrefix("§2■§8| §7");
        sb.getTeam("002Nether").setPrefix("§4■§8| §7");
        sb.getTeam("003End").setPrefix("§e■§8| §7");
        sb.getTeam("Live").setSuffix("§d[⚫Live]");
        sb.getTeam("Rec").setSuffix("§c[⚫Rec]");
        sb.getTeam("Cam").setSuffix("§7[Cam]");
        sb.getTeam("Axo").setSuffix("§d[Axolotl]");
        sb.getTeam("Geber").setSuffix("§3[Geber]");


        for (Player all : Bukkit.getOnlinePlayers()) {
            setTeams(all);
        }
    }

    private static void setTeams(Player player) {
        String team;

        //Weist die Teams zu, je nach Welt
        if (player.getWorld().getName().equals("world")) {
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
        player.setPlayerListFooter(" " + "\n§8>> §7Profil §8x §7"
                + player.getDisplayName() + "§8 <<"
                + "\n \n§8>> §7Webseite: §8x §ekoalicraft.eu§8 <<"
                + "\n§8>> §7Hoster: §8x §enitrado.net§8 <<\n "
        );
    }

}
