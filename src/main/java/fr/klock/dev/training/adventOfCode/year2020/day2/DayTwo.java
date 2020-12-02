package fr.klock.dev.training.adventOfCode.year2020.day2;

import java.util.List;

public class DayTwo {

    public boolean validatePasswordAgainstPolicy(String entry) {
        return new PasswordPolicyNumberOfLetter(entry)
                .validatePassword();
    }

    public long getNumberOfValidPasswords(List<String> passwordDatabase) {
        return passwordDatabase.stream()
                .filter(this::validatePasswordAgainstPolicy)
                .count();
    }

}
