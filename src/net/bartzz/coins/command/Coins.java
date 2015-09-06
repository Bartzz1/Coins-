package net.bartzz.coins.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bartzz.coins.data.CoinPlayer;
import net.bartzz.coins.util.UtilChat;

public class Coins implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		if(!sender.hasPermission("coins.check")) {
			UtilChat.message(sender, "&6» &cYou don't have permission.");
			return true;
		}
		
		if(!(sender instanceof Player)) {
			UtilChat.message(sender, "&6» &cConsole cannot use this command.");
			return true;
		}
		
		if(args.length > 0 && !sender.hasPermission("coins.check.other")) {
			UtilChat.message(sender, "&6» &cUsage: &7/coins");
			return true;
		}
		
		if(args.length > 1 && sender.hasPermission("coins.check.other")) {
			UtilChat.message(sender, "&6» &cUsage: &7/coins <player>");
			return true;
		}
		
		Player player = (Player) sender;
		
		CoinPlayer coinPlayer = CoinPlayer.getCoinPlayer(player.getUniqueId());
		
		if(coinPlayer == null) {
			UtilChat.message(sender, "&6» &cError while mysql.");
			return true;
		}
		
		if(args.length == 0) {
			
			UtilChat.message(sender, "&8» &7Your amount: &e" + coinPlayer.getCoins() + "$.");
		}
		
		else if(args.length == 1) {
			
			OfflinePlayer other = Bukkit.getOfflinePlayer(args[0]);
			
			CoinPlayer otherPlayer = CoinPlayer.getCoinPlayer(other.getUniqueId());
			
			if(otherPlayer == null) {
				UtilChat.message(sender, "&6» &cThis player is null.");
				return true;
			}
			
			UtilChat.message(sender, "&8» &e" + other.getName() + " &7amount: &e" + otherPlayer.getCoins() + "$.");
		}
		
		else {
			
			return true;
		}
		
		return false;
	}

}
