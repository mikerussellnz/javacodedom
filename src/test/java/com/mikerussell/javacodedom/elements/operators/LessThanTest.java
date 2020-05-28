package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class LessThanTest extends BaseTest {

  @Test
  public void testLessThan() {
    LessThan expr = new LessThan(new Primitive(5), new Primitive(6));
    generateAndCompare("TestLessThan", expr);
  }
}
