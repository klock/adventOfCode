package fr.klock.dev.training.adventOfCode;

import fr.klock.dev.training.adventOfCode.year2020.day3.Toboggan;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatrixUtilsTest {

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
        char[][] matrix = MatrixUtils.readFromPattern(PATTERN);

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
    @DisplayName("Extract area pattern lines to matrix")
    void readPatternLinesToMatrix() {
        String[] lines = PATTERN.split(StringUtils.LF);
        char[][] matrix = MatrixUtils.readFromPattern(lines);

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
        char[][] matrix = MatrixUtils.readFromPattern(PATTERN);

        int repetition = 1;
        char[][] repeatedMatrix = MatrixUtils.repeatPattern(matrix, repetition);

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
        char[][] matrix = MatrixUtils.readFromPattern(PATTERN);

        int repetition = 2;
        char[][] repeatedMatrix = MatrixUtils.repeatPattern(matrix, repetition);

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

        assertThat(repeatedMatrix.length).isEqualTo(expectedPattern.length);
        for (int i = 0; i < repeatedMatrix.length; i++) {
            assertThat(repeatedMatrix[i].length).isEqualTo(expectedPattern[i].length);
            for (int j = 0; j < repeatedMatrix[i].length; j++) {
                assertThat(repeatedMatrix[i][j]).isEqualTo(expectedPattern[i][j]);
            }
        }
    }

    @Test
    @DisplayName("Copy matrix")
    void copyMatrix() {
        char[][] matrix = MatrixUtils.readFromPattern(PATTERN);
        char[][] copyMatrix = MatrixUtils.copyMatrix(matrix);

        assertThat(copyMatrix.length).isEqualTo(matrix.length);
        for (int i = 0; i < copyMatrix.length; i++) {
            assertThat(copyMatrix[i].length).isEqualTo(matrix[i].length);
            for (int j = 0; j < copyMatrix[i].length; j++) {
                assertThat(copyMatrix[i][j]).isEqualTo(matrix[i][j]);
            }
        }
    }

}