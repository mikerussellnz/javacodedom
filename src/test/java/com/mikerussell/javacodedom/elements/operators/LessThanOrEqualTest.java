package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class LessThanOrEqualTest extends BaseTest {

  @Test
  public void testLessThanOrEqual() {
    LessThanOrEqual expr = new LessThanOrEqual(new Primitive(5), new Primitive(6));
    generateAndCompare("TestLessThanOrEqual", expr);
  }
}
