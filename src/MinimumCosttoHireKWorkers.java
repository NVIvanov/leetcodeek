import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCosttoHireKWorkers {


    /*
        10 20 5
        70 50 30


        20 5   10
        50 30  70
        k = 2

        20 5, 5 10

        minsum = Math.min(sum / prevmult * newmult)

        10 5

        3,1,10,10,1
        4,8,2,2,7


       10 10 3 1 1
       2  2  4 7 8



     */


    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        //проход по массиву и сбор индексов по правилу от меньшего соотношения wage/quality к большему
        Queue<Integer> indices = new PriorityQueue<>(Comparator.comparingDouble(i -> (double)wage[i]/(double)quality[i]));
        for (int i = 0; i < quality.length; i++) {
            indices.add(i);
        }
        Queue<Integer> queue = new PriorityQueue<>(indices);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            System.out.println(index + " - " + (double) wage[index]/(double)quality[index]);
        }
        int sumQ = 0;
        int index = 0;
        Queue<Integer> indx = new PriorityQueue<>(Comparator.<Integer>comparingDouble(i -> quality[i]).reversed());
        for (int i = 0; i < k; i++) {
            index = indices.poll();
            sumQ += quality[index];
            indx.add(index);
        }
        double wq = (double) wage[index] / quality[index];
        double minSum = sumQ * wq;
        while (!indices.isEmpty()) {
            int newIndex = indices.poll();
            int prevIndex = indx.poll();
            double newWQ = (double) wage[newIndex] / quality[newIndex];
            sumQ = sumQ - quality[prevIndex] + quality[newIndex];
            minSum = Math.min(minSum, sumQ * newWQ);
            indx.add(newIndex);
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[]{
                25,68,35,62,52,57,35,83,40,51
        }, new int[]{
                147,97,251,129,438,443,120,366,362,343
        }, 6));
    }
}
