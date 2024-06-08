import java.util.*;

public class FindTheTownJudge {

    public static int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> trustMap = new HashMap<>();
        if (trust.length == 0) {
            if (n == 1) {
                return 1;
            } else {
                return -1;
            }
        }
        Set<Integer> trusters = new HashSet<>();
        for (int[] trustPairs : trust) {
            trusters.add(trustPairs[0]);
            int trustee = trustPairs[1];
            trustMap.putIfAbsent(trustee, 0);
            trustMap.computeIfPresent(trustee, (k, v) -> v + 1);
        }

        return trustMap.entrySet()
                .stream().filter(e -> e.getValue() == n - 1 && !trusters.contains(e.getKey()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{
                {1,3},
                {2,3},
                {3,1}
        }));
    }
}
