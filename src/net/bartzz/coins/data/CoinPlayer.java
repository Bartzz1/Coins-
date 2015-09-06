package net.bartzz.coins.data;

import java.util.UUID;

import net.bartzz.coins.Main;
import net.bartzz.coins.manager.CoinPlayerManager;

public class CoinPlayer {
	
	private UUID 	uuid;
	private String 	nick;
	private int 	coins;

	public CoinPlayer(UUID uuid, String nick, int coins) {
		
		this.uuid = uuid;
		this.nick = nick;
		this.coins = coins;
		this.insert();
		CoinPlayerManager.getCoinPlayers().add(this);
	}
	
	public static CoinPlayer getCoinPlayer(UUID uuid) {
		for(CoinPlayer player : CoinPlayerManager.getCoinPlayers()) {
			if(player.getUuid().equals(uuid)) {
				return player;
			}
		}
		return null;
	}
	
	public void insert() {
		Main.getMCDatabase().update(true, "insert into coins_players (uuid, nick, coins) values ('" + this.uuid + "', '" + this.nick + "', '" + this.coins + "')");
	}
	
	public void update(boolean now) {
		Main.getMCDatabase().update(now, "update coins_players set nick='" + this.nick + "', coins='" + this.coins + "' where uuid='" + this.uuid + "'");
	}
	
	public void delete() {
		Main.getMCDatabase().update(true, "delete from coins_players where uuid='" + this.uuid + "'");
	}
	
	public UUID getUuid() {
		return uuid;
	}
	
	public String getNick() {
		return nick;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
}
