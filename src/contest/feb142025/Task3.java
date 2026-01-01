package contest.feb142025;

import java.util.*;

public class Task3 {

    static class Solution {
        private Event[] events;
        private double[] globalYCoords;

        public double separateSquares(int[][] squares) {
            init(squares);

            double maxY = 0;
            for (int[] square : squares) {
                maxY = Math.max(maxY, square[1] + square[2]);
            }

            double totalArea = unionAreaUnderLine(maxY);
            double target = totalArea / 2;

            double accDiff = 1e-5;
            double l = 0, r = maxY;
            int iterations = 0, maxIterations = 100;
            while ((r - l) > accDiff && iterations < maxIterations) {
                double mid = l + (r - l) / 2;
                double areaUnderMid = unionAreaUnderLine(mid);
                if (areaUnderMid > target + accDiff) {
                    r = mid;
                } else if (areaUnderMid < target - accDiff) {
                    l = mid;
                } else {
                    return findMinNearestY(squares, mid);
                }
                iterations++;
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

        private void init(int[][] squares) {
            int n = squares.length;
            events = new Event[2 * n];
            TreeSet<Double> ySet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int[] s = squares[i];
                double x = s[0];
                double y = s[1];
                double side = s[2];
                double top = y + side;
                events[2 * i] = new Event(x, y, top, 1);
                events[2 * i + 1] = new Event(x + side, y, top, -1);
                ySet.add(y);
                ySet.add(top);
            }
            Arrays.sort(events, Comparator.comparingDouble(e -> e.x));
            globalYCoords = new double[ySet.size()];
            int idx = 0;
            for (double d : ySet) {
                globalYCoords[idx++] = d;
            }
        }

        private double unionAreaUnderLine(double yLine) {

            int pos = Arrays.binarySearch(globalYCoords, yLine);
            boolean yLineExists = pos >= 0;
            int len = yLineExists ? pos + 1 : -pos - 1;
            int segSize = yLineExists ? len : len + 1;
            double[] segCoords = new double[segSize];
            for (int i = 0; i < len; i++) {
                segCoords[i] = globalYCoords[i];
            }
            if (!yLineExists) {
                segCoords[segSize - 1] = yLine;
            }

            SegmentTree segTree = new SegmentTree(segCoords);

            double area = 0;
            double prevX = (events.length > 0) ? events[0].x : 0;

            for (Event event : events) {
                if (event.y1 >= yLine) continue;

                double curX = event.x;
                double dx = curX - prevX;
                double coveredY = segTree.totalCoveredLength();
                area += dx * coveredY;

                double effectiveY1 = event.y1;
                double effectiveY2 = Math.min(event.y2, yLine);
                if (effectiveY1 < effectiveY2 - 1e-9) {
                    int L = lowerBound(segCoords, effectiveY1);
                    int R = lowerBound(segCoords, effectiveY2);
                    segTree.update(1, 0, segTree.n, L, R, event.type);
                }

                prevX = curX;
            }
            return area;
        }

        private int lowerBound(double[] arr, double target) {
            int lo = 0, hi = arr.length;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (arr[mid] < target - 1e-9) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        private static class Event {
            double x, y1, y2;
            int type;
            public Event(double x, double y1, double y2, int type) {
                this.x = x;
                this.y1 = y1;
                this.y2 = y2;
                this.type = type;
            }
        }

        private static class SegmentTree {
            int n;
            double[] tree;
            int[] cover;
            double[] coords;

            public SegmentTree(double[] coords) {
                this.coords = coords;
                this.n = coords.length - 1;
                tree = new double[4 * n];
                cover = new int[4 * n];
            }

            public void update(int node, int nodeL, int nodeR, int qL, int qR, int delta) {
                if (qR <= nodeL || nodeR <= qL) return;
                if (qL <= nodeL && nodeR <= qR) {
                    cover[node] += delta;
                } else {
                    int mid = (nodeL + nodeR) / 2;
                    update(node * 2, nodeL, mid, qL, qR, delta);
                    update(node * 2 + 1, mid, nodeR, qL, qR, delta);
                }
                if (cover[node] > 0) {
                    tree[node] = coords[nodeR] - coords[nodeL];
                } else if (nodeR - nodeL == 1) {
                    tree[node] = 0;
                } else {
                    tree[node] = tree[node * 2] + tree[node * 2 + 1];
                }
            }

            public double totalCoveredLength() {
                return tree[1];
            }
        }
    }



    public static void main(String[] args) {
        System.out.println(new Solution().separateSquares(new int[][]{
                {0, 0, 2},
                {1,1,1}
        }));
    }

}
