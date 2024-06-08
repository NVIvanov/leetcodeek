import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), t.charAt(i));
            revMap.putIfAbsent(t.charAt(i), s.charAt(i));
            if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
            if (!revMap.get(t.charAt(i)).equals(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
