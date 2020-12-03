package fr.klock.dev.training.adventOfCode.year2020.day3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Advent Of Code 2020 - Day 3")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TobogganTest {

    private final static String PATTERN =
            "..##.......\n" +
            "#...#...#..\n" +
            ".#....#..#.\n" +
            "..#.#...#.#\n" +
            ".#...##..#.\n" +
            "..#.##.....\n" +
            ".#.#.#....#\n" +
            ".#........#\n" +
            "#.##...#...\n" +
            "#...##....#\n" +
            ".#..#...#.#";

    @Test
    @DisplayName("Extract area pattern to matrix")
    void readPatternToMatrix() {
        char[][] matrix = new Toboggan().readFromPattern(PATTERN);

        char[][] expectedPattern = new char[][]{
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
        };
        assertThat(matrix.length).isEqualTo(expectedPattern.length);
        for (int i = 0; i < matrix.length; i++) {
            assertThat(matrix[i].length).isEqualTo(expectedPattern[i].length);
            for (int j = 0; j < matrix[i].length; j++) {
                assertThat(matrix[i][j]).isEqualTo(expectedPattern[i][j]);
            }
        }
    }

    @Test
    @DisplayName("Repeat area to the right 1 time")
    void repeatPatternToTheRight1Time() {
        Toboggan toboggan = new Toboggan();
        char[][] matrix = toboggan.readFromPattern(PATTERN);

        int repetition = 1;
        char[][] repeatedMatrix = toboggan.repeat(matrix, repetition);

        char[][] expectedPattern = new char[][]{
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
        };
        assertThat(repeatedMatrix.length).isEqualTo(expectedPattern.length);
        for (int i = 0; i < repeatedMatrix.length; i++) {
            assertThat(repeatedMatrix[i].length).isEqualTo(expectedPattern[i].length);
            for (int j = 0; j < repeatedMatrix[i].length; j++) {
                assertThat(repeatedMatrix[i][j]).isEqualTo(expectedPattern[i][j]);
            }
        }
    }

    @Test
    @DisplayName("Repeat area to the right 2 times")
    void repeatPatternToTheRight2Times() {
        Toboggan toboggan = new Toboggan();
        char[][] matrix = toboggan.readFromPattern(PATTERN);

        int repetition = 2;
        char[][] repeatedMatrix = toboggan.repeat(matrix, repetition);

        char[][] expectedPattern = new char[][]{
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
        };

        printMatrix(repeatedMatrix);
        printMatrix(expectedPattern);

        assertThat(repeatedMatrix.length).isEqualTo(expectedPattern.length);
        for (int i = 0; i < repeatedMatrix.length; i++) {
            assertThat(repeatedMatrix[i].length).isEqualTo(expectedPattern[i].length);
            for (int j = 0; j < repeatedMatrix[i].length; j++) {
                assertThat(repeatedMatrix[i][j]).isEqualTo(expectedPattern[i][j]);
            }
        }
    }

    private void printMatrix(char[][] matrix) {
        for (char[] line : matrix) {
            for (char aChar : line) {
                System.out.printf("%c", aChar);
            }
            System.out.println();
        }
    }
}
