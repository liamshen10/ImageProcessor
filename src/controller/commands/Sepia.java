package controller.commands;

import model.ImageProcessingModel;
import model.image.Image;
import model.image.Pixel;
import model.image.PpmImage;

/**
 * this class represents a sepia image processing command and applies a sepia filter to the image.
 */
public class Sepia implements Command {
  private final String name;
  private final String destName;

  /**
   * this constructor for the sepia command that takes in the name of the image to process
   * and its destination name.
   * @param name name of the image
   * @param destName destination name of the image.
   */
  public Sepia(String name, String destName) {
    if (name == null || destName == null) {
      throw new IllegalArgumentException("can't have null values");
    }
    this.name = name;
    this.destName = destName;
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    Image image = model.getImage(name);
    Image newImage = new PpmImage(image);

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {

        int newRed = (int) (0.393 * image.getPixel(x, y).getRed()
                + 0.769 * image.getPixel(x, y).getGreen()
                + 0.189 * image.getPixel(x, y).getBlue());
        int newGreen = (int) (0.349 * image.getPixel(x, y).getRed()
                + 0.686 * image.getPixel(x, y).getGreen()
                + 0.168 * image.getPixel(x, y).getBlue());
        int newBlue = (int) (0.272 * image.getPixel(x, y).getRed()
                + 0.534 * image.getPixel(x, y).getGreen()
                + 0.131 * image.getPixel(x, y).getBlue());

        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }

        newImage.setPixel(x, y, new Pixel(newRed, newGreen, newBlue));
      }
    }
    model.addImage(destName, newImage);

  }
}
