package adventofcode2024.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Computer {
    private final String commandsPath;
    private final List<Instruction> instructions = new ArrayList<>();

    public Computer(String commandsPath) {
        this.commandsPath = commandsPath;
    }

    public List<Instruction> readInstructions() {
        if (!instructions.isEmpty()) {
            return instructions;
        }

        String data = readData();
        Pattern pattern = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(don't\\(\\))|(do\\(\\))");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                instructions.add(new Multiply(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3))));
            } else if (matcher.group(4) != null) {
                instructions.add(new Dont());
            } else if (matcher.group(5) != null) {
                instructions.add(new Do());
            }
        }
        return instructions;
    }

    private String readData() {
        try {
            return Files.readString(Path.of(commandsPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static sealed class Instruction permits Do, Dont, Multiply {}

    public static final class Do extends Instruction {}

    public static final class Dont extends Instruction {}

    public static final class Multiply extends Instruction {
        private final Integer a, b;

        public Multiply(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        public long multiply() {
            return (long) a * b;
        }
    }
}
