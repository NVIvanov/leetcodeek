package adventofcode2024.day2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Report {
    private final List<Integer> values;

    public Report(List<Integer> reportValues) {
        values = reportValues;
    }

    public Report(Report report, int tolerateIndex) {
        values = new ArrayList<>();
        for (int i = 0; i < report.values.size(); i++) {
            if (i == tolerateIndex) {
                continue;
            }
            values.add(report.values.get(i));
        }
    }

    public int size() {
        return values.size();
    }

    public boolean isSafe() {
        boolean allIncreasing = true;
        boolean allDecreasing = true;
        boolean graduals = true;
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) < values.get(i + 1)) {
                allDecreasing = false;
                int diff = values.get(i + 1) - values.get(i);
                if (diff > 3) {
                    graduals = false;
                    break;
                }
            } else if (values.get(i) > values.get(i + 1)) {
                allIncreasing = false;
                int diff = values.get(i) - values.get(i + 1);
                if (diff > 3) {
                    graduals = false;
                    break;
                }
            } else {
                graduals = false;
            }
        }
        return (allIncreasing || allDecreasing) && graduals;
    }

    public static List<Report> readReportsFromFile(String filename) {
        List<Report> reports = new ArrayList<>();
        try(Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                List<Integer> list = new ArrayList<>(Stream.of(s.split("\\s+")).map(Integer::parseInt).toList());
                reports.add(new Report(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reports;
    }
}
