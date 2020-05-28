package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class BitwiseOrTest extends BaseTest {

  @Test
  public void testBitwiseOr() {
    BitwiseOr expr = new BitwiseOr(new Primitive(5), new Primitive(6));
    generateAndCompare("TestBitwiseOr", expr);
  }
}
