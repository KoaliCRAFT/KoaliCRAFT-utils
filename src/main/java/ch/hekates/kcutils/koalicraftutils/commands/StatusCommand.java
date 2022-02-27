package ch.hekates.kcutils.koalicraftutils.commands;

import ch.hekates.kcutils.koalicraftutils.tablist.TablistManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class StatusCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("status")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }
            Player player = (Player) sender;
            //Sendet die Stats aus dem Stats util

            if (args[0].length() == 0) {
                player.sendMessage("§cDu musst deinen erwünschten Status eingeben: /status <status>");
                return true;
            } else if (args.length > 1){
                player.sendMessage("§cEs scheint, enthalte dein Status " + args.length + " Argumente, er darf aber maximal nur 1 besitzen: /status <status>");
            } else {
                String team = args[0];

                if (args[0].toLowerCase().contains("live")) {
                    team = "004Live";
                } else if (args[0].toLowerCase().contains("rec")) {
                    team = "004Rec";
                } else if (args[0].toLowerCase().contains("cam")) {
                    team = "004Cam";
                } else if (args[0].toLowerCase().contains("axo")) {
                    team = "004Axo";
                } else if (args[0].toLowerCase().contains("geb")) {
                    team = "004Geber";
                } else if (args[0].toLowerCase().contains("afk")) {
                    team = "005AFK";
                } else if (args[0].toLowerCase().contains("reset")) {
                    if (player.getWorld().getName().equals("world")){
                        team = "001World";
                    } else if (player.getWorld().getName().equals("world_nether")){
                        team = "002Nether";
                    } else if (player.getWorld().getName().equals("world_the_end")) {
                        team = "003End";
                    }
                } else {
                    player.sendMessage("§cDer Status: " + team + " scheint nicht zu existieren!");
                    return true;
                }

                player.getScoreboard().getTeam(team).addEntry(player.getName());
            }
        }
        return false;
    }
}