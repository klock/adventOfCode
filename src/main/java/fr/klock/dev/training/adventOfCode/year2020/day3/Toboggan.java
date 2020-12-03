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
}
