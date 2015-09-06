package net.bartzz.coins.manager;

import java.util.Collection;

import net.bartzz.coins.data.CoinPlayer;

public class CoinPlayerManager {
	
	private static Collection<CoinPlayer> coinPlayers;
	
	public static Collection<CoinPlayer> getCoinPlayers() {
		
		return coinPlayers;
	}

}
