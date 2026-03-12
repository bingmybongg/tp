package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's skill level in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSkill(String)}
 */
public class Skill {

    public static final String MESSAGE_CONSTRAINTS =
            "Skill level must be one of these values: novice, intermediate, pro";

    public static final String SKILL_NOVICE = "novice";
    public static final String SKILL_INTERMEDIATE = "intermediate";
    public static final String SKILL_PRO = "pro";

    public final String value;

    /**
     * Constructs a {@code Skill}.
     *
     * @param skill A valid skill level.
     */
    public Skill(String skill) {
        requireNonNull(skill);
        String normalizedSkill = skill.trim().toLowerCase();
        checkArgument(isValidSkill(normalizedSkill), MESSAGE_CONSTRAINTS);
        value = normalizedSkill;
    }

    /**
     * Returns true if a given string is a valid skill level.
     */
    public static boolean isValidSkill(String test) {
        requireNonNull(test);
        String normalizedSkill = test.trim().toLowerCase();
        return normalizedSkill.equals(SKILL_NOVICE)
                || normalizedSkill.equals(SKILL_INTERMEDIATE)
                || normalizedSkill.equals(SKILL_PRO);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Skill)) {
            return false;
        }

        Skill otherSkill = (Skill) other;
        return value.equals(otherSkill.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
