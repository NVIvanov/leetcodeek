package adventofcode2024.day2;

import java.util.Collection;

public class Puzzle4 implements PuzzleReportSafety {

    @Override
    public int countSafeLevels(Collection<Report> reports) {
        int safe = 0;
        for (Report report : reports) {
            for (int i = -1; i < report.size(); i++) {
                if (new Report(report, i).isSafe()) {
                    safe++;
                    break;
                }
            }
        }
        return safe;
    }

    public static void main(String[] args) {
        Puzzle4 puzzle3 = new Puzzle4();
        System.out.println(puzzle3.countSafeLevels(Report.readReportsFromFile("puzzle3.txt")));
    }
}
