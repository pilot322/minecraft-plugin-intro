package com.pilot322.plugin;

import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;
import org.bukkit.*;

import net.md_5.bungee.api.ChatColor;

public class MySpigotPlugin extends BasePlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("MySpigotPlugin has been disabled!");
    }

    // INJECTED_CODE_PLACEHOLDER

}
