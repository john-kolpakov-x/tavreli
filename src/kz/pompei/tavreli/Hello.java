package kz.pompei.tavreli;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Hello {
  public static void main(String[] args) throws Exception {
    new Hello().run();
  }

  public static String streamToStr(InputStream inputStream) throws Exception {
    try {

      final byte[] buffer = new byte[1024 * 8];
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      while (true) {
        int count = inputStream.read(buffer);
        if (count < 0) return bout.toString("UTF-8");
        bout.write(buffer, 0, count);
      }

    } finally {
      inputStream.close();
    }
  }

  private void run() throws Exception {
    System.out.println("Hello");
    String content1 = streamToStr(getClass().getResourceAsStream("/default.resource.txt"));
    System.out.println(content1);

    String content2 = streamToStr(getClass().getResourceAsStream("Hello.txt"));
    System.out.println(content2);
  }
}
