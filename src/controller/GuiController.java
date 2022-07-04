package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.commands.Blur;
import controller.commands.Brighten;
import controller.commands.Downscale;
import controller.commands.GreenComponent;
import controller.commands.GreyScale;
import controller.commands.HorizontalFlip;
import controller.commands.IntensityComponent;
import controller.commands.Load;
import controller.commands.LumaComponent;
import controller.commands.RedComponent;
import controller.commands.Save;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import controller.commands.ValueComponent;
import controller.commands.VerticalFlip;
import model.ImageProcessingModel;
import model.PPMImageProcessingModel;
import model.image.IPixel;
import model.image.Image;
import view.GuiView;

/**
 * Controls the graphical user interface, along with user actions.
 */
public class GuiController implements ActionListener {
  private String fileName;
  private final ImageProcessingModel model;
  private final GuiView view;


  /**
   * Takes in the image processing model, as well as the user actions in order to display
   * view.
   *
   * @param model is the ImageProcessingModel interface
   * @param view  is the view for the graphical user interface
   */
  public GuiController(ImageProcessingModel model, GuiView view) {
    this.model = model;
    this.view = view;
    view.setActionListener(this);
    fileName = "";
  }

  /**
   * constructor for the controller that takes in only a view which it uses as a display.
   *
   * @param view the view that the controller will use to display
   */
  public GuiController(GuiView view) {
    this(new PPMImageProcessingModel(), view);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String action = e.getActionCommand();
    try {
      switch (action) {
        case "Load Image":
          JFileChooser fchooser = new JFileChooser(".");
          FileNameExtensionFilter filter = new FileNameExtensionFilter(
                  "Images", "jpg", "jpeg", "png", "bmp", "ppm");
          fchooser.setFileFilter(filter);
          int retvalue = fchooser.showOpenDialog(null);
          if (retvalue == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fchooser.getSelectedFile();
            String filePath = fileToLoad.getAbsolutePath();
            fileName = fileToLoad.getName();
            try {
              (new Load(filePath, fileName)).run(model);
              view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
              view.setHistogramPanel(model.getImage(fileName));
            } catch (Exception exception) {
              view.showPopUp("Couldn't load image");
            }
          }
          break;
        case "Save file":
          JFileChooser fileChooser = new JFileChooser(".");
          int value = fileChooser.showSaveDialog(null);
          if (value == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            try {
              (new Save(f.getAbsolutePath(), fileName)).run(model);
            } catch (Exception ex) {
              view.showPopUp("please make sure to load in a file and save with valid format");
            }
          }
          break;
        case "Blur":
          (new Blur(fileName, fileName)).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Brighten":
          String input = view.getUserInputBox("increment");
          int increment;
          try {
            increment = Integer.parseInt(input);
            new Brighten(increment, fileName, fileName).run(model);
            view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
            view.setHistogramPanel(model.getImage(fileName));
          } catch (NumberFormatException exception) {
            view.showPopUp("must enter an integer");
          }

          break;
        case "Green Component":
          (new GreenComponent(fileName, fileName)).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Grey Scale":
          new GreyScale(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Horizontal Flip":
          new HorizontalFlip(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Intensity Component":
          new IntensityComponent(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Luma Component":
          new LumaComponent(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Red Component":
          new RedComponent(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Sepia":
          new Sepia(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Sharpen":
          new Sharpen(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Value Component":
          new ValueComponent(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Vertical Flip":
          new VerticalFlip(fileName, fileName).run(model);
          view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
          view.setHistogramPanel(model.getImage(fileName));
          break;
        case "Downscale":
          String width = view.getUserInputBox("New Width");
          String height = view.getUserInputBox("New Height");
          int newWidth;
          int newHeight;
          try {
            newWidth = Integer.parseInt(width);
            newHeight = Integer.parseInt(height);
            if (newWidth <= 0 || newHeight <= 0) {
              view.showPopUp("width and height must be greater than 0");
            } else {
              new Downscale(fileName, fileName, newWidth, newHeight).run(model);
              view.setEditImage(new ImageIcon(makeBufferedImage(model.getImage(fileName))));
              view.setHistogramPanel(model.getImage(fileName));
            }
          } catch (NumberFormatException exception) {
            view.showPopUp("must enter integer for width and height");
          }
          break;
        default:
          // should never get here because there an action even is triggered by an action
      }
    } catch (Exception exception) {
      view.showPopUp("load an image first");
    }
  }

  private static BufferedImage makeBufferedImage(Image image) {
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), 1);
    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        IPixel p = image.getPixel(x, y);
        bufferedImage.setRGB(x, y, (new Color(p.getRed(), p.getGreen(), p.getBlue())).getRGB());
      }
    }
    return bufferedImage;
  }

}
