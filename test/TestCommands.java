import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import controller.commands.BlueComponent;
import controller.commands.Blur;
import controller.commands.Brighten;
import controller.commands.Command;
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
import model.image.CorruptFileException;
import model.image.IPixel;
import model.image.Image;
import model.image.PpmImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Tests the commands that can be used by users.
 */
public class TestCommands {
  private Image image1;
  private ImageProcessingModel model;

  @Before
  public void setUp() throws CorruptFileException, FileNotFoundException {
    image1 = new PpmImage("res/created.ppm");
    model = new PPMImageProcessingModel();
    model.addImage("created", image1);
  }

  @Test
  public void testNullBlueComponent() {
    try {
      Command nullNameBlueComponent = new BlueComponent(null, "blueScaleCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameBlueComponent = new BlueComponent("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothBlueComponent = new BlueComponent(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }


  @Test
  public void testBlueComponent() {

    Command blueComponent = new BlueComponent("created", "blueScaleCreated");
    blueComponent.run(model);
    Image blueScale = model.getImage("blueScaleCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);
        int blue = p.getBlue();
        assertEquals(blue, blueScale.getPixel(x, y).getRed());
        assertEquals(blue, blueScale.getPixel(x, y).getGreen());
        assertEquals(blue, blueScale.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testNullRedComponent() {
    try {
      Command nullNameRedComponent = new RedComponent(null, "redScaleCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameRedComponent = new RedComponent("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothRedComponent = new RedComponent(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testRedComponent() {

    Command redComponent = new RedComponent("created", "redScaleCreated");
    redComponent.run(model);
    Image redScale = model.getImage("redScaleCreated");

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
  public void testNullGreenComponent() {
    try {
      Command nullNameGreenComponent = new GreenComponent(null, "greenScaleCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameGreenComponent = new GreenComponent("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothGreenComponent = new GreenComponent(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testGreenComponent() {

    Command greenComponent = new GreenComponent("created", "greenScaleCreated");
    greenComponent.run(model);
    Image greenScale = model.getImage("greenScaleCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);
        int green = p.getGreen();
        assertEquals(green, greenScale.getPixel(x, y).getRed());
        assertEquals(green, greenScale.getPixel(x, y).getGreen());
        assertEquals(green, greenScale.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testNullBrightenAndDarken() {
    try {
      Command nullNameBrighten = new Brighten(10, null, "brightenCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameBrighten = new Brighten(-10, "created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothBrighten = new Brighten(0, null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testBrighten() {

    Command brighten = new Brighten(50, "created", "brightenCreated");
    brighten.run(model);
    Image brightenImage = model.getImage("brightenCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);
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
  public void testDarken() {

    Command brighten = new Brighten(-100, "created", "darkenCreated");
    brighten.run(model);
    Image brightenImage = model.getImage("darkenCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);
        int newRed = p.getRed() + -100;
        int newGreen = p.getGreen() + -100;
        int newBlue = p.getBlue() + -100;

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
  public void testNullHorizontalFlip() {
    try {
      Command nullNameHorizontalFlip = new HorizontalFlip(null, "hFlipCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameHorizontalFlip = new HorizontalFlip("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothHorizontalFlip = new HorizontalFlip(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testHorizontalFlip() {

    Command hFlip = new HorizontalFlip("created", "hFlipCreated");
    hFlip.run(model);
    Image hFlipImage = model.getImage("hFlipCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {

        int hX = image1.getWidth() - x - 1;

        assertEquals(image1.getPixel(hX, y).getRed(), hFlipImage.getPixel(x, y).getRed());
        assertEquals(image1.getPixel(hX, y).getGreen(), hFlipImage.getPixel(x, y).getGreen());
        assertEquals(image1.getPixel(hX, y).getBlue(), hFlipImage.getPixel(x, y).getBlue());
      }
    }
  }

  @Test
  public void testNullVerticalFlip() {
    try {
      Command nullNameVerticalFlip = new VerticalFlip(null, "vFlipCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameVerticalFlip = new VerticalFlip("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothVerticalFlip = new VerticalFlip(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testVerticalFlip() {

    Command vFlip = new VerticalFlip("created", "vFlipCreated");
    vFlip.run(model);
    Image vFlipImage = model.getImage("vFlipCreated");

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
  public void testNullIntensityComponent() {
    try {
      Command nullNameIntensityComponent =
              new IntensityComponent(null, "intenseCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameIntensityComponent =
              new IntensityComponent("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothIntensityComponent = new IntensityComponent(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testIntensityComponent() {

    Command intensityComponent = new IntensityComponent("created", "intenseCreated");
    intensityComponent.run(model);
    Image intensity = model.getImage("intenseCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getIntensity(), intensity.getPixel(x, y).getIntensity());
      }
    }
  }

  @Test
  public void testNullLumaComponent() {
    try {
      Command nullNameLumaComponent = new LumaComponent(null, "lumaCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameLumaComponent = new LumaComponent("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothLumaComponent = new LumaComponent(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testLumaComponent() {

    Command lumaComponent = new LumaComponent("created", "lumaCreated");
    lumaComponent.run(model);
    Image lumaImage = model.getImage("lumaCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getLuma(), lumaImage.getPixel(x, y).getLuma(), 1.0);
      }
    }
  }

  @Test
  public void testNullValueComponent() {
    try {
      Command nullNameValueComponent = new ValueComponent(null, "valueCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameValueComponent = new ValueComponent("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothValueComponent = new ValueComponent(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }


  @Test
  public void testValueComponent() {

    Command valueComponent = new ValueComponent("created", "valueCreated");
    valueComponent.run(model);
    Image valueImage = model.getImage("valueCreated");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getValue(), valueImage.getPixel(x, y).getValue());
      }
    }
  }

  @Test
  public void testNullSave() {
    try {
      Command nullNameSave = new Save(null, "saveCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameSave = new Save("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothSave = new Save(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testNullLoad() {
    try {
      Command nullNameLoad = new Load(null, "loadCreated");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullDestNameLoad = new Load("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBothLoad = new Load(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testLoad() throws FileNotFoundException {
    Command load = new Load("res/created.ppm", "created");
    load.run(model);
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
  public void testSave() throws IOException {
    Command load = new Load("res/created.ppm", "created");
    load.run(model);
    Command blue = new BlueComponent("created", "created-blue");
    blue.run(model);
    Command save = new Save("test/createdBlue.ppm", "created-blue");
    save.run(model);
    File file = new File("test/createdBlue.ppm");
    assertFalse(file.createNewFile());
  }

  // Assignment 5
  @Test
  public void testGreyScale() {

    Command greyscale = new LumaComponent("created", "created-grey");
    greyscale.run(model);
    Image greyImage = model.getImage("created-grey");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        assertEquals(p.getLuma(), greyImage.getPixel(x, y).getLuma(), 1);
      }
    }
  }

  @Test
  public void testNullGreyScale() {
    try {
      Command nullGreyScale = new GreyScale(null, "created");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullGreyScale = new GreyScale("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullGreyScale = new GreyScale(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testNullGreySepia() {
    try {
      Command nullSepia = new Sepia(null, "created");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullSepia = new Sepia("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullSepia = new Sepia(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  /**
   * Sets any double value within a range of values, 0-255.
   *
   * @param i is a double that is checked if it is within range
   * @return the double itself if within range, 0 if outside lower bound, 255 if upper bound
   */
  public static double clamp(double i) {
    if (i < 0) {
      return 0;
    }
    if (i > 255) {
      return 255;
    }
    return i;
  }

  @Test
  public void testSepia() {

    Command sepia = new Sepia("created", "created-sepia");
    sepia.run(model);
    Image sepiaImage = model.getImage("created-sepia");

    for (int x = 0; x < image1.getWidth(); x++) {
      for (int y = 0; y < image1.getHeight(); y++) {
        IPixel p = image1.getPixel(x, y);

        int red = p.getRed();
        int green = p.getGreen();
        int blue = p.getBlue();
        double newRed = 0.393 * red + 0.769 * green + 0.189 * blue;
        double newGreen = 0.349 * red + 0.686 * green + 0.168 * blue;
        double newBlue = 0.272 * red + 0.534 * green + 0.131 * blue;

        assertEquals(clamp(newRed), sepiaImage.getPixel(x, y).getRed(), 1);
        assertEquals(clamp(newGreen), sepiaImage.getPixel(x, y).getGreen(), 1);
        assertEquals(clamp(newBlue), sepiaImage.getPixel(x, y).getBlue(), 1);
      }
    }
  }


  @Test
  public void testBlur() throws IOException, CorruptFileException {
    ImageProcessingModel model = new PPMImageProcessingModel();
    Command load = new Load("res/created.ppm", "created");
    load.run(model);
    Command blur = new Blur("created", "created-blur");
    blur.run(model);
    Image image = model.getImage("created-blur");
    Image blury = new PpmImage("res/createdBlur.ppm");
    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        IPixel p = image.getPixel(x, y);
        assertEquals(blury.getPixel(x, y).getRed(), image.getPixel(x, y).getRed());
      }
    }
  }

  @Test
  public void testNullBlur() {
    try {
      Command nullBlur = new Blur(null, "created");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBlur = new Blur("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullBlur = new Blur(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  public void testSharpen() throws CorruptFileException, FileNotFoundException {
    ImageProcessingModel model = new PPMImageProcessingModel();
    Command load = new Load("res/created.ppm", "created");
    load.run(model);
    Command sharpen = new Sharpen("created", "created-sharp");
    sharpen.run(model);
    (new Save("res/createdSharp.ppm", "created-sharp")).run(model);
    Image image = model.getImage("created-sharp");
    Image sharp = new PpmImage("res/createdSharp.ppm");
    for (int x = 0; x < image.getWidth(); x++) {
      for (int y = 0; y < image.getHeight(); y++) {
        IPixel p = image.getPixel(x, y);
        assertEquals(sharp.getPixel(x, y).getRed(), image.getPixel(x, y).getRed());
      }
    }


  }

  @Test
  public void testNullSharpen() {
    try {
      Command nullSharpen = new Sharpen(null, "created");
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullSharpen = new Sharpen("created", null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
    try {
      Command nullSharpen = new Sharpen(null, null);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the command is valid, hence failing the invalid test
    }
  }

  @Test
  //testing bmp png and jpeg
  public void testLoadWithOtherFormats() {
    try {
      Command loadPng = new Load("res/created.png", "createdPng");
      loadPng.run(model);
      Image createdPng = model.getImage("createdPng");
      Command loadJpg = new Load("res/created.jpeg", "createdJpg");
      loadJpg.run(model);
      Image createdJpg = model.getImage("createdJpg");
      Command loadBmp = new Load("res/created.bmp", "createdBmp");
      loadBmp.run(model);
      Image createdBmp = model.getImage("createdBmp");
    } catch (Exception e) {
      fail();
    }

  }

  @Test
  //testing bmp png and jpeg
  public void testSaveWithOtherFormats() throws IOException {
    try {
      Command loadPng = new Load("res/created.png", "createdPng");
      loadPng.run(model);
      (new Save("res/new.png", "createdPng")).run(model);
      assertFalse((new File("res/new.png")).createNewFile());

      Command loadJpg = new Load("res/created.jpeg", "createdJpg");
      loadJpg.run(model);
      (new Save("res/new.jpeg", "createdJpg")).run(model);
      assertFalse((new File("res/new.jpeg")).createNewFile());

      Command loadBmp = new Load("res/created.bmp", "createdBmp");
      loadBmp.run(model);
      (new Save("res/new.bmp", "createdBmp")).run(model);
      assertFalse((new File("res/new.bmp")).createNewFile());
    } catch (Exception e) {
      fail();
    }
  }

  @Test
  public void testDownscale() {
    ImageProcessingModel model = new PPMImageProcessingModel();
    Command load = new Load("res/created.ppm", "created");
    load.run(model);
    Command downscale = new Downscale("created", "created-down", 100, 100);
    downscale.run(model);
    assertEquals(100,model.getImage("created-down").getHeight());
    assertEquals(100,model.getImage("created-down").getWidth());
  }
}