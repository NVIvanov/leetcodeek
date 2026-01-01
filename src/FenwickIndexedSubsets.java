import java.util.*;

public class FenwickIndexedSubsets<E> {

    private ArrayList<LinkedHashSet<E>> bit = new ArrayList<>();
    private final TreeMap<Integer, Integer> valueToRank = new TreeMap<>();
    private final ArrayList<Integer> rankToValue = new ArrayList<>();
    private final Map<E, Integer> indexOf = new HashMap<>();

    public FenwickIndexedSubsets() {
        bit.add(null); // 0th unused
    }

    public boolean add(E element, int index) {
        Objects.requireNonNull(element, "element");
        Integer oldIdx = indexOf.get(element);
        if (Objects.equals(oldIdx, index)) return false;

        boolean indexWasNew = ensureIndexAvailable(index);

        if (oldIdx != null) {
            int oldRank = valueToRank.get(oldIdx);
            fenwickRemove(oldRank, element);
        }

        // If we expanded indices, the tree has just been rebuilt, so we must re-add everything anyway;
        // but we still need to add this new/updated element:
        int rank = valueToRank.get(index);
        fenwickAdd(rank, element);
        indexOf.put(element, index);

        return true;
    }

    public boolean remove(E element) {
        Integer idx = indexOf.remove(element);
        if (idx == null) return false;
        int rank = valueToRank.get(idx);
        fenwickRemove(rank, element);
        return true;
    }

    public Set<E> getSubset(int k) {
        Map.Entry<Integer, Integer> floor = valueToRank.floorEntry(k);
        if (floor == null) return Collections.emptySet();
        int rank = floor.getValue();
        LinkedHashSet<E> res = new LinkedHashSet<>();
        for (int i = rank; i > 0; i -= (i & -i)) {
            res.addAll(bit.get(i));
        }
        return Collections.unmodifiableSet(res);
    }

    public boolean contains(E e) { return indexOf.containsKey(e); }
    public Optional<Integer> getIndex(E e) { return Optional.ofNullable(indexOf.get(e)); }
    public int size() { return indexOf.size(); }

    public void clear() {
        for (int i = 1; i < bit.size(); i++) bit.get(i).clear();
        valueToRank.clear();
        rankToValue.clear();
        indexOf.clear();
        bit.clear();
        bit.add(null);
    }

    /* ================= internals ================= */

    // Ensure index exists; if it’s new (either middle or new max), rebuild the Fenwick tree.
    private boolean ensureIndexAvailable(int index) {
        if (valueToRank.containsKey(index)) return false;

        valueToRank.put(index, -1); // mark so it's included during rebuild
        rebuildCompressionAndFenwick();
        return true;
    }

    private void ensureBitCapacity(int ranks) {
        bit.clear();
        bit.add(null);
        for (int i = 1; i <= ranks; i++) bit.add(new LinkedHashSet<>());
    }

    private void fenwickAdd(int rank, E e) {
        for (int i = rank; i < bit.size(); i += (i & -i)) bit.get(i).add(e);
    }

    private void fenwickRemove(int rank, E e) {
        for (int i = rank; i < bit.size(); i += (i & -i)) bit.get(i).remove(e);
    }

    // Recompute ranks and rebuild the BIT, re-inserting all existing elements.
    private void rebuildCompressionAndFenwick() {
        ArrayList<Integer> sorted = new ArrayList<>(valueToRank.keySet());
        Collections.sort(sorted);
        valueToRank.clear();
        rankToValue.clear();
        int r = 1;
        for (int v : sorted) {
            valueToRank.put(v, r++);
            rankToValue.add(v);
        }
        ensureBitCapacity(rankToValue.size());

        // reinsert everything currently stored
        for (Map.Entry<E, Integer> e : indexOf.entrySet()) {
            int rank = valueToRank.get(e.getValue());
            fenwickAdd(rank, e.getKey());
        }
    }

    public OptionalInt leastSubsetIndex(E element) {
        Integer idx = indexOf.get(element);
        return (idx == null) ? OptionalInt.empty() : OptionalInt.of(idx);
    }

    /* =============== demo =============== */
    public static void main(String[] args) {
        FenwickIndexedSubsets<Integer> s = new FenwickIndexedSubsets<>();
        s.add(1, 1);
        s.add(2, 1);
        s.add(3, 2);
        s.add(4, 3);

        System.out.println(s.getSubset(1)); // [1, 2]
        System.out.println(s.getSubset(2)); // [1, 2, 3]
        System.out.println(s.getSubset(3)); // [1, 2, 3, 4]

        s.add(2, 3);                         // move
        System.out.println(s.getSubset(1)); // [1]
        System.out.println(s.getSubset(3)); // [1, 3, 4, 2] (order may vary)

        s.add(5, 2);                         // introduces index 2 if not present -> rebuild
        System.out.println(s.getSubset(2)); // [1, 3, 5]
        s.remove(3);
        System.out.println(s.getSubset(3)); // [1, 4, 2, 5]
    }
}
