package leetcode424;

public class Main {
	public static void main(String[] args) {
		String s = "ABCC";
		
		int k = 1;
		
		System.out.println("input: " + s + " k: " + k);
		
		FindLongestRepeatingReplacementFunction solution = new FindLongestRepeatingReplacementFunction();
		
		System.out.println("Solution: " + solution.characterReplacement(s, k));
	}
}
