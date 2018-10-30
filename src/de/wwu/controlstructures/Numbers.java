package de.wwu.controlstructures;

import java.util.HashMap;

public class Numbers extends HashMap<Integer, String> {

	public Numbers() {
		put(0, "null");
		put(1, "eins");
		put(2, "zwei");
		put(3, "drei");
		put(4, "vier");
		put(5, "fünf");
		put(6, "sechs");
		put(7, "sieben");
		put(8, "acht");
		put(9, "neun");
		put(10, "zehn");
		put(11, "elf");
		put(12, "zwölf");
		put(20, "zwanzig");
		put(30, "dreizig");
		put(40, "vierzig");
		put(50, "fünfzig");
		put(60, "sechszig");
		put(70, "siebzig");
		put(80, "achtzig");
		put(90, "neunzig");
		put(100, "hundert");
		put((int) Math.pow(10, 3), "tausend");
		put((int) Math.pow(10, 6), "million");
		put((int) Math.pow(10, 9), "milliarden");
	}

}
