package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class PrimitiveTest extends BaseTest {
  @Test
  public void testPrimitiveNumber() {
    Primitive primitive = new Primitive(4);
    generateAndCompare("TestPrimitiveNumber", primitive);
  }

  @Test
  public void testPrimitiveFloat() {
    Primitive primitive = new Primitive(4.667);
    generateAndCompare("TestPrimitiveFloat", primitive);
  }

  @Test
  public void testPrimitiveString() {
    Primitive primitive = new Primitive("some string here");
    generateAndCompare("TestPrimitiveString", primitive);
  }
}
