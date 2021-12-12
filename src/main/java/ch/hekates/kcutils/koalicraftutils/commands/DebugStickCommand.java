package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class DebugStickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("db")) {
            if (!sender.hasPermission("kc.team")){
                sender.sendMessage("§cDu bist kein Admin, du Retard.");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }

            Player player = (Player)sender;

            ItemStack item = new ItemStack(Material.DEBUG_STICK);

            player.getInventory().addItem(item);

            return true;
        }
        return false;
    }
}
