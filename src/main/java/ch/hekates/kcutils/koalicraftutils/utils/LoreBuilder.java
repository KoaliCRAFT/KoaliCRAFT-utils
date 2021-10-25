package ch.hekates.kcutils.koalicraftutils.utils;

import java.util.ArrayList;
import java.util.List;


//Util made by the Alps BTE dev team
public class LoreBuilder {

    private final List<String> lore = new ArrayList<>();

    public LoreBuilder description(String... lines) {
        emptyLine();
        for(String line : lines) {
            lore.add("§7" + line);
        }
        emptyLine();
        return this;
    }

    public LoreBuilder server(boolean online) {
        if(online) {
            lore.add("§a§l>> Connect To Server <<");
        } else {
            lore.add("§c§l>> Server is offline <<");
        }
        return this;
    }

    public LoreBuilder emptyLine() {
        lore.add(" ");
        return this;
    }

    public List<String> build() {
        return lore;
    }
}

//Util made by the Alps BTE dev team