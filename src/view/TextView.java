package view;

import java.io.IOException;

/**
 * This interface represents operations that are offered by
 * a view for the image processor.
 */
public interface TextView {

  /**
   * Render a specific message to the provided data destination.
   *
   * @param message the message to be transmitted
   * @throws IOException if transmission of the image to the provided data destination fails
   */
  public void renderMessage(String message) throws IOException;
}
