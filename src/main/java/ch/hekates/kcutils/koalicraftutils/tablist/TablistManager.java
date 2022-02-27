package ch.hekates.kcutils.koalicraftutils.tablist;

import ch.hekates.kcutils.koalicraftutils.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TablistManager {

    public static void setPlayerList(Player player) {
        String welt;

        //Setzt den Name der Welt je nach Welt
        if (player.getWorld().getName().equals("world")) {
            welt = "Survival";
        } else if (player.getWorld().getName().equals("world_nether")) {
            welt = "Nether";
        } else {
            welt = "End";
        }

        //Tablist Header
        player.setPlayerListHeader(
                " \n§8>> §9Koali§7§lCRAFT §r§8x §7Dein lieblings §eSMP§8 <<" +
                        "\n§8>> §7Du spielst auf §8x §e" + welt + "§8 <<" +
                        "\n§8>> §7Spieler online §8x §e" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getWhitelistedPlayers().size() + "§8 <<\n "
        );

        //Tablist Footer
        player.setPlayerListFooter(
                " \n§8>> §7Playtime §8x §7" + (PluginUtils.timeConvert(player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 1200)) + "§8 <<"
                + "\n \n§8>> §7Webseite: §8x §ekoalicraft.eu§8 <<"
                + "\n§8>> §7Hoster: §8x §eg-portal.com§8 <<\n "
        );
    }

    public static void setPlayerTeams(Player player){

        Scoreboard scoreboard = player.getScoreboard();

        Team world = scoreboard.getTeam("001World");
        if (world == null){
            scoreboard.registerNewTeam("001World");
        }

        Team nether = scoreboard.getTeam("002Nether");
        if (nether == null){
            scoreboard.registerNewTeam("002Nether");
        }

        Team end = scoreboard.getTeam("003End");
        if (end == null){

            scoreboard.registerNewTeam("003End");
        }
        Team live = scoreboard.getTeam("004Live");
        if (live == null){
            scoreboard.registerNewTeam("004Live");
        }

        Team rec = scoreboard.getTeam("004Rec");
        if (rec == null){
            scoreboard.registerNewTeam("004Rec");
        }

        Team cam = scoreboard.getTeam("004Cam");
        if (cam == null){
            scoreboard.registerNewTeam("004Cam");
        }

        Team axo = scoreboard.getTeam("004Axo");
        if (axo == null){
            scoreboard.registerNewTeam("004Axo");
        }

        Team geber = scoreboard.getTeam("004Geber");
        if (geber == null){
            scoreboard.registerNewTeam("004Geber");
        }

        Team afk = scoreboard.getTeam("005AFK");
        if (afk == null){
            scoreboard.registerNewTeam("005AFK");
        }

        world.setPrefix(" §2■ §8| ");
        nether.setPrefix(" §4■ §8| ");
        end.setPrefix(" §e■ §8| ");
        live.setPrefix(" §d[Live] ");
        rec.setPrefix(" §c[Rec] ");
        cam.setPrefix(" §7[Cam] ");
        axo.setPrefix(" §d[Axolotl] ");
        geber.setPrefix(" §3[Geber] ");
        afk.setPrefix("§7[afk] §o");


//        List<Team> status = new ArrayList<Team>(Arrays.asList(live, rec, cam, afk, axo, geber));

        for (Player target : Bukkit.getOnlinePlayers()) {
            if (target.getScoreboard().getTeams().contains(world)
                    || target.getScoreboard().getTeams().contains(end)
                    || target.getScoreboard().getTeams().contains(nether)
                    || target.getScoreboard().getTeams().isEmpty()) {
/*                if (target.getScoreboard().getTeams().removeAll(status) == null) {
                    world.addEntry(target.getName());
                }*/

                if (target.getWorld().getName().equals("world")){
                    world.addEntry(target.getName());

                } else if (target.getWorld().getName().equals("world_nether")){
                    nether.addEntry(target.getName());

                } else if (target.getWorld().getName().equals("world_the_end")) {
                    end.addEntry(target.getName());
                } else return;
            } else return;
        }
    }
}
