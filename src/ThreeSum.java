import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            List<LinkedList<Integer>> twoSumRes = twoSum(nums, -nums[i], i + 1);
            if (twoSumRes.isEmpty()) {
                continue;
            }
            for (LinkedList<Integer> twoSum : twoSumRes) {
                if (map.containsKey(nums[i]) && Objects.equals(map.get(nums[i]).get(twoSum.getFirst()), twoSum.getLast())) {
                    continue;
                }
                map.put(nums[i], map.getOrDefault(nums[i], new HashMap<>()));
                map.get(nums[i]).put(twoSum.getFirst(), twoSum.getLast());
                twoSum.addFirst(nums[i]);
                result.add(twoSum);
            }

        }
        return result;
    }

    private List<LinkedList<Integer>> twoSum(int[] nums, int target, int start) {
        int l = start, r = nums.length - 1;
        List<LinkedList<Integer>> result = new ArrayList<>();
        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                LinkedList<Integer> twoSumRes = new LinkedList<>();
                twoSumRes.addFirst(nums[l]);
                twoSumRes.addLast(nums[r]);
                result.add(twoSumRes);
                r--;
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{1,-1,-1,0}));
    }
}
