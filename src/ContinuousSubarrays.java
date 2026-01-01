import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContinuousSubarrays {

    static class Solution {
        public long continuousSubarrays(Integer[] nums) {
            int l = 0, r = 0;
            int min = nums[0], max = nums[0];
            Map<Integer, Integer> minIndex = new HashMap<>();
            Map<Integer, Integer> maxIndex = new HashMap<>();
            List<List<Integer>> indexes = new ArrayList<>();
            while (r < nums.length) {
                while (r < nums.length) {
                    if (Math.abs(nums[r] - min) <= 2 && Math.abs(nums[r] - max) <= 2) {
                        if (nums[r] <= min) {
                            min = nums[r];
                            minIndex.put(nums[r], r);
                        }
                        if (nums[r] >= max) {
                            max = nums[r];
                            maxIndex.put(nums[r], r);
                        }
                        r++;
                    } else {
                        if (r - l > 0) {
                            if (indexes.isEmpty() || indexes.getLast().getLast() != r - 1) {
                                indexes.add(List.of(l, r - 1));
                            }
                            l = Math.min(minIndex.get(min), maxIndex.get(max)) + 1;
                            r = l;
                            min = nums[l];
                            minIndex.put(nums[l], l);
                            max = nums[r];
                            maxIndex.put(nums[r], r);
                        }
                    }
                }
            }

            indexes.add(List.of(l, r - 1));

            return calcIntervals(indexes);
        }
    }

    public static long calcIntervals(List<List<Integer>> intervals) {
        long result = 0;
        for (int i = 0; i < intervals.size(); i++) {
            int length = intervals.get(i).getLast() - intervals.get(i).getFirst() + 1;
            result += (long) length * (length + 1) / 2;
        }

        List<List<Integer>> overlappedIntervals = calcOverlappedIntervals(intervals);

        int sign = -1;
        while (!overlappedIntervals.isEmpty()) {
            for (int i = 0; i < overlappedIntervals.size(); i++) {
                int length = overlappedIntervals.get(i).getLast() - overlappedIntervals.get(i).getFirst() + 1;
                result += sign * ((long) length * (length + 1) / 2);
            }
            sign *= -1;
            overlappedIntervals = calcOverlappedIntervals(overlappedIntervals);
        }

        return result;
    }

    public static List<List<Integer>> calcOverlappedIntervals(List<List<Integer>> intervals) {
        if (intervals.size() == 1) {
            return Collections.emptyList();
        }
        intervals = intervals.stream().sorted(Comparator.<List<Integer>>comparingInt(List::getFirst).thenComparingInt(List::getLast)).toList();
        Set<List<Integer>> overlappedIntervals = new HashSet<>();
        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(i).getLast() >= intervals.get(j).getFirst()) {
                    overlappedIntervals.add(List.of(intervals.get(j).getFirst(), intervals.get(i).getLast()));
                }
            }
        }

        return overlappedIntervals.stream().sorted(Comparator.<List<Integer>>comparingInt(List::getFirst).thenComparingInt(List::getLast)).toList();
    }

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10000; j++) {
                nums.add(i);
                nums.add(i+1);
            }
        }

        System.out.println(
                new Solution().continuousSubarrays(nums.toArray(new Integer[0]))
        );
    }
}
