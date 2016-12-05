package kz.pompei.tavreli;

import java.io.InputStream;
import org.fest.assertions.Assertions;
import org.testng.annotations.Test;


import static org.fest.assertions.Assertions.assertThat;

public class HelloTest {
  @Test
  public void asd1() throws Exception {
    InputStream in = getClass().getResourceAsStream("HelloTest.txt");
    assertThat(in).isNotNull();
  }
}