package fr.klock.dev.training.adventOfCode.year2020;

import org.apache.commons.lang3.StringUtils;

public class DayTwo {

    public boolean validatePasswordAgainstPolicy(String policy, String password) {
        PasswordPolicy passwordPolicy = new PasswordPolicy.Builder().withPolicy(policy).build();

        int countMatches = StringUtils.countMatches(password, passwordPolicy.getLetter());

        return passwordPolicy.getMinOccurences() <= countMatches && countMatches <= passwordPolicy.getMaxOccurences();
    }

    public static class PasswordPolicy {

        private int minOccurences;
        private int maxOccurences;
        private String letter;

        private PasswordPolicy() {
        }

        private void setMinOccurences(int minOccurences) {
            this.minOccurences = minOccurences;
        }

        public int getMinOccurences() {
            return minOccurences;
        }

        public void setMaxOccurences(int maxOccurences) {
            this.maxOccurences = maxOccurences;
        }

        public int getMaxOccurences() {
            return maxOccurences;
        }

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public String getLetter() {
            return letter;
        }

        public static class Builder {
            private final PasswordPolicy passwordPolicy = new PasswordPolicy();

            public Builder withPolicy(String policy) {
                String[] policyRules = policy.split(" ");
                String[] numberOfOccurences = policyRules[0].split("-");
                this.passwordPolicy.setMinOccurences(Integer.parseInt(numberOfOccurences[0]));
                this.passwordPolicy.setMaxOccurences(Integer.parseInt(numberOfOccurences[1]));

                this.passwordPolicy.setLetter(policyRules[1]);
                return this;
            }

            public PasswordPolicy build() {
                return passwordPolicy;
            }
        }


    }
}
