package com.trialweapons;

import com.trialweapons.commands.TrialCommand;
import com.trialweapons.items.ItemManager;
import com.trialweapons.listeners.CraftListener;
import com.trialweapons.listeners.MaceListener;
import com.trialweapons.listeners.SpearListener;
import com.trialweapons.listeners.WindChargeListener;
import com.trialweapons.mobs.BoggedManager;
import com.trialweapons.mobs.BreezeManager;
import com.trialweapons.systems.TrialSpawnerSystem;
import com.trialweapons.systems.VaultSystem;
import org.bukkit.plugin.java.JavaPlugin;

public class TrialWeapons extends JavaPlugin {

    private static TrialWeapons instance;
    private ItemManager itemManager;
    private BreezeManager breezeManager;
    private BoggedManager boggedManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        itemManager = new ItemManager(this);
        breezeManager = new BreezeManager(this);
        boggedManager = new BoggedManager(this);

        getServer().getPluginManager().registerEvents(new MaceListener(this), this);
        getServer().getPluginManager().registerEvents(new SpearListener(this), this);
        getServer().getPluginManager().registerEvents(new WindChargeListener(this), this);
        getServer().getPluginManager().registerEvents(new CraftListener(this), this);
        getServer().getPluginManager().registerEvents(breezeManager, this);
        getServer().getPluginManager().registerEvents(boggedManager, this);
        getServer().getPluginManager().registerEvents(new TrialSpawnerSystem(this, breezeManager, boggedManager), this);
        getServer().getPluginManager().registerEvents(new VaultSystem(this), this);

        TrialCommand cmd = new TrialCommand(this);
        getCommand("trial").setExecutor(cmd);
        getCommand("mace").setExecutor(cmd);
        getCommand("spear").setExecutor(cmd);
        getCommand("windcharge").setExecutor(cmd);
        getCommand("recipes").setExecutor(cmd);

        itemManager.registerRecipes();

        getLogger().info("TrialWeapons v1.2 enabled!");
        getLogger().info("Loaded: Maces, Spears, Wind Charges, Breeze, Bogged, Trial Spawners & Vaults");
    }

    @Override
    public void onDisable() {
        getLogger().info("TrialWeapons disabled.");
    }

    public static TrialWeapons getInstance() {
        return instance;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public BreezeManager getBreezeManager() {
        return breezeManager;
    }

    public BoggedManager getBoggedManager() {
        return boggedManager;
    }
}
