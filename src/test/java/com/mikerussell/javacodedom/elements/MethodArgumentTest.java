package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class MethodArgumentTest extends BaseTest {

  @Test
  public void testMethodArgument() {
    MethodArgument methodArgument = new MethodArgument(new TypeReference("String"), "parameter");
    generateAndCompare("TestMethodArgument", methodArgument);
  }
}
