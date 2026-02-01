public class CountofSubstringsContainingEveryVowelandKConsonantsII {
    static class Solution {
    
        public long countOfSubstrings(String word, int k) {
            int n = word.length();
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    String sub = word.substring(i, j + 1);
                    java.util.Set<Character> vowels = new java.util.HashSet<>();
                    int consonants = 0;
                    for (char char_ : sub.toCharArray()) {
                        if ("aeiou".indexOf(char_) != -1) {
                            vowels.add(char_);
                        } else {
                            consonants++;
                        }
                    }
                    if (vowels.size() == 5 && consonants == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countOfSubstrings("iqeaouqi", 2));
    }
}
