package net.bartzz.coins;

import org.bukkit.plugin.java.JavaPlugin;

import net.bartzz.coins.command.Coins;
import net.bartzz.coins.sql.MCDatabase;

public class Main extends JavaPlugin {
	
	private static Main MAIN;
	private static MCDatabase MCDATABASE;
	
	public void onLoad() {
		
		MAIN = this;
	}
	
	public void onEnable() {
		
		saveDefaultConfig();
		
		this.registerCommands();
	}
	
	private void registerCommands() {
		
		getCommand("coins").setExecutor(new Coins());
	}
	
	public static Main getInstance() {
		
		return Main.MAIN;
	}

	public static MCDatabase getMCDatabase() {
		
		return Main.MCDATABASE;
	}
}
