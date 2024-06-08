import java.util.*;
import java.util.stream.IntStream;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        /*
            нам нужно отношение кол-во повторений и кол-во разных чисел с таким повторением (не сами числа).

            проходимся по каждому entry пока k != 0;

            выгоднее всего идти начиная с entry, где уникальных чисел повторяется меньше всего, от 1 и по возрастанию

            пока (k != 0)
                сколько мы можем вычесть? = min(k / i, map[i]), где i, кол-во повторений. Если остались числа со многими повторениями,
                нам выгодно вычитать по максимуму из них, чтобы сократить кол-во уникальных чисел.
                Если мы можем вычесть всё - гуд, обнуляем map[i] и переходим к следующему i (ключи мапы).
                map[i] -= сколько смогли вычесть

            возвращаем сумму оставшихся значений в map.

         */
        Map<Integer, Integer> numbers = new HashMap<>(); //тут будут числа и сколько они повторяются
        SortedMap<Integer, Integer> counts = new TreeMap<>(); //тут будут количества повторений и уникальных чисел
        for (int j : arr) {
            if (!numbers.containsKey(j)) {
                numbers.put(j, 1);
            } else {
                numbers.replace(j, numbers.get(j) + 1);
            }
        }

        numbers.forEach((key, value) -> {
            if (!counts.containsKey(value)) {
                counts.put(value, 1);
            } else {
                counts.replace(value, counts.get(value) + 1);
            }
        });

        for(var entry: counts.entrySet()) {
            if (k > 0) {
                var uniqueNumbersToSubtract = Math.min(k / entry.getKey(), entry.getValue());
                entry.setValue(entry.getValue() - uniqueNumbersToSubtract);
                k -= uniqueNumbersToSubtract * entry.getKey();
            }
        }

        return counts.values().stream().mapToInt(x -> x).sum();
    }

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }
}
