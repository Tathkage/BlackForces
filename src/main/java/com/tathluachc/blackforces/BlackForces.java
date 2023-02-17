package com.tathluachc.blackforces;
import com.tathluachc.blackforces.handlers.ShoeHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlackForces extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[BlackForces] It's time to put 'em on");

        //getCommand("torch").setExecutor(new Fly());
        // Enables torch handler
        new ShoeHandler(this); // Can only place torches (they turn into diamond blocks)
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[BlackForces] Enjoy this again!");
    }
}
