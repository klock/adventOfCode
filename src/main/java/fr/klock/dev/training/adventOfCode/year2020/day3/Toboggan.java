package fr.klock.dev.training.adventOfCode.year2020.day3;

import fr.klock.dev.training.adventOfCode.MatrixUtils;

public class Toboggan {

    private final char[][] matrix;

    public Toboggan(char[][] matrix) {
        this.matrix = matrix;
    }

    public static Toboggan initFrom(char[][] matrix) {
        return new Toboggan(MatrixUtils.copyMatrix(matrix));
    }

    public char[][] rideSlope(int downMove, int rightMove) {
        int[] pos = new int[]{downMove, rightMove};
        while (pos[0] < matrix.length) {
            ride(this.matrix[pos[0]], pos[1]);
            // increment
            pos[0] = pos[0] + downMove;
            pos[1] = pos[1] + rightMove;
        }
        return MatrixUtils.copyMatrix(matrix);
    }

    private void ride(char[] line, int i) {
        char step = line[i];
        if (step == '.') {
            line[i] = 'O';
        } else if (step == '#') {
            line[i] = 'X';
        }
    }
}
