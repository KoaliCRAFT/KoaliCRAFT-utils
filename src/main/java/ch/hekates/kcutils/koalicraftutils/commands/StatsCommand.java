package ch.hekates.kcutils.koalicraftutils.commands;


import ch.hekates.kcutils.koalicraftutils.utils.StatsUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("stats")) {
            Player player = (Player)sender;
            player.performCommand("statistics");
        }
        if (label.equalsIgnoreCase("statistics")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }
            Player player = (Player)sender;
            //Sendet die Stats aus dem Stats util
            player.sendMessage(StatsUtil.sendStats(player));
        }
        return false;
    }
}