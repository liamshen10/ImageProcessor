package view;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;

import model.image.Image;

/**
 * GuiView allows the viewing of the user interface.
 */
public interface GuiView {

  /**
   * Sets the action listener in a class.
   *
   * @param listener listens for an action
   */
  void setActionListener(ActionListener listener);

  /**
   * Allows us to edit the image given.
   *
   * @param icon is the image represented
   */
  void setEditImage(ImageIcon icon);

  /**
   * Gets us the value to increment brightness by.
   *
   * @return the value needed to increment brightness
   */
  String getUserInputBox(String message);

  /**
   * Displays pop up messages.
   *
   * @param message is the string written
   */
  void showPopUp(String message);

  /**
   * Sets the histogram panel in the JFrame.
   *
   * @param image is the image given for the histogram
   * @throws IOException if image cannot be read
   */
  public void setHistogramPanel(Image image) throws IOException;
}
