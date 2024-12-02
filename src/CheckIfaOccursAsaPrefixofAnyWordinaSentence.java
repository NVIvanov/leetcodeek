public class CheckIfaOccursAsaPrefixofAnyWordinaSentence {

    static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int wordIndex = 0;
            int index = 0;
            while (index < sentence.length()) {
                wordIndex++;
                boolean found = true;
                int searchWordIndex = 0;
                while (index < sentence.length() && searchWordIndex < searchWord.length()
                        && sentence.charAt(index) != ' ') {
                    if (sentence.charAt(index++) != searchWord.charAt(searchWordIndex++)) {
                        found = false;
                        break;
                    }
                }
                index = sentence.indexOf(' ', index);
                if (index == -1) {
                    return found && searchWord.length() == searchWordIndex ? wordIndex : -1;
                }
                index++;
                if (found && searchWord.length() == searchWordIndex) {
                    return wordIndex;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixOfWord("i am tired", "you"));
    }
}
