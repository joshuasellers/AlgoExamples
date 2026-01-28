package javacode.algorithms;

public class MiscProblems {
    
    public MiscProblems() {
    }

    /**
     * Given an input string, return a count of the maximum number of unique strings
     * that can be outputted if you swap two characters exactly once.
     * 
     * Example:
     * Input: "aabb"
     * Output: 5
     * Explanation: The unique strings that can be formed are:
     * "aabb", "abab", "abba", "baab", "baba
     * 
     * @param input
     * @return long The total string from the input
     */
    public long countUniqueSwapsBasic(String input) {
        int n = input.length();
        if (n < 2) return 0;

        java.util.Set<String> uniqueStrings = new java.util.HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                char[] charArray = input.toCharArray();
                // Swap characters at positions i and j
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                uniqueStrings.add(new String(charArray));
            }
        }
        System.out.println("Unique strings formed by swapping two characters: " + uniqueStrings);
        return uniqueStrings.size();
    }

    /**
     * There is a way to do this with just character counts.
     * Steps:
     * 1. Count frequency of each character
     * 2. Calculate total possible swaps: n * (n - 1) / 2
     * 3. Calculate invalid swaps: sum of (freq[c] * (freq[c] - 1) / 2) for each character c
     * 4. Subtract invalid swaps (swaps that don't change the string)
     * 5. Return the count of unique strings
     * 
     * Explanation of formulas:
     * - Total swaps formula n * (n - 1) / 2 gives all possible pairs of positions to swap. This is because
     *   for each of the n positions, you can swap with (n - 1) other positions, but since swapping A with B is the same as swapping B with A,
     *   we divide by 2 to avoid double counting.
     *
     * - Invalid swaps formula freq[c] * (freq[c] - 1) / 2 counts pairs of identical characters that would result in the same string. This is because
     *   swapping two identical characters doesn't create a new unique string.
     * 
     * Time Complexity: O(n) - where n is the length of the input string
     * Space Complexity: O(1) - since the character set is fixed (e.g., ASCII)
     *
     * @param input
     * @return long The total strings from the input
     */
    public long countUniqueSwapsComplex(String input){
        int n = input.length();
        if (n < 2) return 0;

        java.util.Map<Character, Integer> charCount = new java.util.HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        long totalSwaps = (long)n * (n - 1) / 2;
        long invalidSwaps = 0;

        for (int freq : charCount.values()) {
            invalidSwaps += (long)freq * (freq - 1) / 2;
        }

        return totalSwaps - invalidSwaps;
    }
}
