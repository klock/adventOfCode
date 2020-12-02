package fr.klock.dev.training.adventOfCode.year2020.day2;

import org.apache.commons.lang3.StringUtils;

public class PasswordPolicyNumberOfLetter extends PasswordPolicy {

    private final int minOccurences;
    private final int maxOccurences;

    public PasswordPolicyNumberOfLetter(String entry) {
        String policyRule = init(entry);

        String[] numberOfOccurences = policyRule.split(OCCURENCES_SEPARATOR);
        minOccurences = Integer.parseInt(numberOfOccurences[0]);
        maxOccurences = Integer.parseInt(numberOfOccurences[1]);
    }

    public boolean validatePassword() {
        int countMatches = StringUtils.countMatches(getPassword(), getLetter());

        return minOccurences <= countMatches && countMatches <= maxOccurences;
    }
}
