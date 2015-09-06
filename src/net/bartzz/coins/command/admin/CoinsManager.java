package net.bartzz.coins.command.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.bartzz.coins.data.CoinPlayer;
import net.bartzz.coins.manager.CoinPlayerManager;
import net.bartzz.coins.util.UtilChat;
import net.bartzz.coins.util.UtilFormat;

public class CoinsManager implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		if(!sender.hasPermission("coins.manager")) {
			UtilChat.message(sender, "&6» &cYou don't have permission.");
			return true;
		}
		
		if(!(sender instanceof Player)) {
			UtilChat.message(sender, "&6» &cConsole cannot use this command.");
			return true;
		}
		
		if(args.length > 3 || args.length < 3) {
			UtilChat.message(sender, "&6» &cUsage: &7/cmanager <set/add/remove> <player> <value>");
			return true;
		}

		Player other = Bukkit.getPlayer(args[1]);
		
		if(other == null) {
			UtilChat.message(sender, "&6» &cThis player isn't online.");
			return true;
		}
		
		CoinPlayer coinPlayer = CoinPlayer.getCoinPlayer(other.getUniqueId());
		
		if(coinPlayer == null) {
			return true;
		}
		
		if(!UtilFormat.isInt(args[2])) {
			UtilChat.message(sender, "&6» &cValue must be number.");
			return true;
		}
		
		int value = Integer.valueOf(args[2]);
		
		String arg = args[0];
		
		if(arg.equalsIgnoreCase("set")) {
			
			coinPlayer.setCoins(value);
			
			UtilChat.message(sender, "&8» &e" + other.getName() + " &acurrently amount: &e" + value);
		}
		
		else if(arg.equalsIgnoreCase("add")) {
			
			CoinPlayerManager.addCoins(coinPlayer, value);
			
			UtilChat.message(sender, "&8» &e" + other.getName() + " &acurrently amount: &e" + coinPlayer.getCoins());
		}
		
		else if(arg.equalsIgnoreCase("remove")) {
			
			CoinPlayerManager.removeCoins(coinPlayer, value);
			
			UtilChat.message(sender, "&8» &e" + other.getName() + " &acurrently amount: &e" + coinPlayer.getCoins());
		}
		return false;
	}
}
