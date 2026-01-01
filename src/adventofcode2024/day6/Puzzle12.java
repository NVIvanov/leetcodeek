package adventofcode2024.day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Puzzle12 {

    static final int[][] directions = {
            {-1, 0}, // up
            {0, 1}, // right
            {1, 0}, // down
            {0, -1} // left
    };

    static final int[] UP = directions[0];
    static final int[] RIGHT = directions[1];
    static final int[] DOWN = directions[2];
    static final int[] LEFT = directions[3];


    static Map<Integer, List<Integer[]>> up = new HashMap<>();
    static Map<Integer, List<Integer[]>> down = new HashMap<>();
    static Map<Integer, List<Integer[]>> left = new HashMap<>();
    static Map<Integer, List<Integer[]>> right = new HashMap<>();

    private int directionNum = 0;

    private void turnRight() {
        directionNum = (directionNum + 1) % directions.length;
    }

    private int[] nextWithoutTurn() {
        return directions[(directionNum + 1) % directions.length];
    }

    private int[] prevWithoutTurn() {
        int next = directionNum - 1;
        if (next == -1) {
            next = directions.length - 1;
        }
        return directions[next];
    }

    private int[] direction() {
        return directions[directionNum];
    }

    private boolean crossLine(int[] position) {
        List<Integer[]> intervals;
        int variable;
        if (direction() == UP) {
            intervals = right.get(position[0]);
            variable = position[1];
        } else if (direction() == RIGHT) {
            intervals = down.get(position[1]);
            variable = position[0];
        } else if (direction() == DOWN) {
            intervals = left.get(position[0]);
            variable = position[1];
        } else if (direction() == LEFT) {
            intervals = up.get(position[1]);
            variable = position[0];
        } else {
            return false;
        }
        if (intervals == null) {
            return false;
        }
        return intervals.stream().anyMatch(interval -> interval[0] <= variable && variable <= interval[1]);
    }

    private void addInterval(boolean[][] field, int[] position) {
        addInterval(field, position, direction());
    }

    private void addInterval(boolean[][] field, int[] position, int[] direction) {
        int[] pos = position.clone();
        List<Integer[]> intervals;
        if (direction == UP) {
            intervals = up.computeIfAbsent(pos[1], k -> new ArrayList<>());
        } else if (direction == RIGHT) {
            intervals = right.computeIfAbsent(pos[0], k -> new ArrayList<>());
        } else if (direction == DOWN) {
            intervals = down.computeIfAbsent(pos[1], k -> new ArrayList<>());
        } else if (direction == LEFT) {
            intervals = left.computeIfAbsent(pos[0], k -> new ArrayList<>());
        } else {
            return;
        }
        while (canMoveForward(field, pos, direction)) {
            moveForward(pos, direction);
        }
        int[] one = pos.clone();
        while (canMoveBackward(field, pos, direction)) {
            moveBackward(pos, direction);
        }
        int[] two = pos.clone();
        if (direction == UP) {
            intervals.add(new Integer[]{one[0], two[0]});
        } else if (direction == RIGHT) {
            intervals.add(new Integer[]{two[1], one[1]});
        } else if (direction == DOWN) {
            intervals.add(new Integer[]{two[0], one[0]});
        } else if (direction == LEFT) {
            intervals.add(new Integer[]{one[1], two[1]});
        }
    }

    private boolean canMoveForward(boolean[][] field, int[] position) {
        return canMoveForward(field, position, direction());
    }

    private boolean canMoveForward(boolean[][] field, int[] position, int[] direction) {
        if (position[0] + direction[0] < 0 || position[0] + direction[0] >= field.length || position[1] + direction[1] < 0 || position[1] + direction[1] >= field[0].length) {
            return false;
        }
        return field[position[0] + direction[0]][position[1] + direction[1]];
    }

    private boolean canMoveBackward(boolean[][] field, int[] position) {
        return canMoveBackward(field, position, direction());
    }

    private boolean canMoveBackward(boolean[][] field, int[] position, int[] direction) {
        if (position[0] - direction[0] < 0 || position[0] - direction[0] >= field.length || position[1] - direction[1] < 0 || position[1] - direction[1] >= field[0].length) {
            return false;
        }
        return field[position[0] - direction[0]][position[1] - direction[1]];
    }

    private void moveForward(int[] position) {
        moveForward(position, direction());
    }

    private void moveForward(int[] position, int[] direction) {
        position[0] += direction[0];
        position[1] += direction[1];
    }

    private void moveBackward(int[] position) {
        moveBackward(position, direction());
    }

    private void moveBackward(int[] position, int[] direction) {
        position[0] -= direction[0];
        position[1] -= direction[1];
    }

    private boolean canTurn(boolean[][] field, int[] position) {
        int[] dir = nextWithoutTurn();
        return field[position[0] + dir[0]][position[1] + dir[1]];
    }

    private boolean hasObstacleOnLeft(boolean[][] field, int[] position) {
        int[] dir = prevWithoutTurn();
        return field[position[0] + dir[0]][position[1] + dir[1]];
    }

    private boolean left(boolean[][] field, int[] position) {
        return position[0] == 0 || position[0] == field.length - 1 || position[1] == 0 || position[1] == field[0].length - 1;
    }

    public int trackGuard(boolean[][] field, int x, int y) {
        boolean[][] visited = new boolean[field.length][field[0].length];
        boolean[][] obstacles = new boolean[field.length][field[0].length];
        int[] position = new int[]{x, y};
        visited[position[0]][position[1]] = true;
        int newObstacles = 0;
        addInterval(field, position);
        while (canMoveForward(field, position) || canTurn(field, position)) {
            while (canMoveForward(field, position)) {
                moveForward(position);
                if (hasObstacleOnLeft(field, position)) {
                    addInterval(field, position, prevWithoutTurn());
                }
                if (crossLine(position)) {
//                    System.out.println(up);
//                    System.out.println(right);
//                    System.out.println(down);
//                    System.out.println(left);
//
//                    System.out.println(Arrays.toString(position) + " - " + Arrays.toString(direction()));
                    newObstacles++;
                    obstacles[position[0] + direction()[0]][position[1] + direction()[1]] = true;
                }
                if (left(field, position)) {

                    for (int i = 0; i < field.length; i++) {
                        for (int j = 0; j < field[0].length; j++) {
                            if (i == x && j == y) {
                                System.out.print("^");
                            } else if (obstacles[i][j]) {
                                System.out.print("O");
                            } else if (visited[i][j]) {
                                System.out.print("+");
                            } else if (field[i][j]) {
                                System.out.print(".");
                            } else {
                                System.out.print("#");
                            }
                        }
                        System.out.println();
                    }

                    return newObstacles;
                }
                if (!visited[position[0]][position[1]]) {
                    visited[position[0]][position[1]] = true;
                }
            }
            if (canTurn(field, position)) {
                turnRight();
                addInterval(field, position);
                moveForward(position);
                if (hasObstacleOnLeft(field, position)) {
                    addInterval(field, position, prevWithoutTurn());
                }
                if (crossLine(position)) {
//                    System.out.println(up);
//                    System.out.println(right);
//                    System.out.println(down);
//                    System.out.println(left);
//                    System.out.println(Arrays.toString(position) + " - " + Arrays.toString(direction()));
                    newObstacles++;
                    obstacles[position[0] + direction()[0]][position[1] + direction()[1]] = true;
                }
                if (left(field, position)) {

                    for (int i = 0; i < field.length; i++) {
                        for (int j = 0; j < field[0].length; j++) {
                            if (i == x && j == y) {
                                System.out.print("^");
                            } else if (obstacles[i][j]) {
                                System.out.print("O");
                            } else if (visited[i][j]) {
                                System.out.print("+");
                            } else if (field[i][j]) {
                                System.out.print(".");
                            } else {
                                System.out.print("#");
                            }
                        }
                        System.out.println();
                    }

                    return newObstacles;
                }
                if (!visited[position[0]][position[1]]) {
                    visited[position[0]][position[1]] = true;
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (i == x && j == y) {
                    System.out.print("^");
                } else if (obstacles[i][j]) {
                    System.out.print("O");
                } else if (visited[i][j]) {
                    System.out.print("+");
                } else if (field[i][j]) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }

        return newObstacles;
    }


    public static void main(String[] args) throws FileNotFoundException {
        List<List<Boolean>> fieldList = new ArrayList<>();
        int x = -1, y = -1;
        try (var scanner = new Scanner(new FileInputStream("puzzle11.txt"))) {
            while (scanner.hasNextLine()) {
                fieldList.add(new ArrayList<>());
                String line = scanner.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    fieldList.getLast().add(line.charAt(i) != '#');
                    if (line.charAt(i) == '^') {
                        x = fieldList.size();
                        y = i + 1;
                    }
                }
            }
        }
        boolean[][] field = new boolean[fieldList.size() + 2][fieldList.get(0).size() + 2];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] = true;
            }
        }

        for (int i = 1; i < field.length - 1; i++) {
            for (int j = 1; j < field[i].length - 1; j++) {
                field[i][j] = fieldList.get(i - 1).get(j - 1);
            }
        }
        System.out.println(new Puzzle12().trackGuard(field, x, y));
    }
}
