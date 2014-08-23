package com.nexters.etc;

public class Util {

	public static String padRight(String s, int n) {
		return String.format("%-" + n + "s", s).replace(' ', '　');
	}

}
