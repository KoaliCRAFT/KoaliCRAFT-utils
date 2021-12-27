package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ECCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("enderchest") || label.equalsIgnoreCase("ec")) {
            if (!sender.hasPermission("kc.ec")) {
                sender.sendMessage("§cDu hast keine Rechte, du Retard.");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }
            if (args.length > 0) {
                if (!sender.hasPermission("kc.team")) {
                    sender.sendMessage("§cDu hast keine Berechtigung, die Enderschest von anderen zu öffnen!");
                } else if (args.length == 2) {
                    if (Objects.equals(args[1], "-s") && Bukkit.getPlayer(args[0]) != null) {
                        openEnderchest((Player) sender, Bukkit.getPlayer(args[0]), true);
                    } else {
                        Player player = (Player) sender;
                        player.sendMessage("§8>> §cDer Spieler: §e§l" + args[0] + " §cist nicht online oder existiert nicht");}
                } else if(Bukkit.getPlayer(args[0]) != null) {
                    openEnderchest((Player) sender, Bukkit.getPlayer(args[0]), false);
                }else {
                    Player player = (Player) sender;
                    player.sendMessage("§8>> §cDer Spieler: §e§l" + args[0] + " §cist nicht online oder existiert nicht!");
                }
            } else {
                openEnderchest((Player) sender, (Player) sender, true);
            }
        }
        return false;
    }

    public static void openEnderchest(Player sender, Player target, boolean silent) {
        sender.openInventory(target.getEnderChest());
        sender.playSound(sender.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 0);
        sender.playEffect(sender.getLocation(), Effect.ENDER_SIGNAL, 0);
        String zusatz = "";
        if (silent){
            zusatz = " §7§osilent";
        }
        if (sender != target) {
            sender.sendMessage("§8>> §7Du hast erfolgreich die §5Enderchest §7von §e" + target.getName().toString() + zusatz + "§7 geöffnet!");
            if (!silent) {
                target.sendMessage("§8>> §7Deine §5Enderchest §7wurde von §e" + sender.getName().toString() + "§7 geöffnet!");
            }
        } else {
            sender.sendMessage("§8>> §7Du hast erfolgreich deine §5Enderchest §7geöffnet!");
        }
    }
}