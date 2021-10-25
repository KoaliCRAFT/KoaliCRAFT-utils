package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.*;

//Funktioniert Nicht :c
public class ReportCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("report")) {
            if (!sender.hasPermission("report.use")){
                sender.sendMessage("§cDu bist kein Admin, du Retard.");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }

            Player player = (Player) sender;
            String player2 = args[0];

            if (cmd.getName().equalsIgnoreCase("report")) {
                String reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));

                Bukkit.getServer().getOnlinePlayers().stream().filter(vltadmin -> vltadmin.hasPermission("kc.team")).forEach(admin -> ((Player) sender).performCommand("mail send " + admin.getName() + " Ich reporte: " + player2 + " Grund: " + reason));
        }
    return true;
        }
        return false;
    }
}