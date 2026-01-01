public class MinimumCostForTickets {

    static class Solution {
        /*
           minCost[0] = min(costs)
           minCost[7] = min(costs[0] * 7, costs[1], costs[2])
           minCost[30] = min(costs[0] * 30, costs[1] * 4 + costs[0] * 2, costs[2])

           minCost[N][0] = min(minCosts[N-1]) + costs[0]

           minCost[N][1] = min(minCost[N-7]) + minCost[7]
           minCost[N][2] = min(minCost[N-30]) + minCost[30]

         */
        public int mincostTickets(int[] days, int[] costs) {
            int[][] dp = new int[365][costs.length];
            return -1;
        }

        private int minCost1(int[] costs) {
            return min(costs);
        }

        private int minCost7(int[] costs) {
            return min(costs[0] * 7, costs[1], costs[2]);
        }

        private int minCost30(int[] costs) {
            return min(costs[0] * 30, costs[1] * 7 + costs[0] * 2, costs[2]);
        }

        private static int min(int... vals) {
            int m = Integer.MAX_VALUE;
            for (int val : vals) {
                m = Math.min(m, val);
            }
            return m;
        }
    }

    public static void main(String[] args) {

    }
}
