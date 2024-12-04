package adventofcode2024.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle5 {

    private String readData() {
        try {
            return Files.readString(Path.of("puzzle5.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long findSumOfMultiplications() {
        String data = readData();
        Pattern pattern = Pattern.compile("(mul\\((\\d+),(\\d+)\\))");
        Matcher matcher = pattern.matcher(data);
        long result = 0;
        while (matcher.find()) {
            result += Long.parseLong(matcher.group(2)) * Long.parseLong(matcher.group(3));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Puzzle5().findSumOfMultiplications());
    }
}
