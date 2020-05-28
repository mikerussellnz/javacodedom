package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class SubtractTest extends BaseTest {

  @Test
  public void testSubtract() {
    Subtract expr = new Subtract(new Primitive(5), new Primitive(6));
    generateAndCompare("TestSubtract", expr);
  }
}
