import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import model.PPMImageProcessingModel;
import model.image.CorruptFileException;
import model.image.Image;
import model.image.PpmImage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the PPMImageProcessingModel and the methods.
 */
public class TestPPMImageProcessingModel {

  private PPMImageProcessingModel model;
  private Map<String, Image> map;

  @Before
  public void init() {
    model = new PPMImageProcessingModel();
  }

  @Test
  public void testInvalidGetImage() {
    Image image;
    Image image1;
    try {
      image = new PpmImage("res/created.ppm");
      image1 = new PpmImage(image);
    } catch (CorruptFileException e) {
      throw new RuntimeException(e);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    model.addImage("created.ppm", image);
    model.addImage("pog", image1);
    try {
      model.getImage("DNE");
      fail();
    } catch (IllegalStateException e) {
      // If it reaches this code, the name is valid, hence failing the invalid test
    }
    try {
      model.getImage("hello");
      fail();
    } catch (IllegalStateException e) {
      // If it reaches this code, the name is valid, hence failing the invalid test
    }
    try {
      model.getImage("Pog");
      fail();
    } catch (IllegalStateException e) {
      // If it reaches this code, the name is valid, hence failing the invalid test
    }
    try {
      model.getImage("Created.ppm");
      fail();
    } catch (IllegalStateException e) {
      // If it reaches this code, the name is valid, hence failing the invalid test
    }
  }

  @Test
  public void testAddAndGetImage() {
    Image image;
    Image image1;
    try {
      image = new PpmImage("res/created.ppm");
      image1 = new PpmImage(image);
    } catch (CorruptFileException e) {
      throw new RuntimeException(e);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    model.addImage("created.ppm", image);
    model.addImage("pog", image1);
    assertEquals(image, model.getImage("created.ppm"));
    assertEquals(image1, model.getImage("pog"));
  }
}
