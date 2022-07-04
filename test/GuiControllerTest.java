import org.junit.Test;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import controller.GuiController;
import model.ImageProcessingModel;
import model.PPMImageProcessingModel;
import model.image.Image;
import model.image.NonPPMImage;
import view.GuiView;

import static org.junit.Assert.assertEquals;

/**
 * Tests the GUI controller.
 */
public class GuiControllerTest {
  /**
   * mock view class for testing the controller with user inputs.
   */
  static class MockView extends JButton implements GuiView {
    StringBuilder log;

    public MockView(StringBuilder log) {
      this.log = log;
    }

    public void sendCommandToController(String message) {
      this.setActionCommand(message);
      this.doClick();
    }

    @Override
    public void setActionListener(ActionListener listener) {
      this.addActionListener(listener);
    }

    @Override
    public void setEditImage(ImageIcon icon) {
      log.append("setImage").append("\n");
    }

    @Override
    public String getUserInputBox(String message) {
      log.append("requested user input").append("\n");
      return "10";
    }

    @Override
    public void showPopUp(String message) {
      log.append("pop up").append(": ").append(message).append("\n");
    }

    @Override
    public void setHistogramPanel(Image image) throws IOException {
      log.append("set histogram").append("\n");
    }
  }

  @Test
  public void testControllerUserInput() {
    StringBuilder log = new StringBuilder();
    ImageProcessingModel model = new PPMImageProcessingModel();
    MockView view = new MockView(log);
    GuiController controller = new GuiController(model, view);
    view.sendCommandToController("Brighten");
    assertEquals("requested user input\n" +
            "pop up: load an image first\n", log.toString());
    model.addImage("", new NonPPMImage(100, 100));
    view.sendCommandToController("Brighten");
    assertEquals("requested user input\n" +
            "pop up: load an image first\n" +
            "requested user input\n" +
            "setImage\n" +
            "set histogram\n", log.toString());
  }

}
