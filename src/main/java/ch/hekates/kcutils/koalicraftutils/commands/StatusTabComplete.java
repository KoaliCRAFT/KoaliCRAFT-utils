package ch.hekates.kcutils.koalicraftutils.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.*;

public class StatusTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> list = Arrays.asList("live", "recording", "cam", "axolotl");
        String input = args[0].toLowerCase();

        List<String> completions = null;
        for (String s : list){
            if (s.startsWith(input)){

                if (completions == null){
                    completions = new ArrayList();
                }

                completions.add(s);

            }
        }

        if (completions != null)
            Collections.sort(completions);

        return completions;
    }
}
