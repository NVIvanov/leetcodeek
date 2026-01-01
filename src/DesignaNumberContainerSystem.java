import java.util.*;

public class DesignaNumberContainerSystem {

    static class NumberContainers {
        Map<Integer, Integer> indexToValue = new HashMap<>();
        Map<Integer, SortedSet<Integer>> valueToIndex = new HashMap<>();

        public NumberContainers() {

        }

        public void change(int index, int number) {
            if (indexToValue.containsKey(index)) {
                var currentValue = indexToValue.get(index);
                valueToIndex.get(currentValue).remove(index);
            }
            indexToValue.put(index, number);
            valueToIndex.putIfAbsent(number, new TreeSet<>());
            valueToIndex.get(number).add(index);
        }

        public int find(int number) {
            var indexes = valueToIndex.get(number);
            if (indexes != null && !indexes.isEmpty()) {
                return indexes.first();
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        System.out.println(numberContainers.find(10));
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        System.out.println(numberContainers.find(10));
        numberContainers.change(1, 20);
        System.out.println(numberContainers.find(10));
    }
}
