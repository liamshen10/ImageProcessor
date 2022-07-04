package controller.commands;

import model.ImageProcessingModel;

/**
 * this class represents a blur filtering command.
 */
public class Blur extends AbstractFilter implements Command {
  /**
   * constructor for blur command that takes in the name of the image to blur
   * and its destination name.
   *
   * @param name     name of the image
   * @param destName destination name of the image
   */
  public Blur(String name, String destName) {
    super(name, destName);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    double[][] kernel = {{1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0},
                         {1.0 / 8.0, 1.0 / 4.0, 1.0 / 8.0},
                         {1.0 / 16.0, 1.0 / 8.0, 1.0 / 16.0}};

    this.filter(model, kernel);
  }
}
