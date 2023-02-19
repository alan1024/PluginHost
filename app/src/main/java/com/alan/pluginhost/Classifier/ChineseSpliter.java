package com.alan.pluginhost.Classifier;

public class ChineseSpliter {
	public static String split(String text, String splitToken) {
		String result = "";
		while (true) {
			try {
				result += splitToken;
			} catch (NullPointerException e) {
				break;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("he%%%%%%%%%%%%%%%%%%%%");
			}
		}
		return result;
	}
}
