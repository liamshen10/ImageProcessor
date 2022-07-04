package controller.commands;

/**
 * this abstract class represents a command that has something to do with accessing a file.
 */
public abstract class AbstractFileCommand implements Command {
  protected final String filePath;
  protected final String name;

  /**
   * constructor that takes in a filePath and name for the command.
   *
   * @param filePath path of the file
   * @param name     name of the file
   */
  public AbstractFileCommand(String filePath, String name) {
    if ((filePath == null) || (name == null)) {
      throw new IllegalArgumentException("can't have null values");
    }

    this.filePath = filePath;
    this.name = name;
  }

  /**
   * gets the file format for the path.
   *
   * @param filePath path of the file
   * @return a file extension
   */
  protected String getFileExtension(String filePath) {
    String formatBackwards = "";

    for (int i = filePath.length() - 1; i >= 0; i--) {
      if (filePath.charAt(i) == '.') {
        break;
      }
      formatBackwards += filePath.charAt(i);
    }
    String format = "";

    for (int i = formatBackwards.length() - 1; i >= 0; i--) {
      format += formatBackwards.charAt(i);
    }
    return format;
  }


}
