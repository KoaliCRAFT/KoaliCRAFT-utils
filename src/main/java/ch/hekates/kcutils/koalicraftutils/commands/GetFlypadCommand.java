package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GetFlypadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("flypad")) {
            if (!sender.hasPermission("kc.team")){
                sender.sendMessage("§cDu bist kein Admin, du Retard.");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }


            List lore = new ArrayList();
            lore.add("§8>> §7Rechtsclick zum Platzieren eines §bFlypads §8<<");

            Player player = (Player)sender;
            //Gibt Flypadspawner
            ItemStack item = new ItemStack(Material.FEATHER);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName("FlyPadSpawner");
            meta.setUnbreakable(true);
            meta.setLore(lore);
            meta.addEnchant(Enchantment.KNOCKBACK, 0, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            item.setItemMeta(meta);

            player.getInventory().addItem(item);

            return true;
        }
        return false;
    }
}