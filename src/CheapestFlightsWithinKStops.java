import java.util.*;

public class CheapestFlightsWithinKStops {


    /**
     *
     *
     *
     *
     * @param n number of cities
     * @param flights possible flights and costs
     * @param src from city
     * @param dst to city
     * @param k at most k stops
     * @return cheapest price if there is a route, -1 otherwise.
     */
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> parents = new HashMap<>();
        for (var edge: flights) {
            graph.putIfAbsent(edge[0], new HashMap<>());
            graph.get(edge[0]).put(edge[1], edge[2]);
            parents.putIfAbsent(edge[1], new ArrayList<>());
            parents.get(edge[1]).add(edge[0]);
        }
        return findCheapestPrice(
                graph,
                parents,
                src,
                dst,
                k,
                new HashMap<>()
        );
    }

    public static int findCheapestPrice(Map<Integer, Map<Integer, Integer>> graph,
                                        Map<Integer, List<Integer>> parents,
                                        int src, int dst, int k, Map<Integer, Map<Integer, Map<Integer, Integer>>>
                                        calculatedFlights) {
        if (calculatedFlights.get(src) != null &&
            calculatedFlights.get(src).get(dst) != null &&
            calculatedFlights.get(src).get(dst).get(k) != null) {
            return calculatedFlights.get(src).get(dst).get(k);
        }
        if (dst == src) {
            return 0;
        }
        if (k == 0) {
            return graph.getOrDefault(src, new HashMap<>()).getOrDefault(dst, -1);
        }
        var minPath = parents.getOrDefault(dst, Collections.emptyList())
                .stream().map(parent -> {
                    int prevPath = findCheapestPrice(graph, parents, src, parent, k - 1, calculatedFlights);
                    if (prevPath == -1) {
                        return -1;
                    }
                    int fromParentToDst = graph.get(parent).get(dst);
                    return prevPath + fromParentToDst;
                })
                .mapToInt(x -> x)
                .filter(x -> x > 0)
                .min().orElse(-1);
        calculatedFlights.putIfAbsent(src, new HashMap<>());
        calculatedFlights.get(src).putIfAbsent(dst, new HashMap<>());
        calculatedFlights.get(src).get(dst).put(k, minPath);
        return minPath;
    }

    public static void main(String[] args) {
//        System.out.println(findCheapestPrice(4, new int[][]{
//                {0,1,100},
//                {1,2,100},
//                {2,0,100},
//                {1,3,600},
//                {2,3,200}
//        },
//                0,3,1));
//
//        System.out.println(findCheapestPrice(3, new int[][]{
//                        {0,1,100},
//                        {1,2,100},
//                        {0,2,500}
//                },
//                0,2,1));
//
//        System.out.println(findCheapestPrice(5, new int[][]{
//                        {4,1,1},
//                        {1,2,3},
//                        {0,3,2},
//                        {0,4,10},
//                        {3,1,1},
//                        {1,4,3}
//                },
//                2,1,1));

        System.out.println(findCheapestPrice(3, new int[][]{
                        {0,1,2},
                        {1,2,1},
                        {2,0,10}
                },
                1,2,1));

        /*
                       0
                <2>
           1          <10>
                <1>
                       2
         */
    }
}
