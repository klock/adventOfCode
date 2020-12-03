package fr.klock.dev.training.adventOfCode.year2020.day3;

import fr.klock.dev.training.adventOfCode.MatrixUtils;
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
    @DisplayName("Ride slope for pattern copied 2 times")
    void rideSlope() {
        Toboggan toboggan =  Toboggan.initFrom(MatrixUtils.repeatPattern(MatrixUtils.readFromPattern(PATTERN), 2));

        char[][] riddenMatrix = toboggan.rideSlope(1, 3);

        char[][] expectedPattern = new char[][]{
                {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
                {'#', '.', '.', 'O', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
                {'.', '#', '.', '.', '.', '.', 'X', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '.', '.', '.', '#', 'O', '#', '.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#', '.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.', '.', 'X', '.', '.', '.', '#', '#', '.', '.', '#', '.', '.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
                {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', 'X', '#', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
                {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', 'O', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', 'X', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.', '#', '.', 'X', '#', '.', '.', '.', '#', '.', '.', '.'},
                {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#', '#', '.', '.', '.', '#', 'X', '.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#', '.', '#', '.', '.', '#', '.', '.', '.', 'X', '.', '#'}
        };

        assertThat(riddenMatrix.length).isEqualTo(expectedPattern.length);
        for (int i = 0; i < riddenMatrix.length; i++) {
            assertThat(riddenMatrix[i].length).isEqualTo(expectedPattern[i].length);
            for (int j = 0; j < riddenMatrix[i].length; j++) {
                assertThat(riddenMatrix[i][j]).isEqualTo(expectedPattern[i][j]);
            }
        }
    }
}
