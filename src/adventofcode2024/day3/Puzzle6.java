package adventofcode2024.day3;

public class Puzzle6 {

    public long findSumOfMultiplications() {
        Computer computer = new Computer("puzzle5.txt");
        long result = 0;
        boolean enabled = true;
        for (var instruction: computer.readInstructions()) {
            switch (instruction) {
                case Computer.Do ignored:
                    enabled = true;
                    break;
                case Computer.Dont ignored:
                    enabled = false;
                    break;
                case Computer.Multiply multiply:
                    if (enabled) {
                        result += multiply.multiply();
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + instruction);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Puzzle6().findSumOfMultiplications());
    }
}
