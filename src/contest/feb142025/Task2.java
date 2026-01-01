package contest.feb142025;

public class Task2 {

    static class Solution {
        public double separateSquares(int[][] squares) {
            double accDiff = Math.pow(10, -5);
            double totalSquareSum = 0;
            double maxY = Integer.MIN_VALUE;
            for (var square : squares) {
                totalSquareSum += ((double) square[2]) * square[2];
                maxY = Math.max(maxY, ((double) square[1]) + square[2]);
            }
            double target = totalSquareSum / 2;
            double l = 0, r = maxY;
            while ((r - l) > accDiff) {
                double mid = l + (r - l) / 2;
                var sqUnderMid = squareUnderLine(squares, mid);
                if (sqUnderMid - target > accDiff) {
                    r = mid;
                } else if (target - sqUnderMid > accDiff) {
                    l = mid;
                } else {
                    return findMinNearestY(squares, mid);
                }
            }
            return l;
        }

        private double findMinNearestY(int[][] squares, double y) {
            double maxY = Integer.MIN_VALUE;
            for (var square : squares) {
                if (square[1] < y && ((double)square[1]) + square[2] > y) {
                    return y;
                }
                if (((double) square[1]) + square[2] > y) {
                    continue;
                }
                maxY = Math.max(maxY, ((double) square[1]) + square[2]);
            }
            return maxY;
        }

        private double squareUnderLine(int[][] squares, double y) {
            double squareSum = 0;
            for (var square : squares) {
                squareSum += (double) square[2] * yDiff(square, y);
            }
            return squareSum;
        }

        private double yDiff(int[] square, double y) {
            return Math.min(Math.max(y - square[1], 0), square[2]);
        }
    }

    /*

        площадь всех прямоугольников можно посчитать

        площадь прямоугольников под линией =

        (y0 - ys1) * xs1 + (y0 - ys2) * xs2 + ... + (y0 - ysn) * xsn

     */
    public static void main(String[] args) {
        System.out.println(new Solution().separateSquares(new int[][]{
                {522261215,954313664,461744743},
                {628661372,718610752,21844764},
                {619734768,941310679,91724451},
                {352367502,656774918,591943726},
                {860247066,905800565,853111524},
                {817098516,868361139,817623995},
                {580894327,654069233,691552059},
                {182377086,256660052,911357},
                {151104008,908768329,890809906},
                {983970552,992192635,462847045}
        }));
    }
}
