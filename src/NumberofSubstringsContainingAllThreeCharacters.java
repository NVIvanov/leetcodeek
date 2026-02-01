import java.util.HashMap;
import java.util.Map;

public class NumberofSubstringsContainingAllThreeCharacters {

    static class Solution {
        public int numberOfSubstrings(String s) {
            int result = 0;
            Map<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            while (r < s.length()) {
                while (r < s.length() && map.size() < 3) {
                    map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                    r++;
                }
                if (map.size() == 3) {
                    result += s.length() - r + 1;
                }
                while (map.size() == 3) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                    if (map.get(s.charAt(l)) == 0) {
                        map.remove(s.charAt(l));
                    }
                    l++;
                    if (map.size() == 3) {
                        result += s.length() - r + 1;
                    }
                }
            } 
            return result;
        }
    }


    public static void main(String[] args) {
        
    }

}
