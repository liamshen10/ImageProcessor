package controller.commands;

import model.ImageProcessingModel;

/**
 * This interface represents commands that can be done by
 * a controller for the image processor.
 */
public interface Command {

  /**
   * Allows for image transformation and editing using user inputs
   * from the controller.
   *
   * @throws IllegalStateException if the command couldn't be executed properly
   */
  public void run(ImageProcessingModel model) throws IllegalStateException;

}
