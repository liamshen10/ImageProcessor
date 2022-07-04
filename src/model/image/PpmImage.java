package model.image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Represents a PpmImage that implements the image interface.
 */
public class PpmImage implements Image {
  private int width;
  private int height;
  private int maxColorValue;
  // x,y array of pixels
  //the top-left pixel is at location <0, 0> and bottom-right at location <width - 1, height - 1>.
  private IPixel[][] pixels;

  /**
   * Constructor of PpmImage that takes in the string file path of the PpmImage.
   *
   * @param filePath is the string value of the file location
   * @throws FileNotFoundException    if filePath cannot be found
   * @throws CorruptFileException     if filePath is not readable
   * @throws IllegalArgumentException if the filePath is null
   */
  public PpmImage(String filePath)
          throws FileNotFoundException, CorruptFileException, IllegalArgumentException {
    if (filePath == null) {
      throw new IllegalArgumentException("Can't give a null filePath");
    }

    this.readPPM(filePath);
  }

  /**
   * Constructor of PpmImage that takes in an older image.
   *
   * @param oldImage represents an older ppm image
   * @throws IllegalArgumentException if the image is null
   */
  public PpmImage(Image oldImage)
          throws IllegalArgumentException {

    if (oldImage == null) {
      throw new IllegalArgumentException("Can't give a null image");
    }

    this.width = oldImage.getWidth();
    this.height = oldImage.getHeight();
    this.maxColorValue = oldImage.getMaxColorValue();
    this.pixels = new Pixel[this.width][this.height];

    for (int x = 0; x < this.width; x++) {
      for (int y = 0; y < this.height; y++) {
        IPixel p = oldImage.getPixel(x, y);
        this.pixels[x][y] = p;
      }
    }
  }

  private void readPPM(String filePath)
          throws FileNotFoundException, CorruptFileException, IllegalArgumentException {
    if (filePath == null) {
      throw new IllegalArgumentException("Can't have a null file path");
    }
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filePath));
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("File " + filePath + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }
    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new CorruptFileException("Invalid PPM file: plain RAW file should begin with P3");
    }
    try {
      this.width = sc.nextInt();
      this.height = sc.nextInt();
      this.maxColorValue = sc.nextInt();
    } catch (InputMismatchException e) {
      throw new CorruptFileException("Corrupt PPM file: should not have strings");
    } catch (NoSuchElementException e) {
      throw new CorruptFileException("Corrupt PPM file: Incomplete file");
    }

    pixels = new Pixel[this.width][this.height];
    try {
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          int r = sc.nextInt();
          int g = sc.nextInt();
          int b = sc.nextInt();
          Pixel pixel = new Pixel(r, g, b);

          this.pixels[x][y] = pixel;
        }
      }
    } catch (InputMismatchException e) {
      throw new CorruptFileException("Corrupt PPM file: should not have strings");
    } catch (NoSuchElementException e) {
      throw new CorruptFileException("Corrupt PPM file: not enough pixels");
    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getMaxColorValue() {
    return maxColorValue;
  }

  @Override
  public IPixel getPixel(int x, int y) throws IllegalArgumentException {
    int r;
    int g;
    int b;
    IPixel p;

    try {
      p = this.pixels[x][y];
      r = p.getRed();
      g = p.getGreen();
      b = p.getBlue();
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("invalid coordinates for pixel");
    }
    return new Pixel(r, g, b);
  }

  @Override
  public void setPixel(int x, int y, IPixel p) throws IllegalArgumentException {
    if (p == null) {
      throw new IllegalArgumentException("can't have null pixel");
    }
    try {
      this.pixels[x][y] = p;
    } catch (IndexOutOfBoundsException e) {
      throw new IllegalArgumentException("invalid coordinates for pixel");
    }
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();
    out.append("P3").append("\n");

    out.append(this.width).append(" ").append(this.height).append("\n");

    out.append(this.maxColorValue).append("\n");

    for (int y = 0; y < this.getHeight(); y++) {
      for (int x = 0; x < this.getWidth(); x++) {
        out.append(this.pixels[x][y].getRed()).append("\n")
                .append(this.pixels[x][y].getGreen()).append("\n")
                .append(this.pixels[x][y].getBlue()).append("\n");
      }
    }
    return out.toString();
  }


}
