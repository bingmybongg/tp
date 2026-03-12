package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class SkillTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Skill(null));
    }

    @Test
    public void constructor_invalidSkill_throwsIllegalArgumentException() {
        String invalidSkill = "";
        assertThrows(IllegalArgumentException.class, () -> new Skill(invalidSkill));
    }

    @Test
    public void isValidSkill() {
        // null skill
        assertThrows(NullPointerException.class, () -> Skill.isValidSkill(null));

        // invalid skill levels
        assertFalse(Skill.isValidSkill("")); // empty string
        assertFalse(Skill.isValidSkill(" ")); // spaces only
        assertFalse(Skill.isValidSkill("master")); // unsupported skill level
        assertFalse(Skill.isValidSkill("beginner")); // unsupported skill level

        // valid skill levels
        assertTrue(Skill.isValidSkill("novice"));
        assertTrue(Skill.isValidSkill("intermediate"));
        assertTrue(Skill.isValidSkill("pro"));
    }

    @Test
    public void equals() {
        Skill skill = new Skill("novice");

        // same values -> returns true
        assertTrue(skill.equals(new Skill("novice")));

        // same object -> returns true
        assertTrue(skill.equals(skill));

        // null -> returns false
        assertFalse(skill.equals(null));

        // different types -> returns false
        assertFalse(skill.equals(5.0f));

        // different values -> returns false
        assertFalse(skill.equals(new Skill("pro")));
    }
}
