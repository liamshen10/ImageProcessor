package model.image;

/**
 * Represents an exception where the file is corrupt or in wrong format.
 */
public class CorruptFileException extends Exception {
  /**
   * The constructor for the exception which takes in a message which is the exception message.
   * @param message the message for the exception
   */
  public CorruptFileException(String message) {
    super(message);
  }
}
