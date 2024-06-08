import java.util.*;

public class Graphs {

    public static void main(String[] args) {

        var neighbors = new HashMap<String, List<String>>();
        neighbors.put("you", List.of("alice", "bob", "claire"));
        neighbors.put("bob", List.of("anuj", "peggy"));
        neighbors.put("alice", List.of("peggy"));
        neighbors.put("claire", List.of("thom", "jonny"));
        neighbors.put("anuj", Collections.emptyList());
        neighbors.put("peggy", Collections.emptyList());
        neighbors.put("thom", Collections.emptyList());
        neighbors.put("jonny", Collections.emptyList());

        var searchQueue = new ArrayDeque<>(neighbors.get("you"));
        var searched = new HashSet<String>();
        while (!searchQueue.isEmpty()) {
            var person = searchQueue.pop();
            if (!searched.contains(person)) {
                if (isMangoSeller(person)) {
                    System.out.println(person);
                } else {
                    searchQueue.addAll(neighbors.get(person));
                    searched.add(person);
                }
            }
        }
    }

    public static boolean isMangoSeller(String person) {
        return person.endsWith("m");
    }
}
