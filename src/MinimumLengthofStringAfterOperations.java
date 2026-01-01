import java.util.HashMap;
import java.util.Map;

public class MinimumLengthofStringAfterOperations {

    static class Solution {
        public int minimumLength(String s) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    count += 2 - counts[i] % 2;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumLength(""));
    }
}
