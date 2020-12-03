package fr.klock.dev.training.adventOfCode.year2020.day3;

import fr.klock.dev.training.adventOfCode.FileUtils;
import fr.klock.dev.training.adventOfCode.MatrixUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

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

    @Test
    void getNumberOfEncounteredTreesRide_3_1() {
        int numberOfEncounteredTrees = rideSlopeForDemoPattern(3, 1);
        assertThat(numberOfEncounteredTrees).isEqualTo(7);
    }

    @Test
    void getProductForNumberOfEncounteredTrees() {
        int ride1_1 = rideSlopeForDemoPattern(1, 1);
        int ride3_1 = rideSlopeForDemoPattern(3, 1);
        int ride5_1 = rideSlopeForDemoPattern(5, 1);
        int ride7_1 = rideSlopeForDemoPattern(7, 1);
        int ride1_2 = rideSlopeForDemoPattern(1, 2);
        assertThat(ride1_1).isEqualTo(2);
        assertThat(ride3_1).isEqualTo(7);
        assertThat(ride5_1).isEqualTo(3);
        assertThat(ride7_1).isEqualTo(4);
        assertThat(ride1_2).isEqualTo(2);
        int product = ride1_1 * ride3_1 * ride5_1 * ride7_1 * ride1_2;
        assertThat(product).isEqualTo(336);
    }

    private int rideSlopeForDemoPattern(int rightMove, int downMove) {
        Toboggan toboggan =
                Toboggan.initFrom(
                        MatrixUtils.repeatPattern(
                                MatrixUtils.readFromPattern(PATTERN),
                                7));

        toboggan.rideSlope(downMove, rightMove);

        return toboggan.getNumberOfEncounteredTrees();
    }

    @Test
    void numberOfTreesForPuzzleInputRide_3_1() throws IOException {
        int numberOfEncounteredTrees = rideSlopeOfPuzzleInput(3, 1);
        assertThat(numberOfEncounteredTrees).isEqualTo(232);
    }

    @Test
    void getProductForNumberOfEncounteredTreesForPuzzleInput() throws IOException {
        int ride1_1 = rideSlopeOfPuzzleInput(1, 1);
        int ride3_1 = rideSlopeOfPuzzleInput(3, 1);
        int ride5_1 = rideSlopeOfPuzzleInput(5, 1);
        int ride7_1 = rideSlopeOfPuzzleInput(7, 1);
        int ride1_2 = rideSlopeOfPuzzleInput(1, 2);
        long product = (long) ride1_1 * ride3_1 * ride5_1 * ride7_1 * ride1_2;
        assertThat(product).isEqualTo(3952291680L);
    }

    private int rideSlopeOfPuzzleInput(int rightMove, int downMove) throws IOException {
        Toboggan toboggan =
                Toboggan.initFrom(
                        MatrixUtils.repeatPattern(
                                MatrixUtils.readFromPattern(
                                        FileUtils.loadInput(this, "slope.txt"))
                                , 75));

        toboggan.rideSlope(downMove, rightMove);

        return toboggan.getNumberOfEncounteredTrees();
    }
}
