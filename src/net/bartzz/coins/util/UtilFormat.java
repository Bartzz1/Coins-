package net.bartzz.coins.util;

public class UtilFormat {
	
	public static boolean isInt(String value) {
		try {
			Integer.valueOf(value);
			return true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

}
