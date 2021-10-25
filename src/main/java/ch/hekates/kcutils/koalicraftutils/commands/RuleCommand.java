package ch.hekates.kcutils.koalicraftutils.commands;


import ch.hekates.kcutils.koalicraftutils.utils.PluginUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RuleCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("rules")) {
            if (!sender.hasPermission("rules.use")){
                sender.sendMessage("§cDu bist kein Admin, du Retard.");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }
            Player player = (Player)sender;
            //Sendet die Regeln aus dem Regeln util
            player.sendMessage(PluginUtils.rules);
            return true;
        }
        return false;
    }
}