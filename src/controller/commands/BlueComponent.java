package controller.commands;

import model.ImageProcessingModel;
import model.image.IPixel;

/**
 * class BlueComponent represents a grayScale with the blue component.
 */
public class BlueComponent extends AbstractGreyScale implements Command {

  /**
   * constructor that takes in a file name and destination name for the command.
   *
   * @param name     name of the file
   * @param destName destination name of the file
   */
  public BlueComponent(String name, String destName) {
    super(name, destName);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    this.setAllPixelsToValue(model, IPixel::getBlue);
  }
}
