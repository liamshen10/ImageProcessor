package model.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * This class represents a nonPPM image such as  bmp, jpg and png.
 */
public class NonPPMImage implements Image {
  private final BufferedImage bufferedImage;

  /**
   * The constructor for a NonPPMImage that creates the image from the filepath.
   *
   * @param filePath the filepath to generate the image from
   * @throws IllegalArgumentException if the
   * @throws IOException              if an error occurs when reading or can't create image
   *                                  input stream
   */
  public NonPPMImage(String filePath) throws IllegalArgumentException, IOException {
    if (filePath == null) {
      throw new IllegalArgumentException("can't have a null file path");
    }
    this.bufferedImage = ImageIO.read(new File(filePath));

    if (this.bufferedImage == null) {
      throw new IOException("file not supported");
    }
  }

  /**
   * constructor for NonPPMImage that generates a blank image with the height and width specified.
   *
   * @param width  the width of the image
   * @param height the height of the image
   */
  public NonPPMImage(int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("width and height must be greater than 0");
    }
    this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
  }

  @Override
  public int getWidth() {
    return bufferedImage.getWidth();
  }

  @Override
  public int getHeight() {
    return bufferedImage.getHeight();
  }

  @Override
  public int getMaxColorValue() {
    int maxColorValue = 0;
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {
        Color c = new Color(bufferedImage.getRGB(x, y));
        List<Integer> list = new ArrayList<Integer>();
        list.add(c.getRed());
        list.add(c.getGreen());
        list.add(c.getBlue());

        int biggest = 0;

        for (Integer i : list) {
          if (i > biggest) {
            biggest = i;
          }

          if (biggest > maxColorValue) {
            maxColorValue = biggest;
          }
        }
      }
    }
    return maxColorValue;
  }

  @Override
  public IPixel getPixel(int x, int y) throws IllegalArgumentException {
    Color color;
    try {
      color = new Color(bufferedImage.getRGB(x, y));
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("out of bounds");
    }

    return new Pixel(color.getRed(), color.getGreen(), color.getBlue());
  }

  @Override
  public void setPixel(int x, int y, IPixel p) throws IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("can't have a null pixel");
    }

    Color color = new Color(p.getRed(), p.getGreen(), p.getBlue());
    try {
      bufferedImage.setRGB(x, y, color.getRGB());

    } catch (ArrayIndexOutOfBoundsException e) {
      throw new IllegalArgumentException("out of bounds");
    }

  }
}
