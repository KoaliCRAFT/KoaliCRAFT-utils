package ch.hekates.kcutils.koalicraftutils.listeners;

import org.bukkit.*;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FlyBlockListener implements Listener {
    //detect
    @EventHandler
    public void onPlayerFly(AreaEffectCloudApplyEvent event) {
        if (event.getEntity().getCustomName().equals("FlyBlock")) {
            for (LivingEntity entity : event.getAffectedEntities()) {
                entity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 55));
            }
        }
    }

    //create
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getItem() == null) return;
        if (event.getItem().getType() != Material.FEATHER) return;
        if (!event.getItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_ENCHANTS)) return;

        spawnFlyBlock(event.getClickedBlock().getLocation().add(0.5, 1.1, 0.5));
    }

    //spawn
    public void spawnFlyBlock(Location location) {
        AreaEffectCloud fly = (AreaEffectCloud) location.getWorld().spawnEntity(location, EntityType.AREA_EFFECT_CLOUD);
        fly.addCustomEffect(new PotionEffect(PotionEffectType.LEVITATION, 0, 0), false);
        fly.setRadius(1);
        fly.setDuration(630720000);
        fly.setCustomName("FlyBlock");
        fly.setCustomNameVisible(false);
        fly.setParticle(Particle.REDSTONE, new Particle.DustOptions(Color.fromRGB(176, 206, 255), 1));
    }
}
