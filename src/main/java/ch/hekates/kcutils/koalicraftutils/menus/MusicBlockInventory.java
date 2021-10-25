package ch.hekates.kcutils.koalicraftutils.menus;

import org.bukkit.entity.Player;
import org.ipvp.canvas.Menu;
import org.ipvp.canvas.type.ChestMenu;

public class MusicBlockInventory {

    public Menu menu;
    //!!! FEATURE NICHT FERTIG !!!//
    public MusicBlockInventory(Player player){
        menu = createMenu();
        displayMenu(player);
    }
    public Menu createMenu() {
        return ChestMenu.builder(5)
                .title("§a§kmb§r§5 Music Block§a§k mb")
                .build();
    }

    public void displayMenu(Player player) {
        menu.open(player);
    }
}
