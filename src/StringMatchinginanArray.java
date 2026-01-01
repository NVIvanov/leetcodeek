import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchinginanArray {

    static class Solution {
        public List<String> stringMatching(String[] words) {
            Set<String> result = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (!words[i].equals(words[j]) && words[i].contains(words[j])) {
                        result.add(words[j]);
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }

    public static void main(String[] args) {

    }
}
