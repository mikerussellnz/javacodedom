package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class GreaterThanTest extends BaseTest {

  @Test
  public void testGreaterThan() {
    GreaterThan expr = new GreaterThan(new Primitive(5), new Primitive(6));
    generateAndCompare("TestGreaterThan", expr);
  }
}
