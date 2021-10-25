package ch.hekates.kcutils.koalicraftutils;

import ch.hekates.kcutils.koalicraftutils.utils.ItemBuilder;
import ch.hekates.kcutils.koalicraftutils.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ExtraBlocks {

    //Musicblock
    public static ItemStack MusicBlock = new ItemBuilder(Material.DISPENSER, 1, (byte) 2)
            .setName("§a§kmb§r§5 Music Block§a§k mb").setLore(new LoreBuilder()
                    .emptyLine()
                    .description("Use this tool to place a §a§kmb§r§5 Music Block§a§k mb")
                    .emptyLine()
                    .build())
            .setEnchantment(true)
            .build();
}

