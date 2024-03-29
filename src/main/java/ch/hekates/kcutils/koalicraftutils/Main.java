package ch.hekates.kcutils.koalicraftutils;

import ch.hekates.kcutils.koalicraftutils.commands.*;
import ch.hekates.kcutils.koalicraftutils.listeners.*;
import ch.hekates.kcutils.koalicraftutils.tablist.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Main plugin;

    private TablistManager tablistManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        //Commands
        getCommand("rules").setExecutor(new RuleCommand());
        getCommand("flypad").setExecutor(new GetFlypadCommand());
        getCommand("grave").setExecutor(new GraveCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("statistics").setExecutor(new StatsCommand());
        getCommand("status").setExecutor(new StatusCommand());
        getCommand("db").setExecutor(new DebugStickCommand());
        getCommand("enderchest").setExecutor(new ECCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("enderdrop").setExecutor(new EnderDropCommand());

        //Tab Completion
        getCommand("status").setTabCompleter(new StatusTabComplete());

        //Eventlisteners
        Bukkit.getPluginManager().registerEvents(new ChangeWorldListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new FlyBlockListener(),this);
        Bukkit.getPluginManager().registerEvents(new MapClickListener(), this);

        tablistManager = new TablistManager();

    }

    public static Main getPlugin() {
        return plugin;
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }
}