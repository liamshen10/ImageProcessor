import java.io.IOException;

/**
 * Public class IOExceptionTest that implements public Java Appendable interface,
 * that is used to test methods for IOException().
 */
public class IOExceptionTest implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
