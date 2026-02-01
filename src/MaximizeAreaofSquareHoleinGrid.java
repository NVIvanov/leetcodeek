import java.util.Arrays;

public class MaximizeAreaofSquareHoleinGrid {

    static class Solution {
        public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
            Arrays.sort(hBars);
            Arrays.sort(vBars);
            int hx = hBars[0], hy = hBars[0], vx = vBars[0], vy = vBars[0];
            int hxMax = hx, hyMax = hy, vxMax = vx, vyMax = vy;

            for (int i = 1; i < hBars.length; i++) {
                if (hBars[i] != hBars[i - 1] + 1) {
                    if (hy - hx > hyMax - hxMax) {
                        hxMax = hx;
                        hyMax = hy;
                    }
                    if (i < hBars.length - 1) {
                        hx = hBars[i + 1];
                        hy = hBars[i + 1];
                    }
                } else {
                    hy++;
                }
            }

            if (hy - hx > hyMax - hxMax) {
                hxMax = hx;
                hyMax = hy;
            }

            for (int i = 1; i < vBars.length; i++) {
                if (vBars[i] != vBars[i - 1] + 1) {
                    if (vy - vx > vyMax - vxMax) {
                        vxMax = vx;
                        vyMax = vy;
                    }
                    if (i < vBars.length - 1) {
                        vx = vBars[i + 1];
                        vy = vBars[i + 1];
                    }
                } else {
                    vy++;
                }
            }

            if (vy - vx > vyMax - vxMax) {
                vxMax = vx;
                vyMax = vy;
            }

            int maxSquareLength = Math.min(vyMax - vxMax + 2, hyMax - hxMax + 2);
            return maxSquareLength * maxSquareLength;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximizeSquareHoleArea(3, 2, new int[]{3,2,4}, new int[]{3,2}));
    }
}
