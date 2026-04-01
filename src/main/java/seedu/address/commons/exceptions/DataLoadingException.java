package seedu.address.commons.exceptions;

import java.nio.file.Path;
import java.util.Optional;

/**
 * Represents an error during loading of data from a file, optionally including the
 * location of a backup copy of the corrupted resource.
 */
public class DataLoadingException extends Exception {
    private final Path backupFilePath;

    /**
     * Constructs a {@code DataLoadingException} without a backup path.
     *
     * @param cause the underlying exception thrown when reading failed
     */
    public DataLoadingException(Exception cause) {
        this(cause, null);
    }

    /**
     * Constructs a {@code DataLoadingException} and records where the corrupted data
     * was backed up.
     *
     * @param cause the underlying exception thrown when reading failed
     * @param backupFilePath the path to the backup file, or {@code null} if none was created
     */
    public DataLoadingException(Exception cause, Path backupFilePath) {
        super(cause);
        this.backupFilePath = backupFilePath;
    }

    /**
     * Returns the path to the backup file, if one exists.
     *
     * @return an {@link Optional} containing the backup path when available, otherwise empty
     */
    public Optional<Path> getBackupFilePath() {
        return Optional.ofNullable(backupFilePath);
    }
}
