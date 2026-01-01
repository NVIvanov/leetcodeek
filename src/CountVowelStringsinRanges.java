import java.util.Arrays;
import java.util.Set;

public class CountVowelStringsinRanges {

    static class Solution {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] prefixVowelWords = new int[words.length];
            prefixVowelWords[0] = wordStartsEndsWithVowel(words[0]);
            for (int i = 1; i < words.length; i++) {
                prefixVowelWords[i] = prefixVowelWords[i - 1] + wordStartsEndsWithVowel(words[i]);
            }

            System.out.println(Arrays.toString(prefixVowelWords));

            int[] result = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                result[i] = prefixVowelWords[queries[i][1]] - (queries[i][0] > 0 ? prefixVowelWords[queries[i][0] - 1] : 0);
            }

            return result;
        }

        private int wordStartsEndsWithVowel(String word) {
            return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1)) ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().vowelStrings(
                new String[]{"a","e","i"},
                new int[][]{
                        {0,2},
                        {0,1},
                        {2,2}
                }
        )));
    }
}
