import java.util.*;
import java.util.stream.Stream;

public class MaximumSquareAreabyRemovingFencesFromaField {

    static class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            List<Integer> hFencesList = new ArrayList<>();
            hFencesList.add(1);
            hFencesList.addAll(Arrays.stream(hFences).boxed().toList());
            hFencesList.add(m);
            hFencesList.sort(Comparator.naturalOrder());

            List<Integer> vFencesList = new ArrayList<>();
            vFencesList.add(1);
            vFencesList.addAll(Arrays.stream(vFences).boxed().toList());
            vFencesList.add(n);
            vFencesList.sort(Comparator.naturalOrder());

            List<Integer> hEdges = new ArrayList<>();
            List<Integer> vEdges = new ArrayList<>();

            for (int i = 0; i < hFencesList.size() - 1; i++) {
                for (int j = i + 1; j < hFencesList.size(); j++) {
                    hEdges.add(hFencesList.get(j) - hFencesList.get(i));
                }
            }

            for (int i = 0; i < vFencesList.size() - 1; i++) {
                for (int j = i + 1; j < vFencesList.size(); j++) {
                    vEdges.add(vFencesList.get(j) - vFencesList.get(i));
                }
            }

            hEdges.sort(Comparator.reverseOrder());
            vEdges.sort(Comparator.reverseOrder());

            for (int i = 0; i < hEdges.size(); i++) {
                for (int j = 0; j < vEdges.size() && vEdges.get(j) >= hEdges.get(i); j++) {
                    if (Objects.equals(hEdges.get(i), vEdges.get(j))) {
                        return Math.toIntExact(((long) hEdges.get(i) * hEdges.get(i)) % 1_000_000_007 );
                    }
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximizeSquareArea(3, 9, new int[]{2}, new int[]{8,6,5,4}));
    }
}
