package com.tathluachc.blackforces.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.jetbrains.annotations.NotNull;

public class Forces implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        if (player.getEquipment().getBoots().getType() == Material.LEATHER_BOOTS) {
            LeatherArmorMeta boots = (LeatherArmorMeta) player.getEquipment().getBoots().getItemMeta();

            if (!boots.getColor().equals(Color.fromRGB(0x1D1D21))) {
                return true;
            }
            // Take off custom item
            player.sendMessage("The Black Forces have been taken off.");
        }

        else {
            // Put on custom item
            player.sendMessage("The Black Forces have been put on.");
        }

            Player player = event.getPlayer();

            ItemStack item = new ItemStack(Material.GRASS, 10);
            Inventory inv = player.getInventory();

            ItemMeta meta = item.getItemMeta();
            TextComponent itemDisplayName = Component.text("Testing");
            meta.displayName(itemDisplayName);
            item.setItemMeta(meta);

            inv.addItem(item);
            inv.setItem(8, item);
        }

        return true;
    }
}
