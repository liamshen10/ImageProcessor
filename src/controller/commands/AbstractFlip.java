package controller.commands;

/**
 * this class represents a command that has to do with flipping an image and exists to avoid
 * code duplication.
 */
public abstract class AbstractFlip implements Command {
  protected final String name;
  protected final String destName;

  /**
   * constructor that takes in a file name and destination name for the command.
   *
   * @param name     name of the file
   * @param destName destination name of the file
   */
  public AbstractFlip(String name, String destName) {
    if ((name == null) || (destName == null)) {
      throw new IllegalArgumentException("can't have null values");
    }

    this.name = name;
    this.destName = destName;
  }

}
