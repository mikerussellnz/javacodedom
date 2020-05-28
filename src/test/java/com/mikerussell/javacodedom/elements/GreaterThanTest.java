package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class GreaterThanTest extends BaseTest {

  @Test
  public void testGreaterThan() {
    GreaterThan expr = new GreaterThan(new Primitive(5), new Primitive(6));
    generateAndCompare("TestGreaterThan", expr);
  }
}
