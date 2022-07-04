package controller.commands;

import model.ImageProcessingModel;
import model.image.IPixel;
import model.image.Image;
import model.image.NonPPMImage;

/**
 * Represents a downscale command that downscales an image to a new width and height.
 */
public class Downscale implements Command {
  private final String name;
  private final String destinationName;
  private final int newWidth;
  private final int newHeight;

  /**
   * constructor for the downscale command that takes in a name of the image, the destination name
   * of the image, the new width and height for the output. It downscales the image to the
   * new width and height.
   *
   * @param name name of the image
   * @param destinationName destination name of the image
   * @param newWidth width of the new image
   * @param newHeight height of the new image
   */
  public Downscale(String name, String destinationName, int newWidth, int newHeight) {
    if (newWidth <= 0 || newHeight <= 0) {
      throw new IllegalArgumentException("width and height must be greater than 0");
    }

    if (name == null || destinationName == null) {
      throw new IllegalArgumentException("Can't have null values");
    }
    this.name = name;
    this.destinationName = destinationName;
    this.newWidth = newWidth;
    this.newHeight = newHeight;
  }


  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    Image image = model.getImage(name);
    Image newImage = new NonPPMImage(newWidth, newHeight);
    int oldWidth = image.getWidth();
    int oldHeight = image.getHeight();

    for (double newX = 0; newX < newWidth; newX++) {
      for (double newY = 0; newY < newHeight; newY++) {

        int oldX = (int) ((newX / newWidth) * oldWidth);
        int oldY = (int) ((newY / newHeight) * oldHeight);

        IPixel p = image.getPixel(oldX, oldY);

        newImage.setPixel((int) newX, (int) newY, p);

      }
    }
    model.addImage(destinationName, newImage);
  }
}
