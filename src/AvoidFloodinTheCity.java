import java.util.*;

public class AvoidFloodinTheCity {

    static class Solution   {
        public int[] avoidFlood(int[] rains) {
            int[] res = new int[rains.length];
            Arrays.fill(res, -1);
            List<Integer> dryDays = new ArrayList<>();

            FenwickIndexedSubsets<Integer> lakesFullness = new FenwickIndexedSubsets<>();

            for (int i = 0; i < rains.length; i++) {
                int lake = rains[i];
                if (lake == 0) {
                    dryDays.add(i);
                    continue;
                }
                boolean currentIsFull = lakesFullness.contains(lake);
                if (!currentIsFull) {
                    lakesFullness.add(lake, i);
                } else {
                    if (dryDays.isEmpty()) {
                        return new int[0];
                    }
                    OptionalInt leastSubsetIndex = lakesFullness.leastSubsetIndex(lake);
                    if (leastSubsetIndex.isPresent() && leastSubsetIndex.getAsInt() <= dryDays.getLast()) {
                        Integer dryDay = dryDays.stream().filter(it -> it >= leastSubsetIndex.getAsInt()).findFirst().get();
                        res[dryDay] = lake;
                        dryDays.remove(dryDay);
                        lakesFullness.remove(lake);
                        lakesFullness.add(lake, i);
                    } else {
                        return new int[0];
                    }
                }
            }
            while (!dryDays.isEmpty()) {
                res[dryDays.removeFirst()] = 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{
                1,0,2,0,2,1
        })));
    }
}
