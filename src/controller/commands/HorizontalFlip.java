package controller.commands;

import model.ImageProcessingModel;
import model.image.Image;
import model.image.PpmImage;

/**
 * class HorizontalFlip represents a command to horizontally flip an image.
 */
public class HorizontalFlip extends AbstractFlip implements Command {


  /**
   * constructor that takes in a file name and destination name for the command.
   *
   * @param name     name of the file
   * @param destName destination name of the file
   */
  public HorizontalFlip(String name, String destName) {
    super(name, destName);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    Image image = model.getImage(name);
    Image newImage = new PpmImage(image);
    int height = image.getHeight();
    int width = image.getWidth();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {

        newImage.setPixel(width - x - 1, y, image.getPixel(x, y));
      }
    }
    model.addImage(destName, newImage);
  }
}