package controller.commands;

import model.ImageProcessingModel;

/**
 * class LumaComponent that determines the luma of pixels within an image.
 */
public class LumaComponent extends AbstractGreyScale implements Command {

  /**
   * constructor that takes in a file name and destination name for the command.
   *
   * @param name     name of the file
   * @param destName destination name of the file
   */
  public LumaComponent(String name, String destName) {
    super(name, destName);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    this.setAllPixelsToValue(model, (p) -> (int) p.getLuma());
  }
}
