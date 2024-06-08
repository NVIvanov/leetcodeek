import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

public class NumberofStudentsUnabletoEatLunch {

    public static int countStudents(int[] students, int[] sandwiches) {
        BitSet bs = new BitSet(students.length);
        int sandwichIndex = 0;
        int studentIndex = 0;
        int notGiven = 0;
        do {
            if (bs.get(studentIndex)) {
                studentIndex = (studentIndex + 1) % students.length;
                continue;
            }
            if (students[studentIndex] == sandwiches[sandwichIndex]) {
                bs.set(studentIndex);
                sandwichIndex++;
                notGiven = 0;
            } else {
                notGiven++;
            }
            studentIndex = (studentIndex + 1) % students.length;
        } while (sandwichIndex < sandwiches.length && notGiven < (students.length - bs.cardinality()));
        return students.length - bs.cardinality();
    }

    public static void main(String[] args) {
        System.out.println(
                countStudents(
                        new int[]{1,1,1,0,0,1},
                        new int[]{1,0,0,0,1,1}
                )
        );

        /*
        1,1,1,0,0,1
        1,0,0,0,1,1

        1-t
        2-l
        3-l
        4-t
        5-t
        6-l

         */
    }
}
