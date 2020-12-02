package fr.klock.dev.training.adventOfCode.year2020;

import fr.klock.dev.training.adventOfCode.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Advent Of Code 2020 - Day 2")
class DayTwoTest {

    public static final String ENTRY1 = "1-3 a: abcde";
    public static final String ENTRY2 = "1-3 b: cdefg";
    public static final String ENTRY3 = "2-9 c: ccccccccc";

    @Test
    @DisplayName("Case 1: 1-3 a: abcde")
    void validateCaseOnePassword() {
        assertThat(new DayTwo().validatePasswordAgainstPolicy(ENTRY1)).isTrue();
    }

    @Test
    @DisplayName("Case 2: 1-3 b: cdefg")
    void validateCaseTwoPassword() {
        assertThat(new DayTwo().validatePasswordAgainstPolicy(ENTRY2)).isFalse();
    }

    @Test
    @DisplayName("Case 3: 2-9 c: ccccccccc")
    void validateCaseThreePassword() {
        assertThat(new DayTwo().validatePasswordAgainstPolicy(ENTRY3)).isTrue();
    }

    @Test
    @DisplayName("Case 1-3: Number of valid passwords")
    void validateManyPasswords() {
        assertThat(new DayTwo().getNumberOfValidPasswords(List.of(ENTRY1, ENTRY2, ENTRY3))).isEqualTo(2);
    }

    @Test
    @DisplayName("Number of valid passwords in whole database")
    void getNumberOfValidPasswordsInDatabase() throws IOException {
        String[] expenseReportAsString = FileUtils.loadInput(this, "day-two.txt");
        long numberOfValidPasswords = new DayTwo().getNumberOfValidPasswords(List.of(expenseReportAsString));

        assertThat(numberOfValidPasswords).isEqualTo(546);
    }
}