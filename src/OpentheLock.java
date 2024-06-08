import java.util.*;

public class OpentheLock {

    public static int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Collections.addAll(visited, deadends);
        if (visited.contains("0000")) {
            return -1;
        }
        visited.add("0000");
        Set<String> nextCandidates = new HashSet<>();
        nextCandidates.add("0000");
        int steps = 0;
        while (!visited.contains(target)) {
            nextCandidates = nextWheels(nextCandidates, visited);
            if (nextCandidates.isEmpty()) {
                return -1;
            }
            visited.addAll(nextCandidates);
            steps++;
        }
        return steps;
    }

    private static Set<String> nextWheels(Set<String> currentWheels, Set<String> visited) {
        Set<String> nextCodes = new HashSet<>();

        for (String currentWheel : currentWheels) {
            for (int i = 0; i < currentWheel.length(); i++) {
                char[] codeArray = currentWheel.toCharArray();

                // Increment the digit at index i
                codeArray[i] = incrementDigit(codeArray[i]);
                if (!visited.contains(String.valueOf(codeArray))) {
                    nextCodes.add(String.valueOf(codeArray));
                }

                // Decrement the digit at index i
                codeArray[i] = decrementDigit(decrementDigit(codeArray[i]));
                if (!visited.contains(String.valueOf(codeArray))) {
                    nextCodes.add(String.valueOf(codeArray));
                }
            }
        }

        return nextCodes;
    }

    private static char incrementDigit(char digit) {
        if (digit == '9') {
            return '0';
        } else {
            return (char)(digit + 1);
        }
    }

    private static char decrementDigit(char digit) {
        if (digit == '0') {
            return '9';
        } else {
            return (char)(digit - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}
