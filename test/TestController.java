import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import model.image.IPixel;
import view.TextView;
import view.TextViewImp;
import controller.ImageProcessingController;
import controller.TextController;
import model.ImageProcessingModel;
import model.PPMImageProcessingModel;
import model.image.CorruptFileException;
import model.image.Image;
import model.image.PpmImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Tests the controller of the image processor.
 */
public class TestController {
  private ImageProcessingModel model;
  private StringBuilder output;
  private TextView view;

  private Readable input;
  private ImageProcessingController controller;

  @Before
  public void setUp() throws CorruptFileException, FileNotFoundException {
    output = new StringBuilder();
    view = new TextViewImp(output);
    model = new PPMImageProcessingModel();
  }

  @Test
  public void testInvalidCommand() {
    input = new StringReader("invalid-command invalid-param1 invalid-param2 q");
    controller = new ImageProcessingController(input, view);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Invalid Command, please reenter \n" +
            "Invalid Command, please reenter \n" +
            "Invalid Command, please reenter \n" +
            "Quiting program \n", output.toString());
  }

  @Test
  public void testQuitBeginning() {
    input = new StringReader("q");
    controller = new ImageProcessingController(input, view);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());
  }

  @Test
  public void testQuitAfterCommand() {
    input = new StringReader("load res/created.ppm created q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());
  }

  @Test
  public void testBlueComponent() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "blue-component created created-blue q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    Image created = new PpmImage("res/created.ppm");
    Image blueScale = model.getImage("created-blue");

    for (int x = 0; x < created.getWidth(); x++) {
      for (int y = 0; y < created.getHeight(); y++) {
        IPixel p = created.getPixel(x, y);
        int blue = p.getBlue();
        assertEquals(blue, blueScale.getPixel(x, y).getRed());
        assertEquals(blue, blueScale.getPixel(x, y).getGreen());
        assertEquals(blue, blueScale.getPixel(x, y).getBlue());
      }
    }
    //test if image was made correctly
  }

  @Test
  public void testBrighten() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "brighten 50 created created-bright q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image brightenImage = model.getImage("created-bright");
    Image image = new PpmImage("res/created.ppm");

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        IPixel p = image.getPixel(x, y);
        int newRed = p.getRed() + 50;
        int newGreen = p.getGreen() + 50;
        int newBlue = p.getBlue() + 50;

        if (newRed < 0) {
          newRed = 0;
        }
        if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue < 0) {
          newBlue = 0;
        }
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }

        assertEquals(newRed, brightenImage.getPixel(x, y).getRed());
        assertEquals(newGreen, brightenImage.getPixel(x, y).getGreen());
        assertEquals(newBlue, brightenImage.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testGreenComponent() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "green-component created created-green q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image greenScale = model.getImage("created-green");
    Image image = new PpmImage("res/created.ppm");

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        IPixel p = image.getPixel(x, y);
        int green = p.getGreen();
        assertEquals(green, greenScale.getPixel(x, y).getRed());
        assertEquals(green, greenScale.getPixel(x, y).getGreen());
        assertEquals(green, greenScale.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testHorizontalFlip() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "horizontal-flip created created-hflip q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image hFlipImage = model.getImage("created-hflip");
    Image image = new PpmImage("res/created.ppm");

    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {

        int hX = image.getWidth() - x - 1;

        assertEquals(image.getPixel(hX, y).getRed(), hFlipImage.getPixel(x, y).getRed());
        assertEquals(image.getPixel(hX, y).getGreen(), hFlipImage.getPixel(x, y).getGreen());
        assertEquals(image.getPixel(hX, y).getBlue(), hFlipImage.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testIntensityComponent() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "intensity-component created created-int q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image intensity = model.getImage("created-int");
    Image image1 = new PpmImage("res/created.ppm");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getIntensity(), intensity.getPixel(x, y).getIntensity());
      }
    }
  }

  @Test
  public void testLoad() throws FileNotFoundException {
    input = new StringReader("load res/created.ppm created q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image created = model.getImage("created");
    Scanner sc = new Scanner(new FileInputStream("res/created.ppm"));
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append("\n");
      }
    }
    assertEquals(builder.toString(), created.toString());

  }

  @Test
  public void testLumaComponent() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "luma-component created created-luma q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image lumaImage = model.getImage("created-luma");
    Image image1 = new PpmImage("res/created.ppm");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getLuma(), lumaImage.getPixel(x, y).getLuma(), 1.0);
      }
    }
  }

  @Test
  public void testRedComponent() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "red-component created created-red q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    //test if image was made correctly

    Image redScale = model.getImage("created-red");
    Image image1 = new PpmImage("res/created.ppm");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);
        int red = p.getRed();
        assertEquals(red, redScale.getPixel(x, y).getRed());
        assertEquals(red, redScale.getPixel(x, y).getGreen());
        assertEquals(red, redScale.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testSave() throws IOException {
    input = new StringReader("load res/created.ppm created " +
            "blue-component created created-blue " +
            "save res/createdBlue.ppm created-blue q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());

    File file = new File("res/createdBlue.ppm");
    assertFalse(file.createNewFile());

    Image blueImage = model.getImage("created-blue");
    StringBuilder modelBlue = new StringBuilder();
    modelBlue.append("P3").append("\n");
    modelBlue.append(blueImage.getHeight()).append(" ").append(blueImage.getWidth()).append("\n");
    modelBlue.append(blueImage.getMaxColorValue()).append("\n");

    for (int y = 0; y < blueImage.getWidth(); y++) {
      for (int x = 0; x < blueImage.getHeight(); x++) {
        IPixel p = blueImage.getPixel(x, y);
        modelBlue.append(p.getRed()).append("\n");
        modelBlue.append(p.getGreen()).append("\n");
        modelBlue.append(p.getBlue()).append("\n");
      }
    }
    StringBuilder fileBlue = new StringBuilder();
    Scanner s = new Scanner(new FileInputStream("res/createdBlue.ppm"));
    while (s.hasNext()) {
      String next = s.nextLine();
      if (next.charAt(0) != '#') {
        fileBlue.append(next).append("\n");
      }
    }
    assertEquals(modelBlue.toString(), fileBlue.toString());

  }


  @Test
  public void testValueComponent() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "value-component created created-value " +
            "q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());
    // test if image was made correctly

    Image valueImage = model.getImage("created-value");
    Image image1 = new PpmImage("res/created.ppm");


    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getValue(), valueImage.getPixel(x, y).getValue());
      }
    }
  }

  @Test
  public void testVerticalFlip() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "vertical-flip created created-vflip " +
            "q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());
    // test if image was made correctly
    Image vFlipImage = model.getImage("created-vflip");
    Image image1 = new PpmImage("res/created.ppm");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {

        int hY = image1.getHeight() - y - 1;

        assertEquals(image1.getPixel(x, hY).getRed(), vFlipImage.getPixel(x, y).getRed());
        assertEquals(image1.getPixel(x, hY).getGreen(), vFlipImage.getPixel(x, y).getGreen());
        assertEquals(image1.getPixel(x, hY).getBlue(), vFlipImage.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testInput() {
    StringBuilder log = new StringBuilder();
    StringBuilder out = new StringBuilder();
    StringReader reader = new StringReader("load res/created.ppm created q");
    MockImageModel model = new MockImageModel(log);
    TextView view = new TextViewImp(out);
    TextController controller = new ImageProcessingController(reader, view, model);
    controller.start();
    assertEquals("created\n", log.toString());
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", out.toString());
  }

  @Test
  public void testSharpen() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "sharpen created created-sharp " +
            "q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());
    // test if image was made correctly
    Image blur = model.getImage("created-sharp");
    Image image1 = new PpmImage("res/createdSharp.ppm");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {

        assertEquals(image1.getPixel(x, y).getRed(), blur.getPixel(x, y).getRed());
        assertEquals(image1.getPixel(x, y).getGreen(), blur.getPixel(x, y).getGreen());
        assertEquals(image1.getPixel(x, y).getBlue(), blur.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testBlur() throws CorruptFileException, FileNotFoundException {
    input = new StringReader("load res/created.ppm created " +
            "blur created created-blur " +
            "q");
    controller = new ImageProcessingController(input, view, model);
    controller.start();
    assertEquals("Welcome to the image processing program \n" +
            " \n" +
            "Commands:\n" +
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
            "blur image-name dest-image-name \n" +
            " \n" +
            "sharpen image-name dest-image-name \n" +
            " \n" +
            "Quiting program \n", output.toString());
    // test if image was made correctly
    Image blur = model.getImage("created-blur");
    Image image1 = new PpmImage("res/createdBlur.ppm");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {

        assertEquals(image1.getPixel(x, y).getRed(), blur.getPixel(x, y).getRed());
        assertEquals(image1.getPixel(x, y).getGreen(), blur.getPixel(x, y).getGreen());
        assertEquals(image1.getPixel(x, y).getBlue(), blur.getPixel(x, y).getBlue());
      }
    }
  }
}