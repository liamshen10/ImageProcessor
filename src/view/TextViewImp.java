package view;

import java.io.IOException;

/**
 * Represents a text viewer that implements the TextView interface.
 */
public class TextViewImp implements TextView {

  private final Appendable output;

  /**
   * constructor for TextViewImp view.
   *
   * @param output represents an Appendable object
   */
  public TextViewImp(Appendable output) {
    if (output == null) {
      throw new IllegalArgumentException("Can't have null appendable");
    }
    this.output = output;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    output.append(message);
  }
}
