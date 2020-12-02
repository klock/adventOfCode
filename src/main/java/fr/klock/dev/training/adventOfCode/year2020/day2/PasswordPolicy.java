package fr.klock.dev.training.adventOfCode.year2020.day2;

import org.apache.commons.lang3.StringUtils;

public abstract class PasswordPolicy {

    public static final String OCCURENCES_SEPARATOR = "-";
    private static final String POLICY_PASSWORD_SEPARATOR = ": ";

    private String letter;
    private String password;

    public String getLetter() {
        return letter;
    }

    public String getPassword() {
        return password;
    }

    public String init(String entry) {
        String[] split = entry.split(POLICY_PASSWORD_SEPARATOR);
        String policy = split[0];
        password = split[1];

        String[] policyRules = policy.split(StringUtils.SPACE);
        letter = policyRules[1];

        return policyRules[0];
    }

    public abstract boolean validatePassword();
}
