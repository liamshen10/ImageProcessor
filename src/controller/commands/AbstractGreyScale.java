package controller.commands;

import java.util.function.Function;

import model.ImageProcessingModel;
import model.image.IPixel;
import model.image.Image;
import model.image.Pixel;
import model.image.PpmImage;

/**
 * this class represents exists to avoid code duplication by abstracting out common
 * functionality of a greyscale command class.
 */
public abstract class AbstractGreyScale implements Command {
  protected final String name;
  protected final String destName;

  /**
   * constructor for a greyscale command class which takes in the image name and destination name.
   *
   * @param name     name of the image to transform
   * @param destName destination name of the image to transform
   */
  public AbstractGreyScale(String name, String destName) {
    if ((name == null) || (destName == null)) {
      throw new IllegalArgumentException("Can't have null fields");
    }
    this.name = name;
    this.destName = destName;
  }

  /**
   * sets all the pixels to a certain value based on the function object provided for each pixel.
   *
   * @param model  the model to get the image from
   * @param getVal a function object that will tell what value to set the rgb of the pixel for each
   */
  protected void setAllPixelsToValue(ImageProcessingModel model, Function<IPixel, Integer> getVal) {
    Image image = model.getImage(name);
    int height = image.getHeight();
    int width = image.getWidth();
    Image newImage = new PpmImage(image);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        IPixel oldP = newImage.getPixel(x, y);
        int color = getVal.apply(oldP);
        Pixel newP = new Pixel(color, color, color);
        newImage.setPixel(x, y, newP);
      }
    }
    model.addImage(destName, newImage);
  }

  public abstract void run(ImageProcessingModel model);


}
