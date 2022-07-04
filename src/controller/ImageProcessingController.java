package controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;

import controller.commands.Blur;
import controller.commands.GreyScale;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import view.TextView;
import controller.commands.BlueComponent;
import controller.commands.Brighten;
import controller.commands.Command;
import controller.commands.GreenComponent;
import controller.commands.HorizontalFlip;
import controller.commands.IntensityComponent;
import controller.commands.Load;
import controller.commands.LumaComponent;
import controller.commands.RedComponent;
import controller.commands.Save;
import controller.commands.ValueComponent;
import controller.commands.VerticalFlip;
import model.ImageProcessingModel;
import model.PPMImageProcessingModel;

/**
 * public class ImageProcessingController implements TextController,
 * and represents the controller used for user string inputs.
 */
public class ImageProcessingController implements TextController {
  private final Readable input;
  private final ImageProcessingModel model;

  private final TextView view;
  private final Map<String, Function<Scanner, Command>> commands;

  /**
   * Constructor that takes in a readable user input, and view,
   * and model is initialized using its default constructor.
   *
   * @param input is the user input
   * @param view  is the view design
   */
  public ImageProcessingController(Readable input, TextView view) {
    this(input, view, new PPMImageProcessingModel());
  }

  /**
   * Constructor that takes in a readable user input, view, and
   * model that is initialized using its default constructor.
   *
   * @param input is the user input
   * @param view  is the view design
   * @param model is the model used for the controller
   */
  public ImageProcessingController(Readable input, TextView view, ImageProcessingModel model) {
    this.input = input;
    this.view = view;
    this.model = model;

    this.commands = new TreeMap<String, Function<Scanner, Command>>();
    commands.put("load", s -> new Load(s.next(), s.next()));
    commands.put("save", s -> new Save(s.next(), s.next()));
    commands.put("red-component", s -> new RedComponent(s.next(), s.next()));
    commands.put("blue-component", s -> new BlueComponent(s.next(), s.next()));
    commands.put("green-component", s -> new GreenComponent(s.next(), s.next()));
    commands.put("value-component", s -> new ValueComponent(s.next(), s.next()));
    commands.put("luma-component", s -> new LumaComponent(s.next(), s.next()));
    commands.put("intensity-component", s -> new IntensityComponent(s.next(), s.next()));
    commands.put("horizontal-flip", s -> new HorizontalFlip(s.next(), s.next()));
    commands.put("vertical-flip", s -> new VerticalFlip(s.next(), s.next()));
    commands.put("brighten", s -> new Brighten(s.nextInt(), s.next(), s.next()));
    commands.put("greyscale", s -> new GreyScale(s.next(), s.next()));
    commands.put("sepia", s -> new Sepia(s.next(), s.next()));
    commands.put("blur", s -> new Blur(s.next(), s.next()));
    commands.put("sharpen", s -> new Sharpen(s.next(), s.next()));
  }

  private void renderMessageToView(String message) throws IllegalStateException {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      throw new IllegalStateException("View could not render message");
    }
  }

  private void displayCommands() {
    this.renderMessageToView("Commands:\n" +
            "\n" +
            "load image-path image-name\n" +
            "\n" +
            "save image-path image-name\n" +
            "\n" +
            "red-component image-name dest-image-name\n" +
            "\n" +
            "blue-component image-name dest-image-name\n" +
            "\n" +
            "green-component image-name dest-image-name\n" +
            "\n" +
            "value-component image-name dest-image-name\n" +
            "\n" +
            "luma-component image-name dest-image-name\n" +
            "\n" +
            "value-component image-name dest-image-name\n" +
            "\n" +
            "intensity-component image-name dest-image-name\n" +
            "\n" +
            "horizontal-flip image-name dest-image-name\n" +
            "\n" +
            "vertical-flip image-name dest-image-name\n" +
            "\n" +
            "brighten increment image-name dest-image-name \n" +
            "\n" +
            "greyscale image-name dest-image-name \n" +
            "\n" +
            "sepia image-name dest-image-name \n" +
            "\n" +
            "blur image-name dest-image-name \n " +
            "\n" +
            "sharpen image-name dest-image-name \n " +
            "\n");
  }

  @Override
  public void start() throws IllegalStateException {

    this.renderMessageToView("Welcome to the image processing program \n \n");
    this.displayCommands();

    Scanner in = new Scanner(input);
    String next;
    while (true) {
      try {
        next = in.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Readable has no more inputs available");
      }

      if (next.equalsIgnoreCase("q") || next.equalsIgnoreCase("quit")) {
        this.renderMessageToView("Quiting program \n");
        return;
      }
      Function<Scanner, Command> cmdObj = commands.getOrDefault(next, null);
      if (cmdObj == null) {
        this.renderMessageToView("Invalid Command, please reenter \n");
      } else {
        Command command;
        try {
          command = cmdObj.apply(in);
          command.run(model);
        } catch (InputMismatchException e) {
          this.renderMessageToView("Invalid parameters \n");
          in.next();

        } catch (NoSuchElementException e) {
          throw new IllegalStateException("Readable has no more inputs available");

        } catch (IllegalStateException e) {
          this.renderMessageToView("Error: " + e.getMessage() + "\n");
          this.renderMessageToView("Please try again \n");
        }
      }
    }
  }
}
