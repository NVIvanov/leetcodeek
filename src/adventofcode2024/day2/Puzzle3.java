package adventofcode2024.day2;

import java.util.Collection;

public class Puzzle3 implements PuzzleReportSafety {

    @Override
    public int countSafeLevels(Collection<Report> reports) {
        int safe = 0;
        for (Report report : reports) {
            if (report.isSafe()) {
                safe++;
            }
        }
        return safe;
    }

    public static void main(String[] args) {
        Puzzle3 puzzle3 = new Puzzle3();
        System.out.println(puzzle3.countSafeLevels(Report.readReportsFromFile("puzzle3.txt")));
    }
}
