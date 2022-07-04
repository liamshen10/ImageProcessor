package model.image;

/**
 * this interface represents an rgb pixel.
 */
public interface IPixel {
  /**
   * Gets the red value in a pixel.
   *
   * @return red value in a pixel
   */
  public int getRed();

  /**
   * Sets the red value in a pixel.
   *
   * @param red represents a new red value to set it as
   * @throws IllegalArgumentException if the new red value is lower than 0 or above 255
   */
  public void setRed(int red) throws IllegalArgumentException;

  /**
   * Gets the green value in a pixel.
   *
   * @return green value in a pixel
   */
  public int getGreen();

  /**
   * Sets the green value in a pixel.
   *
   * @param green represents a new green value to set it as
   * @throws IllegalArgumentException if the new green value is lower than 0 or above 255
   */
  public void setGreen(int green) throws IllegalArgumentException;

  /**
   * Gets the blue value in a pixel.
   *
   * @return blue value in a pixel
   */
  public int getBlue();

  /**
   * Sets the blue value in a pixel.
   *
   * @param blue represents a new red value to set it as
   * @throws IllegalArgumentException if the new blue value is lower than 0 or above 255
   */
  public void setBlue(int blue) throws IllegalArgumentException;

  /**
   * Represents the luma for a given pixel.
   *
   * @return double value that is the luma of the pixel
   */
  public double getLuma();

  /**
   * Returns the highest RGB field of a pixel, representing value.
   *
   * @return the highest int RGB field value of a pixel
   */
  public int getValue();

  /**
   * Represents the average of the three RGB fields within a pixel.
   *
   * @return the average int value of the RBG fields in a pixel.
   */
  public int getIntensity();
}
