package controller.commands;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.ImageProcessingModel;
import model.image.IPixel;
import model.image.Image;

/**
 * class Save that saves a given file.
 */
public class Save extends AbstractFileCommand implements Command {


  /**
   * constructor that takes in a filePath and name for the command.
   *
   * @param filePath path of the file
   * @param name     name of the file
   */
  public Save(String filePath, String name) {
    super(filePath, name);
  }

  @Override
  public void run(ImageProcessingModel model) throws IllegalStateException {
    Image image = model.getImage(name);

    try {
      if (this.getFileExtension(filePath).equals("ppm")) {
        this.createPPMFile(image);
      } else {
        this.createOtherImageFile(image);
      }

    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  private void createOtherImageFile(Image image) throws IOException {
    String format = this.getFileExtension(filePath);
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), 1);

    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        IPixel p = image.getPixel(x, y);
        Color c = new Color(p.getRed(), p.getGreen(), p.getBlue());
        bufferedImage.setRGB(x, y, c.getRGB());
      }
    }
    boolean created = ImageIO.write(bufferedImage, format, new File(filePath));

    if (!created) {
      throw new IOException("couldn't make the file, unrecognized format");
    }
  }


  private void createPPMFile(Image image) throws IOException {
    StringBuilder out = new StringBuilder();
    out.append("P3").append("\n");

    out.append(image.getWidth()).append(" ").append(image.getHeight()).append("\n");

    out.append(image.getMaxColorValue()).append("\n");

    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        out.append(image.getPixel(x, y).getRed()).append("\n")
                .append(image.getPixel(x, y).getGreen()).append("\n")
                .append(image.getPixel(x, y).getBlue()).append("\n");
      }
    }
    File file = new File(filePath);
    file.createNewFile();
    FileWriter writer = new FileWriter(file, false);
    writer.write(out.toString());
    writer.close();
  }
}
