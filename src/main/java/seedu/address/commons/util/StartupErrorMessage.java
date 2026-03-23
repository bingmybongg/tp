package seedu.address.commons.util;

import java.nio.file.Path;

import seedu.address.commons.exceptions.DataLoadingException;

/**
 * Utility used to build user-friendly error messages for data loading failures.
 */
public final class StartupErrorMessage {

    static final String FALLBACK_REASON = "An unknown error occurred while loading the data file.";

    private StartupErrorMessage() {
    }

    /**
     * Builds the startup error message that explains which data file failed to load
     * and shows the human-readable cause.
     */
    public static String build(Path dataFilePath, DataLoadingException exception) {
        String reason = getUserFacingErrorMessage(exception);
        return "WARNING: Data file at " + dataFilePath + " could not be loaded. Starting with an empty AddressBook.\n"
                + "Reason: " + reason;
    }

    /**
     * Extracts a user-facing error message from {@code DataLoadingException}.
     * Returns the root cause message if available, else falls back to the exception's
     * own message or a default fallback reason if no usable message is found.
     *
     * @param exception The exception to extract the message from.
     * @return A user-friendly error message.
     */
    static String getUserFacingErrorMessage(DataLoadingException exception) {
        if (exception == null) {
            return FALLBACK_REASON;
        }
        Throwable cause = exception.getCause();
        if (cause != null) {
            String message = trimIfPresent(cause.getMessage());
            if (message != null) {
                return message;
            }
        }
        return trimIfPresent(exception.getMessage());
    }

    /**
     * Returns {@code message} trimmed of whitespace if it contains text, or {@link #FALLBACK_REASON}
     * when the message is null or blank.
     */
    private static String trimIfPresent(String message) {
        if (message == null) {
            return FALLBACK_REASON;
        }
        String trimmed = message.trim();
        if (trimmed.isEmpty()) {
            return FALLBACK_REASON;
        }
        return trimmed;
    }
}
