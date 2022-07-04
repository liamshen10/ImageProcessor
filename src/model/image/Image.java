package model.image;

/**
 * This interface represents the operations offered by the image
 * model. One object of the model represents one image.
 */
public interface Image {

  /**
   * Gets the width of the given image.
   *
   * @return width as an int
   */
  public int getWidth();

  /**
   * Gets the height of the given image.
   *
   * @return height as an int
   */
  public int getHeight();

  /**
   * Gets the max color value of an image, usually 255.
   *
   * @return max color value as an int
   */
  public int getMaxColorValue();

  /**
   * Gets a pixel of a certain location using row and column (x, y).
   *
   * @param x int that represents the row in the coordinate grid
   * @param y int that represents the column in the coordinate grid
   * @return the pixel that is located at (x, y).
   * @throws IllegalArgumentException if the x, y are invalid, i.e. that do not exist,
   *                                  or are outside the bounds of the image.
   */
  public IPixel getPixel(int x, int y) throws IllegalArgumentException;

  /**
   * Sets a new pixel, which are the red, green,
   * and blue components, of a certain location: x, y.
   *
   * @param x Int that represents the row in the coordinate grid
   * @param y Int that represents the column in the coordinate grid
   * @param p pixel that represents the new pixel that is being set in x,y.
   * @throws IllegalArgumentException if the x, y are invalid, i.e. that do not exist,
   *                                  or are outside the bounds of the image.
   */
  public void setPixel(int x, int y, IPixel p) throws IllegalArgumentException;

}
