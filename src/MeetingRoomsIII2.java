import java.util.*;

public class MeetingRoomsIII2 {

    /*
        заводим отображение roomStat второе номера комнат с количеством проведенных митингов
        remainingTime - множество массивов из двух элементов, отсортированных по первому значения массива или если они равны, то по второму тоже
        первое значение - сколько времени осталось, второе - номер комнаты.
        ?также храним номер комнаты, в которой последний раз провели митинг. i
        также храним текущий момент времени t
        берем новый митинг
        если t < чем время начала, устанавливаем в remainingTime в первое значение Math.max(0, value - (время начала - time)), t выставляем во время начала
        ищем первую свободную комнату. Если комната нашлась, то записываем в remaining time комнаты значение из митинга (end - start), прибавляем 1 к значению отображения проведенных митингов
        Если комната не нашлась, то берем минимальное значение из remainingTimeSet, для remainingTimeSet убавляем время на минимальное значение, прибавляем его к t;
        Из remainingTime берем комнаты с 0 значением, берем первую по индексу. Отправляем митинг в эту комнату.
     */
    public static int mostBooked(int n, int[][] meetings) {

        Queue<Integer[]> meetingsQ = new PriorityQueue<>(Comparator.comparingInt((Integer[] o)-> o[0]));
        for (var m: meetings) {
            meetingsQ.add(new Integer[]{m[0], m[1]});
        }

        NavigableSet<Long[]> remainingTimeSet = new TreeSet<>(Comparator
                .comparingLong((Long[] o) -> -o[0])
                .thenComparingLong(o -> o[1])
        );

        Queue<Long> ends = new PriorityQueue<>();

        Map<Integer, Integer> roomStat = new HashMap<>();

        for (int i = 0; i < n; i++) {
            remainingTimeSet.add(new Long[]{0L, (long) i});
            roomStat.put(i, 0);
            ends.add(0L);
        }

        int size = meetingsQ.size();
        for (int i = 0; i < size; i++) {
            var m = meetingsQ.poll();
            long start = Math.max(m[0], ends.poll()), end = (m[1] - m[0]) + start;

            SortedSet<Long[]> releasedRooms = remainingTimeSet.tailSet(new Long[]{start, 0L}, true);
            Long[] room = releasedRooms.first();
            for (var r: releasedRooms) {
                if (r[1] < room[1]) {
                    room = r;
                }
            }
            remainingTimeSet.remove(room);
            room[0] = end;
            remainingTimeSet.add(room);
            ends.add(end);
            roomStat.replace(room[1].intValue(), roomStat.get(room[1].intValue()) + 1);
        }

        SortedSet<Integer> roomsFinalMeetings = new TreeSet<>();
        int max = roomStat.values().stream().mapToInt(x -> x).max().orElse(0);

        for (var room: roomStat.entrySet()) {
            if (room.getValue() == max) {
                roomsFinalMeetings.add(room.getKey());
            }
        }

        return roomsFinalMeetings.first();
    }

    private static void printRemaining(SortedSet<Integer[]> rooms) {
        for(var room: rooms) {
            System.out.println(Arrays.toString(room));
        }
    }

    public static void main(String[] args) {
        //0 -> 500000, 98->499902, 99, 100, ..., 199900
        List<Integer[]> init = new ArrayList<>();
        for (int i = 1; i <= 80000; i++) {
            init.add(new Integer[]{i, 300000 + i});
        }

        init.add(new Integer[]{80001,300000});
        init.add(new Integer[]{80002,80003});
        init.add(new Integer[]{80003,80004});
        init.add(new Integer[]{80004,80005});
        init.add(new Integer[]{80005,80006});
        init.add(new Integer[]{80006,80007});
        init.add(new Integer[]{80007,80008});
        init.add(new Integer[]{80008,80009});
        init.add(new Integer[]{80009,80010});
        init.add(new Integer[]{80010,80011});
        init.add(new Integer[]{80011,80012});


//        for (int i = 99; i < 1999000; i+=2) {
//            init.add(new Integer[]{i, i+1});
//        }

        int[][] arr = new int[init.size()][2];
        for (int i = 0; i < init.size(); i++) {
            arr[i] = new int[] {init.get(i)[0], init.get(i)[1]};
        }

        System.out.println(mostBooked(10, arr));
////
//        System.out.println(mostBooked(4, new int[][]{
//                {2,13}, // в 0
//                {3,12}, // в 1
//                {7,10}, // в 2
//                {17,19}, // в 0
//                {18,19}, // в 1
//        }));
//
//        System.out.println(mostBooked(2, new int[][]{
//                {0,10}, // в 0
//                {1,5}, // в 1
//                {2,7}, // в 1
//                {3,4}, // в 0
//        }));
//
//        System.out.println(mostBooked(3, new int[][]{
//                {1,20}, // в 0
//                {2,10}, // в 1
//                {3,5}, // в 2
//                {4,9}, // в 2
//                {6,8}, // в 1
//        }));

                /*
               1, 20

               0, 20
               1, 0
               2, 0
               текущее время 1

               2, 10

               0, 20
               1, 10,
               2, 0
               текущее время 2

               3, 5

               0, 20
               1, 10
               2, 5
               текущее время 3

               4, 9

               0, 20
               1, 10
               2, 10
               текущее время 5

               6, 8

               0, 20
               1, 12
               2, 10
               текущее время 10

         */

//        18,19],[3,12],[17,19],[2,13],[7,10
//
//        System.out.println(mostBooked(4, new int[][] {
//                {2, 13}, // 0
//                {3, 12}, // 1
//                {7, 10}, // 2
//                {17, 19}, // 0
//                {18, 19} // 1
//        }));
        /*
            2, 13

            0, 13
            1, 0
            2, 0
            3, 0

            3, 12

            0, 13
            1, 12
            2, 0
            3, 0

            7, 10

            0, 13
            1, 12,
            2, 10
            3, 0

            17, 19


            0, 19
            1, 12
            2, 10
            3, 0

            18, 19

            0, 19
            1, 19
            2, 10
            3, 0

         */


//        System.out.println(mostBooked(5, new int[][]{
//                {3,12}, // в 0
//                {6,13}, // в 1
//                {10,14}, // в 2
//                {13,17}, // в 0
//        }));
    }
}
