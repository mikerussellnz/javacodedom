package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class InequalityTest extends BaseTest {

  @Test
  public void testInequality() {
    Inequality expr = new Inequality(new Primitive(5), new Primitive(6));
    generateAndCompare("TestInequality", expr);
  }
}
