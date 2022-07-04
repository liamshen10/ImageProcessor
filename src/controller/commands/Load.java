package controller.commands;

import java.io.IOException;

import model.ImageProcessingModel;
import model.image.CorruptFileException;
import model.image.Image;
import model.image.PpmImage;
import model.image.NonPPMImage;

/**
 * class Load that loads a given file.
 */
public class Load extends AbstractFileCommand implements Command {


  /**
   * constructor that takes in a filePath and name for the command.
   *
   * @param filePath path of the file
   * @param name     name of the file
   */
  public Load(String filePath, String name) {
    super(filePath, name);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    Image image;

    try {
      if (this.getFileExtension(filePath).equals("ppm")) {
        image = new PpmImage(filePath);
      } else {
        image = new NonPPMImage(filePath);
      }

    } catch (IOException | CorruptFileException e) {
      throw new IllegalStateException(e.getMessage());

    }
    model.addImage(name, image);

  }
}
