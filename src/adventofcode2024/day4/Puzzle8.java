package adventofcode2024.day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle8 {
    private static final char[][][] patterns = new char[][][] {
            {
                    {'M', '.', 'S'},
                    {'.', 'A', '.'},
                    {'M', '.', 'S'}
            },
            {
                    {'S', '.', 'M'},
                    {'.', 'A', '.'},
                    {'S', '.', 'M'},
            },
            {
                    {'S', '.', 'S'},
                    {'.', 'A', '.'},
                    {'M', '.', 'M'},
            },
            {
                    {'M', '.', 'M'},
                    {'.', 'A', '.'},
                    {'S', '.', 'S'}
            }
    };

    public int countXmas(char[][] data) {
        int count = 0;
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data[0].length - 1; j++) {
                if (data[i][j] == 'A') {
                    if (hasAPattern(data, i - 1, j - 1)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean hasAPattern(char[][] data, int x, int y) {
        for (char[][] pattern : patterns) {
            boolean match = true;
            for (int i = 0; i < pattern.length; i++) {
                for (int j = 0; j < pattern[i].length; j++) {
                    if (!(pattern[i][j] == data[x + i][y + j] || pattern[i][j] == '.')) {
                        match = false;
                        break;
                    }
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
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
        System.out.println(new Puzzle8().countXmas(arr));
    }
}
