package com.tathluachc.blackforces.handlers;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.tathluachc.blackforces.BlackForces;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class ShoeHandler implements Listener {

    public ShoeHandler(BlackForces plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onShoeEquip(PlayerArmorChangeEvent event) {
        ItemStack item = event.getNewItem();
        Player player = event.getPlayer();
        PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, 99999999, 2, false, false);
        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 99999999, 2, false, false);

        if (Objects.requireNonNull(item).getType() != Material.LEATHER_BOOTS) {
            player.removePotionEffect(jump.getType());
            player.removePotionEffect(speed.getType());
            return;
        }

        LeatherArmorMeta boots = (LeatherArmorMeta) Objects.requireNonNull(event.getNewItem()).getItemMeta();

        if (!boots.getColor().equals(Color.fromRGB(0x1D1D21))) {
            return;
        }

        player.sendMessage("It's time to get wicked");

        player.addPotionEffect(jump);
        player.addPotionEffect(speed);

    }
}
