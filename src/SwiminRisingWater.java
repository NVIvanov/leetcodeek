import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SwiminRisingWater {

    static class Solution {
        private static final int[][] dirs = new int[][]{
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        public int swimInWater(int[][] grid) {
            int a = 0, b = grid.length * grid.length;
            while (a < b) {
                int mid = (a + b) / 2;
                if (canGoTillEnd(grid, mid)) {
                    b = mid;
                } else {
                    a = mid + 1;
                }
            }
            return b;
        }

        private boolean canGoTillEnd(int[][] grid, int t) {
            Queue<Node> toVisit = new LinkedList<>();
            toVisit.add(new Node(0,0));
            Set<Node> visited = new HashSet<>();
            while (!toVisit.isEmpty()) {
                Set<Node> next = new HashSet<>();
                while (!toVisit.isEmpty()) {
                    Node curr = toVisit.poll();
                    visited.add(curr);
                    if (grid[curr.x][curr.y] > t) {
                        continue;
                    }
                    if (curr.x == grid.length - 1 && curr.y == grid.length - 1) {
                        return true;
                    }
                    for (var dir: dirs) {
                        Node nextNode = nextNode(curr, dir);
                        if (validDirection(nextNode.x, nextNode.y, grid.length) && !visited.contains(nextNode)) {
                            next.add(nextNode);
                        }
                    }
                }
                toVisit.addAll(next);
            }
            return false;
        }

        private boolean validDirection(int x, int y, int n) {
            return x >= 0 && y >= 0 && x < n && y < n;
        }

        private Node nextNode(Node curr, int[] dir) {
            return new Node(curr.x + dir[0], curr.y + dir[1]);
        }

        record Node(int x, int y) {}
    }

    public static void main(String[] args) {
        System.out.println(new Solution().swimInWater(new int[][]{
                {105,209,171,91,64,394,279,11,45,84,207,321,216,197,381,377,78,19,203,198},{141,10,335,170,265,104,338,40,397,376,346,356,212,154,280,177,247,90,87,360},{99,59,242,149,344,172,276,230,133,193,284,345,46,363,30,142,295,70,224,200},{251,88,379,72,319,272,243,165,180,182,387,264,23,67,137,342,125,139,144,367},{94,211,151,37,290,112,343,157,300,271,260,373,369,294,289,57,44,12,20,340},{220,368,186,277,181,187,273,214,315,337,328,18,231,223,331,75,275,96,135,150},{202,74,27,184,399,341,49,62,261,86,314,383,302,257,61,148,268,120,36,25},{15,253,285,185,226,146,126,122,83,361,110,234,183,239,52,190,152,81,136,188},{39,199,358,26,301,116,32,386,29,138,393,159,102,140,370,227,282,111,5,33},{189,35,132,54,210,235,28,353,281,127,318,58,100,286,384,24,307,252,80,103},{244,176,124,79,161,355,218,398,392,380,225,121,178,352,329,322,167,51,313,85},{107,118,351,287,324,283,48,320,82,364,357,16,219,330,89,143,241,262,71,191},{95,97,3,7,270,249,213,339,362,298,4,258,248,390,299,306,156,164,109,229},{221,9,228,160,274,263,374,147,98,63,13,41,326,396,349,372,385,317,325,266},{53,131,173,312,174,114,250,119,163,22,246,92,278,365,292,215,14,304,204,73},{233,323,366,130,378,305,311,93,134,217,297,327,232,194,240,1,208,6,310,47},{69,101,332,195,254,236,50,166,56,168,267,17,359,347,65,316,238,296,348,222},{76,123,129,293,391,2,245,108,303,38,66,55,43,256,162,60,179,77,336,21},{196,388,333,395,42,382,291,237,288,375,128,145,192,158,350,259,206,34,334,255},{201,175,153,68,205,155,115,269,389,169,371,308,117,31,354,8,113,309,106,0}
        }));
    }

}
