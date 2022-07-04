import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import model.image.CorruptFileException;
import model.image.Image;
import model.image.Pixel;
import model.image.PpmImage;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests methods run on a PPM image.
 */
public class PpmImageTest {

  private Image image1;
  private Image image2;

  @Before
  public void init() throws CorruptFileException, FileNotFoundException {
    image1 = new PpmImage("res/created.ppm");
    image2 = new PpmImage(image1);
  }

  @Test
  public void testInvalidConstructors() {
    try {
      Image image3 = new PpmImage("test/model/null.ppm");
      Image image4 = new PpmImage(image3);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the image is valid, hence failing the invalid test
    } catch (CorruptFileException e) {
      // If it reaches this code, the image is valid, hence failing the invalid test
    } catch (FileNotFoundException e) {
      // If it reaches this code, the image is valid, hence failing the invalid test
    }
  }

  @Test
  public void testInvalidGetPixel() {
    try {
      image1.getPixel(-1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(0, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(image1.getWidth(), 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(0, image1.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(image1.getWidth(), image1.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(image1.getWidth(), -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.getPixel(-1, image1.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testInvalidSetPixel() {
    try {
      image1.setPixel(-1, 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(0, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(-1, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(image1.getWidth(), 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(0, image1.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(image1.getWidth(), image1.getHeight(),
              new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(image1.getWidth(), -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      image1.setPixel(-1, image1.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }


  @Test
  public void testGetWidth() {
    assertEquals(3, image1.getWidth());
    assertEquals(3, image2.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(3, image1.getHeight());
    assertEquals(3, image2.getHeight());
  }

  @Test
  public void testGetMaxColorValue() {
    assertEquals(255, image1.getMaxColorValue());
    assertEquals(255, image2.getMaxColorValue());
  }

  @Test
  public void testGetPixel() {
    assertEquals(255, image1.getPixel(0, 0).getRed());
    assertEquals(0, image1.getPixel(0, 0).getGreen());
    assertEquals(0, image1.getPixel(0, 0).getBlue());
    assertEquals(243, image1.getPixel(1, 2).getRed());
    assertEquals(111, image1.getPixel(1, 2).getGreen());
    assertEquals(135, image1.getPixel(1, 2).getBlue());
    assertEquals(255, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getRed());
    assertEquals(255, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getGreen());
    assertEquals(255, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getBlue());

    assertEquals(255, image2.getPixel(0, 0).getRed());
    assertEquals(0, image2.getPixel(0, 0).getGreen());
    assertEquals(0, image2.getPixel(0, 0).getBlue());
    assertEquals(243, image2.getPixel(1, 2).getRed());
    assertEquals(111, image2.getPixel(1, 2).getGreen());
    assertEquals(135, image2.getPixel(1, 2).getBlue());
    assertEquals(255, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getRed());
    assertEquals(255, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getGreen());
    assertEquals(255, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getBlue());


  }

  @Test
  public void testSetPixel() {
    assertEquals(255, image1.getPixel(0, 0).getRed());
    assertEquals(0, image1.getPixel(0, 0).getGreen());
    assertEquals(0, image1.getPixel(0, 0).getBlue());

    image1.setPixel(0, 0, new Pixel(69, 21, 42));

    assertEquals(69, image1.getPixel(0, 0).getRed());
    assertEquals(21, image1.getPixel(0, 0).getGreen());
    assertEquals(42, image1.getPixel(0, 0).getBlue());

    assertEquals(243, image1.getPixel(1, 2).getRed());
    assertEquals(111, image1.getPixel(1, 2).getGreen());
    assertEquals(135, image1.getPixel(1, 2).getBlue());

    image1.setPixel(1, 2, new Pixel(0, 255, 0));

    assertEquals(0, image1.getPixel(1, 2).getRed());
    assertEquals(255, image1.getPixel(1, 2).getGreen());
    assertEquals(0, image1.getPixel(1, 2).getBlue());

    assertEquals(255, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getRed());
    assertEquals(255, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getGreen());
    assertEquals(255, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getBlue());

    image1.setPixel(image1.getWidth() - 1, image1.getHeight() - 1,
            new Pixel(46, 21, 7));

    assertEquals(46, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getRed());
    assertEquals(21, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getGreen());
    assertEquals(7, image1.getPixel(image1.getWidth() - 1,
            image1.getHeight() - 1).getBlue());

    assertEquals(255, image2.getPixel(0, 0).getRed());
    assertEquals(0, image2.getPixel(0, 0).getGreen());
    assertEquals(0, image2.getPixel(0, 0).getBlue());

    image2.setPixel(0, 0, new Pixel(69, 21, 42));

    assertEquals(69, image2.getPixel(0, 0).getRed());
    assertEquals(21, image2.getPixel(0, 0).getGreen());
    assertEquals(42, image2.getPixel(0, 0).getBlue());

    assertEquals(243, image2.getPixel(1, 2).getRed());
    assertEquals(111, image2.getPixel(1, 2).getGreen());
    assertEquals(135, image2.getPixel(1, 2).getBlue());

    image2.setPixel(1, 2, new Pixel(0, 255, 0));

    assertEquals(0, image2.getPixel(1, 2).getRed());
    assertEquals(255, image2.getPixel(1, 2).getGreen());
    assertEquals(0, image2.getPixel(1, 2).getBlue());

    assertEquals(255, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getRed());
    assertEquals(255, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getGreen());
    assertEquals(255, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getBlue());

    image2.setPixel(image2.getWidth() - 1, image2.getHeight() - 1,
            new Pixel(46, 21, 7));

    assertEquals(46, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getRed());
    assertEquals(21, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getGreen());
    assertEquals(7, image2.getPixel(image2.getWidth() - 1,
            image2.getHeight() - 1).getBlue());
  }

}