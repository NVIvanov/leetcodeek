import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Map<Integer, Map<Integer, Integer>>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            List<LinkedList<Integer>> threeSumRes = threeSum(nums, -nums[i]+target, i + 1);
            if (threeSumRes.isEmpty()) {
                continue;
            }
            for (LinkedList<Integer> threeSum : threeSumRes) {
                if (map.containsKey(nums[i]) &&
                    map.get(nums[i]).containsKey(threeSum.getFirst())
                    && Objects.equals(map.get(nums[i]).get(threeSum.getFirst()).get(threeSum.get(1)), threeSum.getLast())) {
                    continue;
                }
                map.put(nums[i], map.getOrDefault(nums[i], new HashMap<>()));
                map.get(nums[i]).put(threeSum.getFirst(), map.get(nums[i]).getOrDefault(threeSum.get(1), new HashMap<>()));
                map.get(nums[i]).get(threeSum.getFirst()).put(threeSum.get(1), threeSum.getLast());
                threeSum.addFirst(nums[i]);
                result.add(threeSum);
            }

        }
        return result;
    }

    public List<LinkedList<Integer>> threeSum(int[] nums, int target, int index) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        List<LinkedList<Integer>> result = new ArrayList<>();
        for (int i = index; i < nums.length - 2; i++) {
            List<LinkedList<Integer>> twoSumRes = twoSum(nums, -nums[i]+target, i + 1);
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
        System.out.println(new FourSum().fourSum(new int[]{-5,-2,-4,-2,-5,-4,0,0}, -13));
    }
}
