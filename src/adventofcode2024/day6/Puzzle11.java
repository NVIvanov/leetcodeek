package adventofcode2024.day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle11 {

    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int directionNum = 0;

    private void turnRight() {
        directionNum = (directionNum + 1) % directions.length;
    }

    private int[] nextWithoutTurn() {
        return directions[(directionNum + 1) % directions.length];
    }

    private int[] direction() {
        return directions[directionNum];
    }

    private boolean canMoveForward(boolean[][] field, int[] position) {
        return field[position[0] + direction()[0]][position[1] + direction()[1]];
    }

    private void moveForward(int[] position) {
        position[0] += direction()[0];
        position[1] += direction()[1];
    }

    private boolean canTurn(boolean[][] field, int[] position) {
        int[] dir = nextWithoutTurn();
        return field[position[0] + dir[0]][position[1] + dir[1]];
    }

    private boolean left(boolean[][] field, int[] position) {
        return position[0] == 0 || position[0] == field.length - 1 || position[1] == 0 || position[1] == field[0].length - 1;
    }

    public int trackGuard(boolean[][] field, int x, int y) {
        boolean[][] visited = new boolean[field.length][field[0].length];
        int[] position = new int[]{x, y};
        visited[position[0]][position[1]] = true;
        int trace = 1; //initial position is counted
        while (canMoveForward(field, position) || canTurn(field, position)) {
            while (canMoveForward(field, position)) {
                moveForward(position);
                if (left(field, position)) {
                    for (int i = 0; i < field.length; i++) {
                        for (int j = 0; j < field[0].length; j++) {
                            if (i == x && j == y) {
                                System.out.print("^");
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
                    return trace;
                }
                if (!visited[position[0]][position[1]]) {
                    trace++;
                    visited[position[0]][position[1]] = true;
                }
            }
            if (canTurn(field, position)) {
                turnRight();
                moveForward(position);
                if (left(field, position)) {
                    for (int i = 0; i < field.length; i++) {
                        for (int j = 0; j < field[0].length; j++) {
                            if (i == x && j == y) {
                                System.out.print("^");
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
                    return trace;
                }
                if (!visited[position[0]][position[1]]) {
                    trace++;
                    visited[position[0]][position[1]] = true;
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (i == x && j == y) {
                    System.out.print("^");
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

        return trace;
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
        System.out.println(new Puzzle11().trackGuard(field, x, y));
    }
}
