package ch.hekates.kcutils.koalicraftutils;

import ch.hekates.kcutils.koalicraftutils.commands.*;
import ch.hekates.kcutils.koalicraftutils.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class KoaliCraft extends JavaPlugin {

    private static KoaliCraft plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        //Commands
        getCommand("rules").setExecutor(new RuleCommand());
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("flypad").setExecutor(new GetFlypadCommand());
        getCommand("grave").setExecutor(new GraveCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("statistics").setExecutor(new StatsCommand());
        getCommand("status").setExecutor(new StatusCommand());
        getCommand("db").setExecutor(new DebugStickCommand());

        //Tab Completion
        getCommand("status").setTabCompleter(new StatusTabComplete());

        //Eventlisteners
        Bukkit.getPluginManager().registerEvents(new ChangeWorldListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new FlyBlockListener(),this);
        Bukkit.getPluginManager().registerEvents(new MapClickListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static KoaliCraft getPlugin() {
        return plugin;
    }

}