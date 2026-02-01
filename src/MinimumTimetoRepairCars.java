public class MinimumTimetoRepairCars {
    static class Solution {
        public long repairCars(int[] ranks, int cars) {
            int l = 0, r = Integer.MAX_VALUE;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (canRepair(ranks, cars, mid)) {
                    r = (int)mid;
                } else {
                    l = (int)mid + 1;
                }
            }
            return l;
        }

        private boolean canRepair(int[] ranks, int cars, long atMostTime) {
            if (atMostTime == 0) {
                return false;
            }
            int count = 0, i = 0;
            while (i < ranks.length && count < cars) {
                count += Math.floor(Math.sqrt(atMostTime / ranks[i]));
                i++;
            }
            return count >= cars;
        }
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.canRepair(new int[]{5,1,8}, 6, 17));
    }
}
