import java.util.*;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void backtrack(int[] candidates, int target, List<Integer> current, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], current, result, i); // not i + 1 because we can reuse same elements
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }
}
