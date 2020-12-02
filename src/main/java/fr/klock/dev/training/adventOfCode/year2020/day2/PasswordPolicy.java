package fr.klock.dev.training.adventOfCode.year2020.day2;

import org.apache.commons.lang3.StringUtils;

public class PasswordPolicy {

    private static final String OCCURENCES_SEPARATOR = "-";
    private static final String POLICY_PASSWORD_SEPARATOR = ": ";

    private final int minOccurences;
    private final int maxOccurences;
    private final String letter;

    private final String password;

    public PasswordPolicy(String entry) {
        String[] split = entry.split(POLICY_PASSWORD_SEPARATOR);
        String policy = split[0];
        password = split[1];

        String[] policyRules = policy.split(StringUtils.SPACE);

        String[] numberOfOccurences = policyRules[0].split(OCCURENCES_SEPARATOR);
        minOccurences = Integer.parseInt(numberOfOccurences[0]);
        maxOccurences = Integer.parseInt(numberOfOccurences[1]);
        letter = policyRules[1];
    }

    public boolean validatePassword() {
        int countMatches = StringUtils.countMatches(password, letter);

        return minOccurences <= countMatches && countMatches <= maxOccurences;
    }
}
