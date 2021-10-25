package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class GraveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("grave")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cDu bist kein Spieler LOL");
                return true;
            }
            Player player = (Player) sender;

            //setzt score um in einem Datapack etwas auszulösen
            ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
            Score score = scoreboardManager.getMainScoreboard().getObjective("grave").getScore(player);
            score.setScore(1);

            return true;
        }
        return false;
    }
}
