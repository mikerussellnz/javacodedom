package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class GreaterThanOrEqualTest extends BaseTest {

  @Test
  public void testGreaterThanOrEqual() {
    GreaterThanOrEqual expr = new GreaterThanOrEqual(new Primitive(5), new Primitive(6));
    generateAndCompare("TestGreaterThanOrEqual", expr);
  }
}
