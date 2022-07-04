package controller.commands;


import model.ImageProcessingModel;

/**
 * this class represents a sharpen filtering command.
 */
public class Sharpen extends AbstractFilter implements Command {
  /**
   * the constructor for the filter that takes in the name of the image to filter
   * and the destination mame.
   * @param name the name of the image to filter
   * @param destName the destination name of the image to filter
   */
  public Sharpen(String name, String destName) {
    super(name, destName);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    double[][] kernel = {{-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0},
                         {-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4,0, -1.0 / 8.0},
                         {-1.0 / 8.0, 1.0 / 4.0, 1.0, 1.0 / 4.0, -1.0 / 8.0},
                         {-1.0 / 8.0, 1.0 / 4.0, 1.0 / 4.0, 1.0 / 4,0, -1.0 / 8.0},
                         {-1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0, -1.0 / 8.0}};

    this.filter(model, kernel);
  }
}