package fr.klock.dev.training.adventOfCode.year2020.day3;

import org.apache.commons.lang3.StringUtils;

public class Toboggan {

    public char[][] readFromPattern(String pattern) {
        String[] lines = pattern.split(StringUtils.LF);
        char[][] matrix = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {

            for (int j = 0; j < lines[i].length(); j++) {
                matrix[i][j] = lines[i].charAt(j);

            }
        }
        return matrix;
    }

    public char[][] repeat(char[][] matrix, int repetition) {
        char[][] repeatedMatrix = new char[matrix.length][matrix[0].length * (repetition + 1)];

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 1; k <= repetition; k++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    repeatedMatrix[i][j] = matrix[i][j];
                    repeatedMatrix[i][k * matrix[i].length + j] = matrix[i][j];
                }
            }
        }

        return repeatedMatrix;
    }
}
