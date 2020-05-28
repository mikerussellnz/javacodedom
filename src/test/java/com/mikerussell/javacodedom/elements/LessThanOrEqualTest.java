package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class LessThanOrEqualTest extends BaseTest {

  @Test
  public void testLessThanOrEqual() {
    LessThanOrEqual expr = new LessThanOrEqual(new Primitive(5), new Primitive(6));
    generateAndCompare("TestLessThanOrEqual", expr);
  }
}
