package com.pilot322.plugin;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

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

    public void script(){
    print("Hello!");
Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "say wtf");
}


}
