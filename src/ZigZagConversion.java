import java.util.*;
import java.util.stream.Collectors;

public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        int direction = 1, j = 0;
        Map<Integer, List<String>> zigzag = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            zigzag.put(i, new LinkedList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            zigzag.get(j).add(String.valueOf(s.charAt(i)));
            j+=direction;
            if (j == numRows - 1 || j == 0) {
                direction *= -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(String.join("", zigzag.get(i)));
        }
        System.out.println(sb);
    }
}
