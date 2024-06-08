import java.util.Arrays;

public class DivideaStringIntoGroupsofSizek {

    public static String[] divideString(String s, int k, char fill) {
        String[] result = new String[s.length() / k + Math.min(1, s.length() % k)];
        for (int i = 0; i < s.length(); i++) {
            if (i % k == 0) {
                result[i / k] = s.substring(i, Math.min(i + k, s.length()));
            }
        }
        int lastLength = result[result.length - 1].length();
        if (lastLength < k) {
            result[result.length - 1] = result[result.length - 1] + String.valueOf(fill).repeat(k - lastLength);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }
}
