package net.bartzz.coins.manager;

import java.util.Collection;

import net.bartzz.coins.data.CoinPlayer;

public class CoinPlayerManager {
	
	private static Collection<CoinPlayer> coinPlayers;
	
	public static Collection<CoinPlayer> getCoinPlayers() {
		
		return coinPlayers;
	}

	public static void addCoins(CoinPlayer player, int value) {
		int amount = player.getCoins();
		player.setCoins(amount + value);
	}
	
	public static void removeCoins(CoinPlayer player, int value) {
		int amount = player.getCoins();
		if(value > amount) {
			return;
		}
		player.setCoins(amount - value);
	}
}
