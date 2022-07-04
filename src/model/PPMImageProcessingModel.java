package model;

import java.util.Map;
import java.util.TreeMap;

import model.image.Image;

/**
 * Represents a PPMImageProcessingModel that can process ppm images,
 * that implements ImageProcessingModel interface.
 */
public class PPMImageProcessingModel implements ImageProcessingModel {

  private final Map<String, Image> namesToImages;

  /**
   * PPMImageProcessingModel that has an initialized TreeMap.
   */
  public PPMImageProcessingModel() {
    this.namesToImages = new TreeMap<String, Image>();
  }

  @Override
  public void addImage(String name, Image image) {
    namesToImages.put(name, image);
  }

  @Override
  public Image getImage(String name) throws IllegalStateException {
    if (this.namesToImages.get(name) == null) {
      throw new IllegalStateException("there is no image named " + name);
    }
    return this.namesToImages.get(name);

  }
}
