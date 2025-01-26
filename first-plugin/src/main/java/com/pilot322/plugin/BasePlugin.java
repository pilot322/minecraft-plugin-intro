package com.pilot322.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BasePlugin extends JavaPlugin implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        org.bukkit.event.block.Action Action = e.getAction();
        if (Action == org.bukkit.event.block.Action.PHYSICAL || e.getItem() == null
                || e.getItem().getType() == Material.AIR)
            return;

        if (e.getItem().getType() == Material.STICK) {
            script();
            return;
        }
    }

    public void print(Object o) {
        getServer().dispatchCommand(Bukkit.getConsoleSender(),
                "tellraw @a [{\"text\":\"%s\"}] ".formatted(o.toString()));
        getServer().getLogger().info(o.toString());

    }

    public void script() {

    }

    @Override
    public void onEnable() {
        getCommand("dev").setExecutor((sender, command, label, args) -> {
            // Log the reload message BEFORE reloading
            // getLogger().info("Reload complete!");

            // Perform the actual reload
            getServer().reload();

            return true;
        });

        getServer().getPluginManager().registerEvents(this, this);

        script();
    }
}
