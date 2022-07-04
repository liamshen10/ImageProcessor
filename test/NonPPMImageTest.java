import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import model.image.Image;
import model.image.NonPPMImage;
import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests methods run on a non PPM image.
 */
public class NonPPMImageTest {

  private Image imageBMP;
  private Image imageJPEG;

  private Image imagePNG;

  @Before
  public void init() throws IllegalArgumentException, IOException {
    imageBMP = new NonPPMImage("res/BMPsample.bmp");
    imageJPEG = new NonPPMImage("res/JPEGsample.jpg");
    imagePNG = new NonPPMImage("res/PNGsample.png");
  }

  @Test
  public void testInvalidConstructors() {
    try {
      Image imageInvalid = new NonPPMImage("res/created.ppm");
      fail();
    } catch (IOException e) {
      // If it reaches this, the image output is valid, hence failing the invalid test
    } catch (IllegalArgumentException e) {
      // If it reaches this, the image arg is valid, hence failing the invalid test
    }

    try {
      Image imageNull = new NonPPMImage(null);
      fail();
    } catch (IOException e) {
      // If it reaches this, the image output is valid, hence failing the invalid test
    } catch (IllegalArgumentException e) {
      // If it reaches this, the image arg is valid, hence failing the invalid test
    }
  }

  @Test
  public void testJPGInvalidGetPixel() {
    try {
      imageJPEG.getPixel(-1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(0, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(imageJPEG.getWidth(), 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(0, imageJPEG.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(imageJPEG.getWidth(), imageJPEG.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(imageJPEG.getWidth(), -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.getPixel(-1, imageJPEG.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testPNGInvalidGetPixel() {
    try {
      imagePNG.getPixel(-1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(0, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(imagePNG.getWidth(), 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(0, imagePNG.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(imagePNG.getWidth(), imagePNG.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(imagePNG.getWidth(), -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.getPixel(-1, imagePNG.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testBMPInvalidGetPixel() {
    try {
      imageBMP.getPixel(-1, 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(0, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(-1, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(imageBMP.getWidth(), 0);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(0, imageBMP.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(imageBMP.getWidth(), imageBMP.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(imageBMP.getWidth(), -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.getPixel(-1, imageBMP.getHeight());
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testJPEGInvalidSetPixel() {
    try {
      imageJPEG.setPixel(-1, 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(0, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(-1, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(imageJPEG.getWidth(), 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(0, imageJPEG.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(imageJPEG.getWidth(), imageJPEG.getHeight(),
              new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(imageJPEG.getWidth(), -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageJPEG.setPixel(-1, imageJPEG.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testPNGInvalidSetPixel() {
    try {
      imagePNG.setPixel(-1, 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(0, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(-1, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(imagePNG.getWidth(), 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(0, imagePNG.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(imagePNG.getWidth(), imagePNG.getHeight(),
              new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(imagePNG.getWidth(), -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imagePNG.setPixel(-1, imagePNG.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testBMPInvalidSetPixel() {
    try {
      imageBMP.setPixel(-1, 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(0, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(-1, -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(imageBMP.getWidth(), 0, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(0, imageBMP.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(imageBMP.getWidth(), imageBMP.getHeight(),
              new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(imageBMP.getWidth(), -1, new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
    try {
      imageBMP.setPixel(-1, imageBMP.getHeight(), new Pixel(100, 100, 100));
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the coordinates are valid, hence failing the invalid test
    }
  }

  @Test
  public void testGetWidth() {
    assertEquals(225, imageJPEG.getWidth());
    assertEquals(820, imagePNG.getWidth());
    assertEquals(256, imageBMP.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(225, imageJPEG.getHeight());
    assertEquals(835, imagePNG.getHeight());
    assertEquals(256, imageBMP.getHeight());
  }

  @Test
  public void testGetMaxColorValue() {
    assertEquals(255, imageJPEG.getMaxColorValue());
    assertEquals(255, imagePNG.getMaxColorValue());
    assertEquals(255, imageBMP.getMaxColorValue());
  }

  @Test
  public void testGetPixel() {
    assertEquals(255, imageJPEG.getPixel(0, 0).getRed());
    assertEquals(255, imageJPEG.getPixel(0, 0).getGreen());
    assertEquals(255, imageJPEG.getPixel(0, 0).getBlue());
    assertEquals(210, imageJPEG.getPixel(50, 187).getRed());
    assertEquals(149, imageJPEG.getPixel(50, 187).getGreen());
    assertEquals(84, imageJPEG.getPixel(50, 187).getBlue());
    assertEquals(255, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getRed());
    assertEquals(255, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getGreen());
    assertEquals(255, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getBlue());

    assertEquals(248, imagePNG.getPixel(0, 0).getRed());
    assertEquals(248, imagePNG.getPixel(0, 0).getGreen());
    assertEquals(248, imagePNG.getPixel(0, 0).getBlue());
    assertEquals(246, imagePNG.getPixel(50, 187).getRed());
    assertEquals(246, imagePNG.getPixel(50, 187).getGreen());
    assertEquals(246, imagePNG.getPixel(50, 187).getBlue());
    assertEquals(247, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getRed());
    assertEquals(247, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getGreen());
    assertEquals(247, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getBlue());

    assertEquals(255, imageBMP.getPixel(0, 0).getRed());
    assertEquals(255, imageBMP.getPixel(0, 0).getGreen());
    assertEquals(255, imageBMP.getPixel(0, 0).getBlue());
    assertEquals(255, imageBMP.getPixel(50, 187).getRed());
    assertEquals(255, imageBMP.getPixel(50, 187).getGreen());
    assertEquals(255, imageBMP.getPixel(50, 187).getBlue());
    assertEquals(255, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getRed());
    assertEquals(255, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getGreen());
    assertEquals(255, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getBlue());
  }

  @Test
  public void testSetPixel() {
    assertEquals(255, imageJPEG.getPixel(0, 0).getRed());
    assertEquals(255, imageJPEG.getPixel(0, 0).getGreen());
    assertEquals(255, imageJPEG.getPixel(0, 0).getBlue());

    imageJPEG.setPixel(0, 0, new Pixel(69, 21, 42));

    assertEquals(69, imageJPEG.getPixel(0, 0).getRed());
    assertEquals(21, imageJPEG.getPixel(0, 0).getGreen());
    assertEquals(42, imageJPEG.getPixel(0, 0).getBlue());

    assertEquals(210, imageJPEG.getPixel(50, 187).getRed());
    assertEquals(149, imageJPEG.getPixel(50, 187).getGreen());
    assertEquals(84, imageJPEG.getPixel(50, 187).getBlue());

    imageJPEG.setPixel(50, 187, new Pixel(0, 255, 0));

    assertEquals(0, imageJPEG.getPixel(50, 187).getRed());
    assertEquals(255, imageJPEG.getPixel(50, 187).getGreen());
    assertEquals(0, imageJPEG.getPixel(50, 187).getBlue());

    assertEquals(255, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getRed());
    assertEquals(255, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getGreen());
    assertEquals(255, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getBlue());

    imageJPEG.setPixel(imageJPEG.getWidth() - 1, imageJPEG.getHeight() - 1,
            new Pixel(46, 21, 7));

    assertEquals(46, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getRed());
    assertEquals(21, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getGreen());
    assertEquals(7, imageJPEG.getPixel(imageJPEG.getWidth() - 1,
            imageJPEG.getHeight() - 1).getBlue());

    assertEquals(248, imagePNG.getPixel(0, 0).getRed());
    assertEquals(248, imagePNG.getPixel(0, 0).getGreen());
    assertEquals(248, imagePNG.getPixel(0, 0).getBlue());

    imagePNG.setPixel(0, 0, new Pixel(69, 21, 42));

    assertEquals(69, imagePNG.getPixel(0, 0).getRed());
    assertEquals(21, imagePNG.getPixel(0, 0).getGreen());
    assertEquals(42, imagePNG.getPixel(0, 0).getBlue());

    assertEquals(246, imagePNG.getPixel(50, 187).getRed());
    assertEquals(246, imagePNG.getPixel(50, 187).getGreen());
    assertEquals(246, imagePNG.getPixel(50, 187).getBlue());

    imagePNG.setPixel(50, 187, new Pixel(0, 255, 0));

    assertEquals(0, imagePNG.getPixel(50, 187).getRed());
    assertEquals(255, imagePNG.getPixel(50, 187).getGreen());
    assertEquals(0, imagePNG.getPixel(50, 187).getBlue());

    assertEquals(247, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getRed());
    assertEquals(247, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getGreen());
    assertEquals(247, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getBlue());

    imagePNG.setPixel(imagePNG.getWidth() - 1, imagePNG.getHeight() - 1,
            new Pixel(46, 21, 7));

    assertEquals(46, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getRed());
    assertEquals(21, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getGreen());
    assertEquals(7, imagePNG.getPixel(imagePNG.getWidth() - 1,
            imagePNG.getHeight() - 1).getBlue());

    assertEquals(255, imageBMP.getPixel(0, 0).getRed());
    assertEquals(255, imageBMP.getPixel(0, 0).getGreen());
    assertEquals(255, imageBMP.getPixel(0, 0).getBlue());

    imageBMP.setPixel(0, 0, new Pixel(69, 21, 42));

    assertEquals(69, imageBMP.getPixel(0, 0).getRed());
    assertEquals(21, imageBMP.getPixel(0, 0).getGreen());
    assertEquals(42, imageBMP.getPixel(0, 0).getBlue());

    assertEquals(255, imageBMP.getPixel(50, 187).getRed());
    assertEquals(255, imageBMP.getPixel(50, 187).getGreen());
    assertEquals(255, imageBMP.getPixel(50, 187).getBlue());

    imageBMP.setPixel(50, 187, new Pixel(0, 255, 0));

    assertEquals(0, imageBMP.getPixel(50, 187).getRed());
    assertEquals(255, imageBMP.getPixel(50, 187).getGreen());
    assertEquals(0, imageBMP.getPixel(50, 187).getBlue());

    assertEquals(255, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getRed());
    assertEquals(255, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getGreen());
    assertEquals(255, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getBlue());

    imageBMP.setPixel(imageBMP.getWidth() - 1, imageBMP.getHeight() - 1,
            new Pixel(46, 21, 7));

    assertEquals(46, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getRed());
    assertEquals(21, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getGreen());
    assertEquals(7, imageBMP.getPixel(imageBMP.getWidth() - 1,
            imageBMP.getHeight() - 1).getBlue());
  }
}