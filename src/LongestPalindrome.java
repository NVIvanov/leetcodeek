import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (Character c: s.toCharArray()) {
            if (counts.containsKey(c)) {
                counts.replace(c, counts.get(c) + 1);
            } else {
                counts.put(c, 1);
            }
        }
        int sum = 0;
        for (var num: counts.values()) {
            sum += num - num % 2;
        }
        return sum < s.length() ? sum + 1: sum;
    }

    public static void main(String[] args) {
        var s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
        System.out.println(s.length());
    }
}
