
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;

import controller.GuiController;
import view.GuiViewImp;
import view.TextView;
import view.TextViewImp;
import controller.ImageProcessingController;
import controller.TextController;


/**
 * Main class that contains the main method to run the application.
 */
public class Main {

  /**
   * Represents the entry point to the application. User can either start the program with
   * no commandline inputs which will then prompt input through the console, or they can
   * give a script.txt in a file and the filepath as a command line argument
   * which will run result in the program running the script.txt then ending.
   * If the script.txt has an error or the file can't be found,
   * the user will be notified and the program will end.
   *
   * @param args is an array of strings that takes in user inputs through command line arguments
   */
  public static void main(String[] args) {

    if (args.length == 0) {
      GuiController controller = new GuiController(new GuiViewImp());
    }

    if (args.length > 0) {
      if (args[0].equals("-file")) {

        Scanner s;
        StringBuilder builder = new StringBuilder();
        String filePath;
        File script = null;
        try {
          filePath = args[1];
          script = new File(filePath);
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println("must provide a file path try again");
          System.exit(1);
        }

        try {
          s = new Scanner(script);
          while (s.hasNextLine()) {
            builder.append(s.nextLine()).append("\n");
          }
          builder.append(" q");
          StringReader input = new StringReader(builder.toString());
          TextView view = new TextViewImp(System.out);
          TextController controller =
                  new ImageProcessingController(input, view);
          controller.start();

        } catch (FileNotFoundException e) {
          System.out.println("Could not find the script.txt file");
        } catch (IllegalStateException e) {
          System.out.println(e.getMessage());
        }
      } else if (args[0].equals("-text")) {
        TextView view = new TextViewImp(System.out);
        TextController controller =
                new ImageProcessingController(new InputStreamReader(System.in), view);
        controller.start();
      }

    }
  }
}
