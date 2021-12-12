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
        rules ="§lDiscord§r\n" +
                "- Behandle alle mit Respekt. Belästigung, Hexenjagd, Sexismus, Rassismus oder Volksverhetzung werden absolut nicht toleriert.\n" +
                "\n" +
                "- Ohne Berechtigung von einem Mitglied der Mitarbeiter kein Spam oder Eigenwerbung (Server-Einladungen, Anzeigen, usw.). Dazu zählen auch Direktnachrichten an andere Mitglieder.\n" +
                "\n" +
                "- Keine NSFW- oder obszönen Inhalte. Dazu zählen Texte, Bilder oder Links mit Nacktheit, Sex, schwerer Gewalt oder anderen grafisch verstörenden Inhalten.\n" +
                "\n" +
                "- Wenn du etwas sieht, das gegen die Regeln verstößt, oder wodurch du dich nicht sicher fühlst, dann benachrichtige die Mitarbeiter. Wir möchten, dass dieser Server ein Ort ist, an dem sich jeder willkommen fühlt.\n" +
                "\n" +
                "- Wenn du kein Spass mehr an diesem Projekt hast, solltest du den anderen Spielern den Spass am Spiel nicht verderben.\n" +
                "\n" +
                "- Du hörst auf die Manager und befolgst ihre Urteile ohne Wiederrede\n" +
                "\n" +
                "§lMinecraft§r\n" +
                "-Alle Discordregeln zählen auch Ingame.\n" +
                "\n" +
                "-Diebstahl ist Illegal und kann mit bis zu einem Permanentban bestraft werden.\n" +
                "\n" +
                "-Griefing ist Illegal und kann mit bis zu einem Permanentban bestraft werden.\n" +
                "\n" +
                "-Pranken ist grundsätzlich in einem gesunden Masse erlaubt. Findet die betroffene Person, dass die Grenze überschritten ist, kann diese sich an einen Admin wenden, oder den/die Übeltäter/In über das Anzeigesystem (/report <Spieler> <Grund>)anzeigen. Das Anzeigesystem kann auch für generelle Missstände verwendet werden.\n" +
                "\n" +
                "-Man könnte Grundsätzlich für alles bestraft werden, das Urteil wird dann jeweils im Adminteam besprochen.";

    //Liste der Plugins + Datapacks
    public static String
            adddons = "§lPlug-Ins:§r LuckPerms, dynmap, KoaliPanion, EssentialsX, PlotSquared, Multiverse, WorldGuard, BannerMaker, ImageMaps, HeadDB, Chunkmaster, KoaliCRAFTUtils, WorldBorder, HolographicDisplays, DiscordSRV, ChatControl\n\n§lDatapacks:§r Invisible Item Frame by CMD-Golem, Vanilla Tweaks, oneway Elytra by Halbzwilling";

    public static String timeConvert(int time) {
        return time/24/60 + "d, " + time/60%24 + "h, " + time%60 + "min";
    }
}