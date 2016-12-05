package kz.pompei.tavreli;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Hello {
  public static void main(String[] args) throws Exception {
    new Hello().run();
  }

  public static String streamToStr(InputStream inputStream) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
      return br.lines().collect(Collectors.joining("\n"));
    }
  }

  private void run() throws Exception {
    System.out.println("Hello");
    String content = streamToStr(getClass().getResourceAsStream("/default.resource.txt"));
    System.out.println(content);

    String content2 = streamToStr(getClass().getResourceAsStream("Hello.txt"));
    System.out.println(content2);
  }
}
