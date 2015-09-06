package net.bartzz.coins;

import java.sql.SQLException;

import org.bukkit.plugin.java.JavaPlugin;

import net.bartzz.coins.command.Coins;
import net.bartzz.coins.command.admin.CoinsManager;
import net.bartzz.coins.data.CoinPlayer;
import net.bartzz.coins.manager.CoinPlayerManager;
import net.bartzz.coins.sql.MCDatabase;
import net.bartzz.coins.sql.MCLoader;

public class Main extends JavaPlugin {
	
	private static Main MAIN;
	private static MCDatabase MCDATABASE;
	
	public void onLoad() {
		
		MAIN = this;
	}
	
	public void onEnable() {
		
		saveDefaultConfig();
		
		this.registerCommands();
		
		MCDATABASE = new MCDatabase(getConfig().getString("mysql.host"), getConfig().getInt("mysql.port"), getConfig().getString("mysql.user"), getConfig().getString("mysql.password"), getConfig().getString("mysql.database"));
		
		try {
			MCLoader.loadCoinPlayers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void onDisable() {
		
		for(CoinPlayer player : CoinPlayerManager.getCoinPlayers()) {
			player.update(true);
		}
	}
	
	private void registerCommands() {
		
		this.getCommand("coins").setExecutor(new Coins());
		this.getCommand("cmanager").setExecutor(new CoinsManager());
	}
	
	public static Main getInstance() {
		
		return Main.MAIN;
	}

	public static MCDatabase getMCDatabase() {
		
		return Main.MCDATABASE;
	}
}
