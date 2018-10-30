package de.wwu.controlstructures;

public class ControlStructures {

	//aufgabe 1
	private String triangleTest(int a, int b, int c) {
		int[] sides = new int[] { a, b, c };
		for (int i = 0; i < sides.length; i++) {
			if (sides[i] >= sides[(i + 1) % sides.length] + sides[(i + 2) % sides.length]) {
				return "Nicht konstruierbar, da Seite " + (char) ('a' + i) + " zu lang.";
			}
		}
		return "Konstruierbar!";
	}
	
	/*
	 * In dreier Blöcke aufteilen. Benennung des dreier Blocks ausgeben.
	 */
	private String numberToString(int n){
		while (n > 0) {
			int blockIndex = (int) Math.log10(n) / 3;
			n -= Math.pow(10, blockIndex * 3);
			System.out.println(blockIndex);
		}
		return "";
	}
	
	// aufgabe 5
	private String generateLockCodes(){
		StringBuilder builder = new StringBuilder();
		int count = 0;
		codeLoop: for(int i = 0; i < 1000; i++) {
			int[] digits = new int[] { i % 10, i % 100 / 10, i % 1000 / 100 };
			for (int j = 0; j < digits.length; j++) {
				if (digits[j] == digits[(j + 1) % digits.length]) {
					continue codeLoop;
				}
			}
			builder.append(i < 100 ? "0" + i : i).append(' ');
			if (++count % 10 == 0) {
				builder.append('\n');
			}
		}
		return builder.toString();
	}
	
	//aufgabe 6
	private String numberTable(int digit) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			if (i % digit == 0 || i == digit || i % 10 == digit) {
				builder.append(" * ");
			} else {
				builder.append((i < 10 ? " " + i : i) + " ");
			}
			if ((i + 1) % 10 == 0) {
				builder.append('\n');
			}
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		ControlStructures controlStructures = new ControlStructures();
//		System.out.println(controlStructures.triangleTest(10, 10, 10));
//		System.out.println(controlStructures.triangleTest(1, 1, 10));
//		System.out.println(controlStructures.generateLockCodes());
		System.out.println(controlStructures.numberTable(3));
	}
	
}
