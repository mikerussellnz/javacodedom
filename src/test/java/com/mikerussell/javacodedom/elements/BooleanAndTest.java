package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class BooleanAndTest extends BaseTest {

  @Test
  public void testBooleanAnd() {
    BooleanAnd expr = new BooleanAnd(new Primitive(true), new Primitive(false));
    generateAndCompare("TestBooleanAnd", expr);
  }
}
