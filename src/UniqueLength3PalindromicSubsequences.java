public class UniqueLength3PalindromicSubsequences {

    static class Solution {
        public int countPalindromicSubsequence(String s) {
            char[] abc = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

            int count = 0;
            for (int i = 0; i < abc.length; i++) {
                for (int j = 0; j < abc.length; j++) {
                    int indexI = s.indexOf(abc[i]);
                    if (indexI != -1) {
                        int indexJ = s.indexOf(abc[j], indexI + 1);
                        if (indexJ != -1) {
                            if (s.indexOf(abc[i], indexJ + 1) != -1) {
                                count++;
                            }
                        }
                    }
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPalindromicSubsequence("ckafnafqo"));
    }
}
