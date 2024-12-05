package adventofcode2024.day4;

import adventofcode2024.day3.Puzzle5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle7 {
    private static final String XMAS = "XMAS";

    public int countXmas(char[][] data) {
        int count = 0;
        boolean [][] visited = new boolean[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 'X') {
                    if (j < data[0].length - 3) {
                        if (data[i][j + 1] == 'M' &&
                            data[i][j + 2] == 'A' &&
                                data[i][j + 3] == 'S') {
                            visited[i][j] = true;
                            visited[i][j + 1] = true;
                            visited[i][j + 2] = true;
                            visited[i][j + 3] = true;
                            count++;
                        }

                        if (i < data.length - 3) {
                            if (data[i + 1][j + 1] == 'M' && data[i + 2][j + 2] == 'A' && data[i + 3][j + 3] == 'S') {
                                visited[i][j] = true;
                                visited[i + 1][j + 1] = true;
                                visited[i + 2][j + 2] = true;
                                visited[i + 3][j + 3] = true;
                                count++;
                            }
                        }

                        if (i >= 3) {
                            if (data[i - 1][j + 1] == 'M' && data[i - 2][j + 2] == 'A' && data[i - 3][j + 3] == 'S') {
                                visited[i][j] = true;
                                visited[i - 1][j + 1] = true;
                                visited[i - 2][j + 2] = true;
                                visited[i - 3][j + 3] = true;
                                count++;
                            }
                        }
                    }

                    if (i < data.length - 3) {
                        if (data[i + 1][j] == 'M' && data[i + 2][j] == 'A' && data[i + 3][j] == 'S') {
                            visited[i][j] = true;
                            visited[i + 1][j] = true;
                            visited[i + 2][j] = true;
                            visited[i + 3][j] = true;
                            count++;
                        }
                    }

                    if (i >= 3) {
                        if (data[i - 1][j] == 'M' && data[i - 2][j] == 'A' && data[i - 3][j] == 'S') {
                            visited[i][j] = true;
                            visited[i - 1][j] = true;
                            visited[i - 2][j] = true;
                            visited[i - 3][j] = true;
                            count++;
                        }
                    }

                    if (j >= 3) {
                        if (data[i][j - 1] == 'M' &&
                                data[i][j - 2] == 'A' &&
                                data[i][j - 3] == 'S') {
                            visited[i][j] = true;
                            visited[i][j - 1] = true;
                            visited[i][j - 2] = true;
                            visited[i][j - 3] = true;
                            count++;
                        }

                        if (i < data.length - 3) {
                            if (data[i + 1][j - 1] == 'M' && data[i + 2][j - 2] == 'A' && data[i + 3][j - 3] == 'S') {
                                visited[i][j] = true;
                                visited[i + 1][j - 1] = true;
                                visited[i + 2][j - 2] = true;
                                visited[i + 3][j - 3] = true;
                                count++;
                            }
                        }

                        if (i >= 3) {
                            if (data[i - 1][j - 1] == 'M' && data[i - 2][j - 2] == 'A' && data[i - 3][j - 3] == 'S') {
                                visited[i][j] = true;
                                visited[i - 1][j - 1] = true;
                                visited[i - 2][j - 2] = true;
                                visited[i - 3][j - 3] = true;
                                count++;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (!visited[i][j]) {
                    data[i][j] = '.';
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        try (Scanner in = new Scanner(new FileInputStream("puzzle7.txt"))) {
            while (in.hasNextLine()) {
                strings.add(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        char[][] arr = new char[strings.size()][];
        for (int i = 0; i < strings.size(); i++) {
            arr[i] = strings.get(i).toCharArray();
        }
        System.out.println(new Puzzle7().countXmas(arr));

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
