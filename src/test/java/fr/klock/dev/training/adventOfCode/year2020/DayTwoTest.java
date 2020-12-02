package fr.klock.dev.training.adventOfCode.year2020;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwoTest {

    public static final String POLICY1 = "1-3 a";
    public static final String PASSWORD1 = "abcde";
    public static final String POLICY2 = "1-3 b";
    public static final String PASSWORD2 = "cdefg";
    public static final String POLICY3 = "2-9 c";
    public static final String PASSWORD = "ccccccccc";
    public static final String PASSWORD3 = PASSWORD;

    @Test
    @DisplayName("Case One: 1-3 a: abcde")
    void validateCaseOnePassword() {
        assertThat(validatePasswordAgainstPolicy(POLICY1, PASSWORD1)).isTrue();
    }

    @Test
    @DisplayName("Case Two: 1-3 b: cdefg")
    void validateCaseTwoPassword() {
        assertThat(validatePasswordAgainstPolicy(POLICY2, PASSWORD2)).isFalse();
    }

    @Test
    @DisplayName("Case Three: 2-9 c: ccccccccc")
    void validateCaseThreePassword() {
        assertThat(validatePasswordAgainstPolicy(POLICY3, PASSWORD3)).isTrue();
    }

    private boolean validatePasswordAgainstPolicy(String policy, String password) {
        DayTwo dayTwo = new DayTwo();
        return dayTwo.validatePasswordAgainstPolicy(policy, password);
    }

}