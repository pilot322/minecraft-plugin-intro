package com.pilot322.plugin;

import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;
import org.bukkit.*;

import net.md_5.bungee.api.ChatColor;

public class MySpigotPlugin extends BasePlugin {
    public void script() {
        print("let's go!");
        for (int i = 0; i < 3; i++) {
            print(ChatColor.YELLOW + "" + (i + 1));
        }
    }
}
