package fr.klock.dev.training.adventOfCode.year2020.day2;

public class PasswordPolicyLetterPosition extends PasswordPolicy {

    private final int positionA;
    private final int positionB;

    public PasswordPolicyLetterPosition(String entry) {
        String policyRule = init(entry);

        String[] positions = policyRule.split(OCCURENCES_SEPARATOR);
        positionA = Integer.parseInt(positions[0]);
        positionB = Integer.parseInt(positions[1]);
    }

    @Override
    public boolean validatePassword() {
        char letterA = getPassword().charAt(positionA - 1);
        char letterB = getPassword().charAt(positionB - 1);

        char policyLetter = getLetter().toCharArray()[0];

        boolean isLetterA = letterA == policyLetter;
        boolean isLetterB = letterB == policyLetter;
        return (isLetterA && !isLetterB)
                || (!isLetterA && isLetterB);
    }
}
