package model.image;

/**
 * This class represents a single RGB pixel.
 */
public class Pixel implements IPixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Represents an individual pixel that takes in red, green, and blue values.
   *
   * @param red   is an int between 0-255 inclusive representing red
   * @param green is an int between 0-255 inclusive representing green
   * @param blue  is an int between 0-255 inclusive representing blue
   */
  public Pixel(int red, int green, int blue) {
    if (red < 0 || green < 0 || blue < 0 || red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("Color values must be from 0 to 255: "
                                         + red + green + blue);
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public int getRed() {
    return red;
  }

  @Override
  public void setRed(int red) throws IllegalArgumentException {
    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Color values must be from 0 to 255");
    }
    this.red = red;
  }

  @Override
  public int getGreen() {
    return green;
  }

  @Override
  public void setGreen(int green) throws IllegalArgumentException {
    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Color values must be from 0 to 255");
    }
    this.green = green;
  }

  @Override
  public int getBlue() {
    return blue;
  }

  @Override
  public void setBlue(int blue) throws IllegalArgumentException {
    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Color values must be from 0 to 255");
    }
    this.blue = blue;
  }

  @Override
  public double getLuma() {
    return 0.2126 * this.red + 0.7152 * this.green + 0.0722 * this.blue;
  }

  @Override
  public int getValue() {
    if (red >= green && red >= blue) {
      return red;
    } else if (green >= red && green >= blue) {
      return green;
    } else {
      return blue;
    }
  }

  @Override
  public int getIntensity() {
    return (red + green + blue) / 3;
  }
}
