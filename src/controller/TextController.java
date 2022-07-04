package controller;

/**
 * This interface represents operations that are offered by
 * a controller for the image processor.
 */
public interface TextController {

  /**
   * Starts the controller, which starts the program, and runs until the program ends
   * due to user quitting or exception. If the user enters the script.txt incorrectly, then the
   * program should ask them to reenter the input properly. Some things like being unable to
   * append to the appendable in the view, the readable running out of inputs should throw
   * an illegalStateException. Errors like being unable to read or write from a file should
   * be communicated to the user through the view, and then they should be asked to reenter inputs.
   *
   * @throws IllegalStateException if error happens that it can't recover from as detailed above
   */
  public void start() throws IllegalStateException;
}
