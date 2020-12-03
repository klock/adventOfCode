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
        char[][] chars = new Toboggan().readFromPattern(PATTERN);
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
        assertThat(chars.length).isEqualTo(expectedPattern.length);
        for (int i = 0; i < chars.length; i++) {
            assertThat(chars[i].length).isEqualTo(expectedPattern[i].length);
            for (int j = 0; j < chars[i].length; j++) {
                assertThat(chars[i][j]).isEqualTo(expectedPattern[i][j]);
            }
        }
    }

}
