package de.wwu.controlstructures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

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

	private String numberToString(int n) {
		if (n < 0) {
			return "minus " + numberToString(-n);
		}
		if (n == 0) {
			return "null";
		}
		String word = "";
		// Get the amount of blocks which each consist of three digits
		int blockCount = (int) (Math.log10(n) / 3 + 1);
		// Iterate in reverse order over the blocks to get the right order
		for (int i = blockCount - 1; i >= 0; i--) {
			// Extract the block from the number
			int block = (int) (n / Math.pow(1000, i) % 1000);
			if (block > 0) {
				// Generate the beginning of the number string and parse the block
				String s = (i != 0 && block == 1 ? (i > 1 ? "eine" : "ein") : blockToString(block));
				
				word += s + " ";
				if (block > 0) {
					// Edge case for one million
					if (i == 2 && block == 1) {
						word += "million ";
					}
					// Edge case for blocks with an ending word
					else if (i > 0) {
						word += numbers.get((int) Math.pow(10, i * 3)) + " ";
					}
				}
			}
		}
		return word;
	}

	private String blockToString(int n) {		
		// If the block is present in the look-up map just return it
		if (numbers.containsKey(n)) {
			return numbers.get(n);
		}
		
		String s = "";
		
		// Get the left-most digit of the block
		int digit = (int) (n / 100 % 10);
		if (digit > 0) {
			// Note: Edge case for one hundred
			s += (digit == 1 ? "ein" : numbers.get(digit)) + " hundert ";
		}
		
		// Get the two right-most digits as number
		int ten = n % 100;
		// Get the left digit of the two digit number
		digit = ten % 10;
		if (numbers.containsKey(ten)) {
			s += numbers.get(ten);
		} else {
			// Put everything together
			// Edge Case: Numbers above twenty need concatenation
			s += (digit == 1 ? "ein" : numbers.get(digit)) + (ten > 20 ? " und " : "") + numbers.get(ten / 10 * 10);
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
//		try {
//			File file = new File("H:\\output.txt");
//			System.out.println(file.getAbsolutePath());
//			PrintStream writer = new PrintStream(file);
//			for (int i = -1000; i <= 10000; i++) {
//				writer.println(i);
//				writer.println(controlStructures.numberToString(i));
//			}
//			writer.flush();
//			writer.close();
//			System.out.println("Finished!");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println(controlStructures.numberToString(Integer.MIN_VALUE + 1));
		System.out.println(controlStructures.numberToString(Integer.MAX_VALUE));
	}

}
