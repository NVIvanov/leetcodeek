import java.util.*;

public class GreatestCommonDivisorTraversal {

    public static boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> toVisit = new LinkedList<>();

        for (int num : nums) {
            if (num == 1) {
                return false;
            }
            var factors = primeFactors(num);
            for (int j = 0; j < factors.size(); j++) {
                graph.putIfAbsent(factors.get(j), new ArrayList<>());
                if (j != 0 && !Objects.equals(factors.get(j - 1), factors.get(j))) {
                    graph.get(factors.get(j - 1)).add(factors.get(j));
                    graph.get(factors.get(j)).add(factors.get(j - 1));
                }
            }
        }
        System.out.println(graph);

        var minFactor = graph.keySet().stream().sorted().findFirst().get();
        toVisit.add(minFactor);

        while (!toVisit.isEmpty()) {
            var factor = toVisit.poll();
            if (!visited.contains(factor)) {
                for (var next: graph.get(factor)) {
                    if (!visited.contains(next)) {
                        toVisit.add(next);
                    }
                }
                visited.add(factor);
            }
        }

        System.out.println(visited);

        return graph.size() == visited.size();
    }

    private static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        SortedSet<Integer> factors = new TreeSet<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return new ArrayList<>(factors);
    }

    public static void main(String[] args) {
        System.out.println(canTraverseAllPairs(new int[]{40,22,15}));
    }
}
