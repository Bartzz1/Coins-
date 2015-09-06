package net.bartzz.coins.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.bartzz.coins.Main;
import net.bartzz.coins.data.CoinPlayer;
import net.bartzz.coins.manager.CoinPlayerManager;

public class JoinListener implements Listener {
	
	int start = Main.getInstance().getConfig().getInt("start");
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player player = e.getPlayer();
		
		CoinPlayer coinPlayer = CoinPlayer.getCoinPlayer(player.getUniqueId());
		
		if(coinPlayer == null) {
			
			coinPlayer = new CoinPlayer(player.getUniqueId(), player.getName(), start);
			
			coinPlayer.insert();
			CoinPlayerManager.getCoinPlayers().add(coinPlayer);
		}
	}

}
