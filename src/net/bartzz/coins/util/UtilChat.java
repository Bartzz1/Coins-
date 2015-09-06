package net.bartzz.coins.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import net.bartzz.coins.Main;

public class UtilChat {
	
	private static String tag = Main.getInstance().getConfig().getString("tag");
	
	public static String fixColors(String text) {
		
		return ChatColor.translateAlternateColorCodes('&', text);
	}

	public static void message(CommandSender sender, String text) {
		
		if(!text.isEmpty()) {
			
			sender.sendMessage(fixColors(text));
		}
	}
	
	public static void broadcast(String text) {
		
		if(!text.isEmpty()) {
			
			Bukkit.getOnlinePlayers().forEach(player -> message(player, text));
		}
	}
	
	public static void tagMessage(CommandSender sender, String text) {
		
		if(!text.isEmpty()) {
			
			sender.sendMessage(fixColors(tag + text));
		}
	}
}
