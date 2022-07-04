package model;

import model.image.Image;

/**
 * This interface represents the operations offered by the ImageProcessingModel, and
 * One object of this model represents one image processor type.
 */
public interface ImageProcessingModel {

  /**
   * Adds an image into a map that is taken in via the model.
   *
   * @param name is a given name of the image being added
   * @param image represents the image being added
   */
  public void addImage(String name, Image image);

  /**
   * Gets an image within the map that has already been added.
   *
   * @param name Represents the string name of the file being called
   * @return an Image that is already within the map
   * @throws IllegalStateException if the name is null, and there is no file being called
   *                               as a result of the name
   */
  public Image getImage(String name) throws IllegalStateException;

}
