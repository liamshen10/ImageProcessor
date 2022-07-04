package controller.commands;

import model.ImageProcessingModel;

/**
 * this class represents a greyScale color transformation command.
 */
public class GreyScale extends AbstractGreyScale implements Command {
  /**
   * the constructor for the greyscale command that takes in the name of the image to blur
   * and the destination name of the image.
   *
   * @param name     name of the file
   * @param destName destination name of the file
   */
  public GreyScale(String name, String destName) {
    super(name, destName);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {

    this.setAllPixelsToValue(model, p ->
            (int) (0.2126 * p.getRed() + 0.7152 * p.getGreen() + 0.0722 * p.getBlue()));

  }
}
