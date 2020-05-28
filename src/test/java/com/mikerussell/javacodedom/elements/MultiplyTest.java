package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class MultiplyTest extends BaseTest {

  @Test
  public void testMultiply() {
    Multiply expr = new Multiply(new Primitive(5), new Primitive(6));
    generateAndCompare("TestMultiply", expr);
  }
}
