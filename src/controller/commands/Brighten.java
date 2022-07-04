package controller.commands;

import model.ImageProcessingModel;
import model.image.IPixel;
import model.image.Image;
import model.image.Pixel;
import model.image.PpmImage;

/**
 * this class represents a brighten command that brightens or darkens and image by and increment.
 */
public class Brighten implements Command {

  private final String name;
  private final String destName;
  private final int constant;

  /**
   * Constructor for brighten that takes in the constant to brighten by, the name of the image,
   * and the destination name.
   *
   * @param constant is an int to increase or decrease the brightness by
   * @param name     is the name of the image
   * @param destName is the destination name of the image
   */
  public Brighten(int constant, String name, String destName) {
    if ((name == null) || (destName == null)) {
      throw new IllegalArgumentException("can't have null values");
    }
    this.name = name;
    this.destName = destName;
    this.constant = constant;
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    Image image = model.getImage(name);
    Image newImage = new PpmImage(image);
    int height = newImage.getHeight();
    int width = newImage.getWidth();


    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        IPixel pixel = newImage.getPixel(x, y);

        int newRed = pixel.getRed() + constant;
        int newGreen = pixel.getGreen() + constant;
        int newBlue = pixel.getBlue() + constant;

        if (newRed < 0) {
          newRed = 0;
        }
        if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue < 0) {
          newBlue = 0;
        }
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