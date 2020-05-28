package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class BitwiseAndTest extends BaseTest {

  @Test
  public void testBitwiseAnd() {
    BitwiseAnd expr = new BitwiseAnd(new Primitive(5), new Primitive(6));
    generateAndCompare("TestBitwiseAnd", expr);
  }
}
