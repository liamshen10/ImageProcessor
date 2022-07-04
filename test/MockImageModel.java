import model.ImageProcessingModel;
import model.image.Image;

/**
 * Creates a mock to test in the controller.
 */
public class MockImageModel implements ImageProcessingModel {
  private final StringBuilder log;

  public MockImageModel(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void addImage(String name, Image image) {
    log.append(name).append("\n");
  }

  @Override
  public Image getImage(String name) throws IllegalStateException {
    log.append(name).append("\n");
    return null;
  }
}
