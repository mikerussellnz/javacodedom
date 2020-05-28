package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class DivideTest extends BaseTest {

  @Test
  public void testDivide() {
    Divide expr = new Divide(new Primitive(5), new Primitive(6));
    generateAndCompare("TestDivide", expr);
  }
}
