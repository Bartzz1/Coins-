package net.bartzz.coins.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;

import net.bartzz.coins.Main;
import net.bartzz.coins.data.CoinPlayer;
import net.bartzz.coins.manager.CoinPlayerManager;

public class MCLoader {
	
	public static void loadCoinPlayers() throws SQLException {
		CoinPlayerManager.getCoinPlayers().clear();
		ResultSet rs = Main.getMCDatabase().query("select * from coins_players");
		while (rs.next()) {
			UUID uuid = UUID.fromString(rs.getString("uuid"));
			String nick = rs.getString("nick");
			int coins = rs.getInt("coins");
			CoinPlayer player = new CoinPlayer(uuid, nick, coins);
			CoinPlayerManager.getCoinPlayers().add(player);
		}
		
		Bukkit.getConsoleSender().sendMessage("[Coins] Loaded " + CoinPlayerManager.getCoinPlayers().size() + " players.");
	}

}
