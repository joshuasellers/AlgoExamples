package javacode.algorithms;

import java.util.ArrayList;
import java.util.List;

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
     * 4. Subtract invalid swaps (swaps that don't change the string) but add 1 if there is at least one pair of identical characters
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

        // If there is at least one pair of identical characters, swapping that pair doesn't create a new string
        if (invalidSwaps > 0) {
            return totalSwaps - invalidSwaps + 1;
        }

        return totalSwaps - invalidSwaps;
    }

    /**
     * Given an input string, return a list of the highest value substrings at each sublength that have the highest
     * sum of character values (a=1, b=2, ..., z=26). Substring must retain original order, but don't have to be contiguous.
     * 
     * Example:
     * Input: "abc"
     * Output: ["abc", "bc", "c"]
     * Explanation:
     * - Length 3: "abc" (sum=6)
     * - Length 2: "ab" (sum=3), "bc" (sum=5) -> "bc" is highest
     * - Length 1: "a" (sum=1), "b" (sum=2), "c" (sum=3) -> "c" is highest
     *
     * Steps:
     * 1. Precompute character values for the input string.
     * 2. For each possible substring length L from n down to 1:
     *    a. Create a list of indices from 0 to n-1.
     *    b. Sort indices based on character values in descending order, using original index as a tiebreaker.
     *    c. Select the top L indices and sort them to restore original order.
     *    d. Construct the substring from these indices and add to the result list.
     * 3. Return the list of highest value substrings.
     * 
     * Time Complexity: O(n^2 log n) - due to sorting for each substring length
     * Space Complexity: O(n) - for storing indices and result substrings
     * 
     * @param input
     * @return List<String> The list of highest value substrings
     */
    public List<String> getHighestSubstrings(String input){
        // Precompute values
        int[] value = new int[input.length()];
        for (int i = 0; i < input.length(); i++) value[i] = (input.charAt(i) - 'a' + 1);

        List<String> result = new ArrayList<>();
        // For each length L, pick the L indices with largest values, then restore order
        for (int L = input.length(); L >= 1; L--) { 
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) indices.add(i);

            // sort by value desc, tie-break by index asc
            indices.sort((i, j) -> {
                int cmp = Integer.compare(value[j], value[i]); // descending by value
                return (cmp != 0) ? cmp : Integer.compare(i, j);
            });

            List<Integer> top = indices.subList(0, L);
            top.sort(Integer::compareTo); // restore original order

            StringBuilder sb = new StringBuilder();
            for (int idx : top) sb.append(input.charAt(idx));
            result.add(sb.toString());
        }

        return result;
    }
}
