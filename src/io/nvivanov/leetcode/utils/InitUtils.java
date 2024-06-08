package io.nvivanov.leetcode.utils;

public class InitUtils {

    public static int[][] fromSquareBrackets(String input) {
        input = input.substring(1, input.length() - 1);
        String[] rows = input.split("],\\[");
        int[][] array = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].replace("[", "").replace("]", "");
            String[] elements = row.split(",");
            array[i] = new int[elements.length];

            for (int j = 0; j < elements.length; j++) {
                array[i][j] = Integer.parseInt(elements[j].trim());
            }
        }
        return array;
    }
}
