import java.util.Comparator;

public class CustomSortString {

    public static String customSortString(String order, String s) {
        return s.chars().boxed().sorted(Comparator.comparingInt(order::indexOf))
                .map(i -> (char) i.intValue())
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("bcafg", "abcd"));
    }
}
