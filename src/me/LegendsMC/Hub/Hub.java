package me.LegendsMC.Hub;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {
	private static Plugin instance;

	boolean DebugMode = getConfig().getBoolean("DebugMode");

	public void onEnable() {
		instance = this;
		initializeConfig();
		registerEvents();
		registerCommands();
		if (DebugMode == true) {
			Bukkit.getConsoleSender().sendMessage(
					ChatColor.GREEN + "[Hub] " + ChatColor.RED
							+ "Debug Mode ON");
		}
		Bukkit.getConsoleSender().sendMessage(
				ChatColor.GREEN + "[Hub] Enabled!");
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(
				ChatColor.GREEN + "[Hub] Disabled!");
	}

	public void initializeConfig() {
		File configfile = new File(getDataFolder() + File.separator
				+ "config.yml");
		if (!configfile.exists()) {
			Bukkit.getConsoleSender().sendMessage(
					ChatColor.GREEN
							+ "[Hub] Generating config files...");
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}

	public void registerEvent(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}

	private void registerEvents() {
		//registerEvent(new SignCreateEvent());
	}

	private void registerCommands() {
		//getCommand("RewardTransfer").setExecutor(new CheckDB());
	}

	public static Plugin getInstance() {
		return instance;
	}
}
