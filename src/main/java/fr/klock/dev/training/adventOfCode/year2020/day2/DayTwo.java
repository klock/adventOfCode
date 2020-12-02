package fr.klock.dev.training.adventOfCode.year2020.day2;

import java.util.List;

public class DayTwo {

    public boolean validatePasswordAccordingToLetterNumberPolicy(String entry) {
        return new PasswordPolicyLetterNumber(entry)
                .validatePassword();
    }

    public long getNumberOfValidPasswordsAccordingToLetterNumberPolicy(List<String> passwordDatabase) {
        return passwordDatabase.stream()
                .filter(this::validatePasswordAccordingToLetterNumberPolicy)
                .count();
    }

}
