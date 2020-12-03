package fr.klock.dev.training.adventOfCode;

import org.apache.commons.lang3.StringUtils;

public class MatrixUtils {
    public static char[][] readFromPattern(String pattern) {
        String[] lines = pattern.split(StringUtils.LF);
        char[][] matrix = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {

            for (int j = 0; j < lines[i].length(); j++) {
                matrix[i][j] = lines[i].charAt(j);

            }
        }
        return matrix;
    }

    public static char[][] readFromPattern(String[] lines) {
        char[][] matrix = new char[lines.length][lines[0].length()];
        for (int i = 0; i < lines.length; i++) {

            for (int j = 0; j < lines[i].length(); j++) {
                matrix[i][j] = lines[i].charAt(j);

            }
        }
        return matrix;
    }

    public static char[][] repeatPattern(char[][] matrix, int repetition) {
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

    public static void printMatrix(char[][] matrix) {
        for (char[] line : matrix) {
            for (char aChar : line) {
                System.out.printf("%c", aChar);
            }
            System.out.println();
        }
    }

    public static char[][] copyMatrix(char[][] matrix) {
        char[][] copy = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        return copy;
    }
}
