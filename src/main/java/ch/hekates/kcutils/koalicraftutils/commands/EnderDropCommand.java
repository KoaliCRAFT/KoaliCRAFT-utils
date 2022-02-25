package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EnderDropCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("enderdrop") || label.equalsIgnoreCase("ed")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }
            Player player = (Player) sender;
            if (!(player.hasPermission("kc.enderdrop"))) return true;
            if (args.length > 0) {

                if (Bukkit.getPlayer(args[0]) != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    int transferAmount = player.getInventory().getItemInMainHand().getAmount();
                    ItemStack transferItem = new ItemStack(player.getInventory().getItemInMainHand().getType(), transferAmount);

                    String name = transferItem.getType().name().replaceAll("_"," ").toUpperCase();


                    if (target == player){
                        player.sendMessage("§8>> §7Du kannst dir selbst kein Item überreichen!");
                        return true;
                    }
                    if (transferItem.getType() == Material.AIR){
                        player.sendMessage("§8>> §cDu hast kein Item in der Hand!");
                        return true;
                    }

                    if (target.getInventory().firstEmpty() != -1) {
                        target.getInventory().addItem(transferItem);
                        player.getInventory().remove(transferItem);
                        player.sendMessage("§8>> §7Du hast §e" + target.getName().toString() + " erfolgreich ein Item per §5§lEnder§9Drop §r§7gesendet!");
                        target.sendMessage("§8>> §7Du hast erfolgreich §e§l" + transferAmount + " " + name +  " §r§7per §5§lEnder§9Drop §r§7von §e" + player.getName() + "§7 erhalten!");

                    } else {
                        player.sendMessage("§8>> §cDu kannst dem Spieler: §e§l" + args[0] + " §ckein Item übergeben, da dieser keinen freien Slot im Inventar hat!");
                    }
                } else {
                    player.sendMessage("§8>> §cDer Spieler: §e§l" + args[0] + " §cist nicht online oder existiert nicht!");
                }
            } else{
                player.sendMessage("§8>> §cDu musst eine Person angeben, der du das Item überreichen willst!");
                return true;
            }
        }
        return false;
    }
}
