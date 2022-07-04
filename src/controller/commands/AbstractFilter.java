package controller.commands;

import model.ImageProcessingModel;
import model.image.IPixel;
import model.image.Image;
import model.image.Pixel;
import model.image.PpmImage;

/**
 * this class represents a command that uses a filter.
 */
public abstract class AbstractFilter implements Command {
  protected final String name;
  protected final String destName;

  /**
   * constructor for a filter command that takes in a image name and destination name.
   * @param name name of the image
   * @param destName destination name of the image
   */
  public AbstractFilter(String name, String destName) {
    if ((name == null) || (destName == null)) {
      throw new IllegalArgumentException("Can't have null fields");
    }
    this.name = name;
    this.destName = destName;
  }

  /**
   * this method uses a kernel to filter the image.
   * @param model the model to get image from
   * @param kernel the kernel to use when making the calculations
   */
  // give column row(x,y)
  // top left of kernel is (0,0) x increases right and y increases down
  protected void filter(ImageProcessingModel model, double[][] kernel) {
    if ((kernel.length % 2 != 1) || (kernel.length != kernel[0].length)) {

      throw new IllegalArgumentException("kernel must be an odd square matrix");
    }

    Image image = model.getImage(name);
    Image newImage = new PpmImage(image);

    IPixel[][] pixelArray = new IPixel[image.getWidth()][image.getHeight()];
    //making array of pixels corresponding to image
    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        pixelArray[x][y] = image.getPixel(x, y);
      }
    }

    // making the array for the new image
    IPixel[][] newPixelArray = new IPixel[image.getWidth()][image.getHeight()];
    int pixelArrayWidth = image.getWidth();
    int pixelArrayHeight = image.getHeight();

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        double redValue = 0;
        double greenValue = 0;
        double blueValue = 0;
        //applying each of the values in the kernel
        for (int kerX = 0; kerX < kernel.length; kerX++) {
          for (int kerY = 0; kerY < kernel[0].length; kerY++) {

            //check bounds
            int hDistanceFromCenter = kerX - (kernel.length - 1) / 2;
            int vDistanceFromCenter = kerY - (kernel.length - 1) / 2;

            if (x + hDistanceFromCenter >= 0
                    && x + hDistanceFromCenter <= pixelArrayWidth - 1
                    && y + vDistanceFromCenter >= 0
                    && y + vDistanceFromCenter <= pixelArrayHeight - 1) {

              redValue += pixelArray[x + hDistanceFromCenter][y
                      + vDistanceFromCenter].getRed() * kernel[kerX][kerY];
              greenValue += pixelArray[x + hDistanceFromCenter][y
                      + vDistanceFromCenter].getGreen() * kernel[kerX][kerY];
              blueValue += pixelArray[x + hDistanceFromCenter][y
                      + vDistanceFromCenter].getBlue() * kernel[kerX][kerY];
            }
          }
        }
        if (redValue > 255) {
          redValue = 255;
        }
        if (greenValue > 255) {
          greenValue = 255;
        }
        if (blueValue > 255) {
          blueValue = 255;
        }

        if (redValue < 0) {
          redValue = 0;
        }
        if (greenValue < 0) {
          greenValue = 0;
        }
        if (blueValue < 0) {
          blueValue = 0;
        }

        IPixel newPixel = new Pixel((int) redValue, (int) greenValue, (int) blueValue);

        newPixelArray[x][y] = newPixel;
      }
    }
    //setting the pixels of the new image
    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        newImage.setPixel(x,y, newPixelArray[x][y]);
      }
    }

    model.addImage(destName, newImage);
  }
}
