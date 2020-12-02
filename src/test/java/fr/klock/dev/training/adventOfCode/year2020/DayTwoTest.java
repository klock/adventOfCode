package fr.klock.dev.training.adventOfCode.year2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwoTest {

    public static final String POLICY1 = "1-3 a";
    public static final String PASSWORD1 = "abcde";
    public static final String POLICY2 = "1-3 b";
    public static final String PASSWORD2 = "cdefg";
    public static final String POLICY3 = "2-9 c";
    public static final String PASSWORD3 = "ccccccccc";

    @Test
    @DisplayName("Case 1: 1-3 a: abcde")
    void validateCaseOnePassword() {
        assertThat(new DayTwo().validatePasswordAgainstPolicy(POLICY1, PASSWORD1)).isTrue();
    }

    @Test
    @DisplayName("Case 2: 1-3 b: cdefg")
    void validateCaseTwoPassword() {
        assertThat(new DayTwo().validatePasswordAgainstPolicy(POLICY2, PASSWORD2)).isFalse();
    }

    @Test
    @DisplayName("Case 3: 2-9 c: ccccccccc")
    void validateCaseThreePassword() {
        assertThat(new DayTwo().validatePasswordAgainstPolicy(POLICY3, PASSWORD3)).isTrue();
    }

    @Test
    @DisplayName("Case 1-3: Number of valid passwords")
    void validateManyPasswords() {
        Map<String, String> passwordDatabase = initPasswordDatabase();
        assertThat(new DayTwo().getNumberOfValidPasswords(passwordDatabase)).isEqualTo(2);
    }

    Map<String, String> initPasswordDatabase() {
        Map<String, String> passwordDatabase;
        passwordDatabase = new HashMap<>();
        passwordDatabase.put(POLICY1, PASSWORD1);
        passwordDatabase.put(POLICY2, PASSWORD2);
        passwordDatabase.put(POLICY3, PASSWORD3);
        return passwordDatabase;
    }
}