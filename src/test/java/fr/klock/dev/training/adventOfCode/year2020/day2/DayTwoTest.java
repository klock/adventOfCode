package fr.klock.dev.training.adventOfCode.year2020.day2;

import fr.klock.dev.training.adventOfCode.FileUtils;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Advent Of Code 2020 - Day 2")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class DayTwoTest {

    public static final String ENTRY1 = "1-3 a: abcde";
    public static final String ENTRY2 = "1-3 b: cdefg";
    public static final String ENTRY3 = "2-9 c: ccccccccc";

    @Nested
    @TestMethodOrder(MethodOrderer.Alphanumeric.class)
    @DisplayName("Part1")
    class Part1 {

        @Test
        @DisplayName("case 1: 1-3 a: abcde")
        void case1Password() {
            assertThat(new DayTwo().validatePasswordAccordingToLetterNumberPolicy(ENTRY1)).isTrue();
        }

        @Test
        @DisplayName("case 2: 1-3 b: cdefg")
        void case2Password() {
            assertThat(new DayTwo().validatePasswordAccordingToLetterNumberPolicy(ENTRY2)).isFalse();
        }

        @Test
        @DisplayName("case 3: 2-9 c: ccccccccc")
        void case3Password() {
            assertThat(new DayTwo().validatePasswordAccordingToLetterNumberPolicy(ENTRY3)).isTrue();
        }

        @Test
        @DisplayName("case 1-3: Number of valid passwords")
        void manyPasswords() {
            assertThat(new DayTwo().getNumberOfValidPasswordsAccordingToLetterNumberPolicy(List.of(ENTRY1, ENTRY2, ENTRY3))).isEqualTo(2);
        }

        @Test
        @DisplayName("Number of valid passwords in whole database")
        void numberOfValidPasswordsInDatabase() throws IOException {
            String[] expenseReportAsString = FileUtils.loadInput(this, "password-database.txt");
            long numberOfValidPasswords = new DayTwo().getNumberOfValidPasswordsAccordingToLetterNumberPolicy(List.of(expenseReportAsString));

            assertThat(numberOfValidPasswords).isEqualTo(546);
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.Alphanumeric.class)
    @DisplayName("Part2")
    class Part2 {

        @Test
        @DisplayName("case 1: 1-3 a: abcde")
        void case1Password() {
            assertThat(new DayTwo().validatePasswordAccordingToLetterPositionPolicy(ENTRY1)).isTrue();
        }

        @Test
        @DisplayName("case 2: 1-3 b: cdefg")
        void case2Password() {
            assertThat(new DayTwo().validatePasswordAccordingToLetterPositionPolicy(ENTRY2)).isFalse();
        }

        @Test
        @DisplayName("case 3: 2-9 c: ccccccccc")
        void case3Password() {
            assertThat(new DayTwo().validatePasswordAccordingToLetterPositionPolicy(ENTRY3)).isFalse();
        }

        @Test
        @DisplayName("case 1-3: Number of valid passwords")
        void manyPasswords() {
            assertThat(new DayTwo().getNumberOfValidPasswordsAccordingToLetterPositionPolicy(List.of(ENTRY1, ENTRY2, ENTRY3))).isEqualTo(1);
        }

        @Test
        @DisplayName("Number of valid passwords in whole database")
        void numberOfValidPasswordsInDatabase() throws IOException {
            String[] expenseReportAsString = FileUtils.loadInput(this, "password-database.txt");
            long numberOfValidPasswords = new DayTwo().getNumberOfValidPasswordsAccordingToLetterPositionPolicy(List.of(expenseReportAsString));

            assertThat(numberOfValidPasswords).isEqualTo(275);
        }
    }
}