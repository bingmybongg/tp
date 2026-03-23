package seedu.address.commons.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Skill;

class StartupErrorMessageTest {

    @Test
    void build_withSkillErrorMessage_displayReason() {
        DataLoadingException exception = new DataLoadingException(
                new IllegalValueException(Skill.MESSAGE_CONSTRAINTS));
        String actual = StartupErrorMessage.build(Paths.get("data/addressbook.json"), exception);
        String expected = String.format(StartupErrorMessage.WARNING_MESSAGE_FORMAT,
                "data/addressbook.json", Skill.MESSAGE_CONSTRAINTS);
        assertEquals(expected, actual);
    }

    @Test
    void build_withBlankCauseMessage_usesFallbackReason() {
        DataLoadingException exception = new DataLoadingException(new IllegalValueException("  "));
        String actual = StartupErrorMessage.build(Paths.get("data/addressbook.json"), exception);
        String expected = String.format(StartupErrorMessage.WARNING_MESSAGE_FORMAT,
                "data/addressbook.json", StartupErrorMessage.FALLBACK_REASON);
        assertEquals(expected, actual);
    }

    @Test
    void build_withNullCause_usesFallbackReason() {
        DataLoadingException exception = new DataLoadingException(null);
        String actual = StartupErrorMessage.build(Paths.get("data/addressbook.json"), exception);
        String expected = String.format(StartupErrorMessage.WARNING_MESSAGE_FORMAT,
                "data/addressbook.json", StartupErrorMessage.FALLBACK_REASON);
        assertEquals(expected, actual);
    }

    @Test
    void build_withNullException_usesFallbackReason() {
        DataLoadingException exception = null;
        String actual = StartupErrorMessage.build(Paths.get("data/addressbook.json"), exception);
        String expected = String.format(StartupErrorMessage.WARNING_MESSAGE_FORMAT,
                "data/addressbook.json", StartupErrorMessage.FALLBACK_REASON);
        assertEquals(expected, actual);
    }
}
