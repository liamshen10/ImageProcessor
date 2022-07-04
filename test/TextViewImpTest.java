import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import view.TextView;
import view.TextViewImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the TextView and its methods.
 */
public class TextViewImpTest {

  private TextView view;
  private final Appendable apObject = new StringBuilder();

  @Before
  public void init() {
    view = new TextViewImp(apObject);
  }

  @Test
  public void testInvalidConstructor() {
    Appendable apNull = null;
    try {
      TextView viewFail = new TextViewImp(apNull);
      fail();
    } catch (IllegalArgumentException e) {
      //If it hits here, then the constructor is valid, and it is working.
    }
  }


  @Test
  public void testRenderMessage() {
    try {
      view.renderMessage("Vid is 'happy'");
    } catch (IOException e) {
      fail();
    }
    assertEquals("Vid is 'happy'", apObject.toString());
    try {
      view.renderMessage(" and Vid is stupid");
    } catch (IOException e) {
      fail();
    }
    assertEquals("Vid is 'happy' and Vid is stupid", apObject.toString());
  }

  @Test
  public void testInvalidRenderMessage() {
    try {
      TextView messageTest = new TextViewImp(new IOExceptionTest());
      messageTest.renderMessage("Vidyut");
      fail();
    } catch (IOException e) {
      //If it hits here then the fail is passed over, and it is not working.
    }
  }
}
