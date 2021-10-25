package ch.hekates.kcutils.koalicraftutils.commands;

import ch.hekates.kcutils.koalicraftutils.KoaliCraft;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class GetMusicBlockCommand implements CommandExecutor {

    //!!! FEATURE NICHT FERTIG !!!//
    public static ItemStack musicBlock = new ItemStack(Material.DISPENSER);
    static{
        List lore = new ArrayList();
        lore.add("Block, um Musik abzuspielen.");

        ItemMeta meta = musicBlock.getItemMeta();
        meta.setDisplayName("§a§kmb§r§5 Music Block§a§k mb");
        meta.addEnchant(Enchantment.KNOCKBACK, 0, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);

        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(new NamespacedKey(KoaliCraft.getPlugin(), "ismusicblock"), PersistentDataType.INTEGER, 1);

        musicBlock.setItemMeta(meta);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("musicblock")) {
            if (!sender.hasPermission("kc.team")){
                sender.sendMessage("§cDu bist kein Admin, du Retard.");
                return true;
            }
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }

            Player player = (Player)sender;
            //Perform Command

            player.getInventory().addItem(musicBlock);

            return true;
        }
        return false;
    }
}