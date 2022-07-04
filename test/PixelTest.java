import org.junit.Before;
import org.junit.Test;

import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests methods that are used for pixels.
 */
public class PixelTest {

  private Pixel pixel1;
  private Pixel pixel2;

  @Before
  public void init() {
    pixel1 = new Pixel(100, 100, 100);
    pixel2 = new Pixel(231, 97, 85);
  }

  @Test
  public void testInvalidPixels() {
    try {
      Pixel pixelLowerRed = new Pixel(-1, 100, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelUpperRed = new Pixel(256, 100, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelLowerGreen = new Pixel(100, -1, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelUpperGreen = new Pixel(100, 256, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelLowerBlue = new Pixel(100, 100, -1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelUpperBlue = new Pixel(100, 100, 256);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelAllUpperInvalid = new Pixel(256, 256, 256);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelTwoUpperInvalid = new Pixel(256, 256, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }

    try {
      Pixel pixelAllLowerInvalid = new Pixel(256, -1, 256);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
    try {
      Pixel pixelTwoLowerInvalid = new Pixel(-1, -1, 100);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the pixel is valid, hence failing the invalid test
    }
  }

  @Test
  public void testGetRed() {
    assertEquals(100, pixel1.getRed());
    assertEquals(231, pixel2.getRed());
  }

  @Test
  public void testGetGreen() {
    assertEquals(100, pixel1.getGreen());
    assertEquals(97, pixel2.getGreen());
  }

  @Test
  public void testGetBlue() {
    assertEquals(100, pixel1.getBlue());
    assertEquals(85, pixel2.getBlue());
  }

  @Test
  public void testInvalidSetRed() {
    try {
      pixel1.setRed(-1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the setRed is valid, hence failing the invalid test
    }
    try {
      pixel1.setRed(256);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the setRed is valid, hence failing the invalid test
    }
  }

  @Test
  public void testInvalidSetGreen() {
    try {
      pixel1.setGreen(-1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the setGreen is valid, hence failing the invalid test
    }
    try {
      pixel1.setGreen(256);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the setGreen is valid, hence failing the invalid test
    }
  }

  @Test
  public void testInvalidSetBlue() {
    try {
      pixel1.setBlue(-1);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the setGreen is valid, hence failing the invalid test
    }
    try {
      pixel1.setBlue(256);
      fail();
    } catch (IllegalArgumentException e) {
      // If it reaches this code, the setGreen is valid, hence failing the invalid test
    }
  }

  @Test
  public void testSetRed() {
    assertEquals(100, pixel1.getRed());
    pixel1.setRed(200);
    assertEquals(200, pixel1.getRed());

    assertEquals(231, pixel2.getRed());
    pixel2.setRed(0);
    assertEquals(0, pixel2.getRed());
  }

  @Test
  public void testSetGreen() {
    assertEquals(100, pixel1.getGreen());
    pixel1.setGreen(200);
    assertEquals(200, pixel1.getGreen());

    assertEquals(97, pixel2.getGreen());
    pixel2.setGreen(240);
    assertEquals(240, pixel2.getGreen());
  }

  @Test
  public void testSetBlue() {
    assertEquals(100, pixel1.getBlue());
    pixel1.setBlue(200);
    assertEquals(200, pixel1.getBlue());

    assertEquals(85, pixel2.getBlue());
    pixel2.setBlue(73);
    assertEquals(73, pixel2.getBlue());
  }

  @Test
  public void testGetLuma() {
    assertEquals(100.0, pixel1.getLuma(), 0.01);
    assertEquals(124.622, pixel2.getLuma(), 0.01);
  }

  @Test
  public void testGetValue() {
    assertEquals(100, pixel1.getValue());
    assertEquals(231, pixel2.getValue());
  }

  @Test
  public void testGetIntensity() {
    assertEquals(100, pixel1.getIntensity());
    assertEquals(137, pixel2.getIntensity());
  }
}
