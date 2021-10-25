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
        this.getCommand("rules").setExecutor(new RuleCommand());
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("flypad").setExecutor(new GetFlypadCommand());
        this.getCommand("grave").setExecutor(new GraveCommand());
        this.getCommand("stats").setExecutor(new StatsCommand());
        this.getCommand("statistics").setExecutor(new StatsCommand());
        this.getCommand("musicblock").setExecutor(new GetMusicBlockCommand());

        //Eventlisteners
        Bukkit.getPluginManager().registerEvents(new ChangeWorldListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new FlyBlockListener(),this);
        Bukkit.getPluginManager().registerEvents(new MapClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new ClickMusicBlockListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlaceMusicBlockListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static KoaliCraft getPlugin() {
        return plugin;
    }

}