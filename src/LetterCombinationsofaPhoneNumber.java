import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));

        List<String> result = new ArrayList<>();
        for (var digit : digits.split("")) {
            backtrack(result, map, digit);
        }
        return result;
    }

    private static void backtrack(List<String> result, Map<String, List<String>> map, String digit) {
        List<String> res1 = new ArrayList<>();
        if (result.isEmpty()) {
            result.addAll(map.get(digit));
            return;
        }
        for (var res: result) {
            for (var options: map.get(digit)) {
                res1.add(res + options);
            }
        }
        result.clear();
        result.addAll(res1);
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
