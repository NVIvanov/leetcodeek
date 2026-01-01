import java.util.*;

public class ProductoftheLastKNumbers {

    static class ProductOfNumbers {
        private final List<Integer> list = new ArrayList<>();
        private final Map<Integer, Integer> cache = new HashMap<>();

        public ProductOfNumbers() {

        }

        public void add(int num) {
            list.add(num);
            cache.clear();
        }

        public int getProduct(int k) {
            if (cache.containsKey(k)) {
                return cache.get(k);
            }
            int product = 1;
            for (int i = list.size() - 1; i >= list.size() - k; i--) {
                product *= list.get(i);
            }
            cache.put(k, product);
            return product;
        }
    }

}
