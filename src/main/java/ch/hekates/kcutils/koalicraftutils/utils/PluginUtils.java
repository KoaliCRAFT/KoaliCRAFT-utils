package ch.hekates.kcutils.koalicraftutils.utils;

import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PluginUtils {

    public static int getPing(Player player) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Object nmsPlayer = player.getClass().getMethod("getHandle").invoke(player);
        Field fieldPing = nmsPlayer.getClass().getDeclaredField("ping");
        fieldPing.setAccessible(true);
        return fieldPing.getInt(nmsPlayer);
    }

    //Liste der Regeln
    public static String
            rules =
            "§8--§e§lDiscord§r§8--§r\n" +
                    "§8>> §e① Respekt§r §8<<\n§7" +
                    "\nBehandle alle mit Respekt. Belästigung, Hexenjagd, Sexismus, Rassismus oder Volksverhetzung werden absolut nicht toleriert.\n\n" +
                    "\n§8>> §e② Spam & Eigenwerbung§r §8<<\n§7" +
                    "\nOhne Berechtigung von einem Admin ist kein Spam oder Eigenwerbung (Server-Einladungen, Anzeigen, usw.) erlaubt. Dazu zählen auch Direktnachrichten an andere Mitglieder.\n\n" +
                    "\n§8>> §e③ NSFW & Obszönität§r §8<<\n§7" +
                    "\nKeine NSFW- oder obszönen Inhalte. Dazu zählen Texte, Bilder, Links aber auch Bildschirmübertragungen mit Nacktheit, Sex, schwerer Gewalt oder anderen grafisch verstörenden Inhalten.\n\n" +
                    "\n§8>> §e④ Selbstverantwortung§r §8<<\n§7" +
                    "\nWenn du etwas sieht, das gegen die Regeln verstößt, oder wodurch du dich nicht sicher fühlst, dann benachrichtige die Mitarbeiter. Wir möchten, dass dieser Server ein Ort ist, an dem sich jeder willkommen fühlt.\n\n" +
                    "\n§8>> §e⑤ Spass§r §8<<§7" +
                    "\nWenn du selbst kein Spass mehr an diesem Projekt hast, solltest du den anderen Spielern den Spass am Spiel nicht verderben.\n\n" +
                    "\n§8>> §e⑥ Mitarbeiter§r §8<<\n§7" +
                    "\nDu hörst auf die Mitarbeiter und behandelst sie mit Respekt. Du befolgst ihre Urteile ohne Wiederrede.\n\n" +
                    "\n\n§8--§e§lMinecraft§r§8--§r\n" +
                    "\n§7§oAlle Discord Regeln zählen auch ingame!\n\n" +
                    "\n§8>> §e① Diebstahl§r §8<<\n§7" +
                    "\nDiebstahl ist Illegal und kann mit bis zu einem Permanentban bestraft werden. Der jeweilige Fall wird im Adminteam individuell besprochen.\n\n" +
                    "\n§8>> §e② Griefing§r §8<<\n§7" +
                    "\nGriefing ist Illegal und kann mit bis zu einem Permanentban bestraft werden. Der jeweilige Fall wird im Adminteam individuell besprochen.\n\n" +
                    "\n§8>> §e③ Pranking§r §8<<\n§7" +
                    "\nPranken ist grundsätzlich in einem gesunden Masse erlaubt. Findet die betroffene Person, dass die Grenze überschritten ist, kann diese sich an einen Supporter über den [#〡ticket-support] wenden.\n\n" +
            "\n§7§oMan könnte Grundsätzlich für alles bestraft werden, das Urteil wird dann jeweils im Adminteam besprochen.";

    //Liste der Plugins + Datapacks
    public static String
            adddons = "§8--§e§lPlugins§r§8--§r\n§7" +
            "\nLuckPerms, dynmap, WorldGuard, BannerMaker, ImageMaps, HeadDB, Chunkmaster, KoaliCRAFTUtils, WorldBorder, HolographicDisplays, DiscordSRV, ChatControl\n" +
            "\n\n§8--§e§lDatapacks§r§8--§r\n§7" +
            "\nInvisible Item Frame by CMD-Golem, Vanilla Tweaks";

    public static String timeConvert(int time) {
        return time / 24 / 60 + "d, " + time / 60 % 24 + "h, " + time % 60 + "min";
    }
}