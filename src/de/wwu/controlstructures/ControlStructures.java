package de.wwu.controlstructures;

public class ControlStructures {

	private final Numbers numbers = new Numbers();
	
	// aufgabe 1
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
	private String numberToString(int n) {
		String word = "";
		int blockCount = (int) (Math.log10(n) / 3 + 1);
		for (int i = blockCount - 1; i >= 0; i--) {
			int block = (int) (n / Math.pow(1000, i) % 1000);
			String s = (block == 1 ? "eine" : blockToString(block));
			if (i > 0) {
				s += " " + numbers.get((int) Math.pow(10, i * 3));
			}
			word += s + " ";
		}
		return word;
	}

	private String blockToString(int n) {		
		// Edge Cases
	
		if (numbers.containsKey(n)) {
			return numbers.get(n);
		}
		
		String s = "";
		
		int digit = (int) (n / 100 % 10);
		if (digit > 0) {
			s += (digit == 1 ? "ein" : numbers.get(digit)) + " hundert ";
		}
		
		int ten = n % 100;
		if (numbers.containsKey(ten)) {
			s += numbers.get(ten);
		} else {
			s += numbers.get(ten % 10) + " und " + numbers.get(ten / 10 * 10);
		}

		return s;
	}

	// aufgabe 5
	private String generateLockCodes() {
		StringBuilder builder = new StringBuilder();
		int count = 0;
		codeLoop: for (int i = 0; i < 1000; i++) {
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

	// aufgabe 6
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
		// System.out.println(controlStructures.triangleTest(10, 10, 10));
		// System.out.println(controlStructures.triangleTest(1, 1, 10));
		// System.out.println(controlStructures.generateLockCodes());
		for (int i = 0; i < 100000; i++) {
			System.out.println(i);
			System.out.println(controlStructures.numberToString(i));
		}
	}

}
