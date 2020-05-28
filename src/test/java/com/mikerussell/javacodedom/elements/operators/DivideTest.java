package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class DivideTest extends BaseTest {

  @Test
  public void testDivide() {
    Divide expr = new Divide(new Primitive(5), new Primitive(6));
    generateAndCompare("TestDivide", expr);
  }
}
