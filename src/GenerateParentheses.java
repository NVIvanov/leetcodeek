import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> combinations = new HashMap<>();
        generateParenthesis(n, combinations);
        return combinations.get(n);
    }

    private static void generateParenthesis(int n, Map<Integer, List<String>> combinations) {
        if (n == 1) {
            combinations.put(1, List.of("()"));
            return;
        }
        generateParenthesis(n - 1, combinations);
        Set<String> nComb = new HashSet<>();
        combinations.get(n - 1)
                .forEach(combination -> nComb.add("(" + combination + ")"));
        for (int i = 1; i < n; i++) {
            for (var comb1: combinations.get(i)) {
                for (var comb2: combinations.get(n - i)) {
                    nComb.add(comb1 + comb2);
                }
            }
        }
        combinations.put(n, nComb.stream().toList());
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++)
            System.out.println(generateParenthesis(i));
    }
}
