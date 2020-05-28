package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class BitwiseExclusiveOrTest extends BaseTest {

  @Test
  public void testBitwiseExclusiveOr() {
    BitwiseExclusiveOr expr = new BitwiseExclusiveOr(new Primitive(5), new Primitive(6));
    generateAndCompare("TestBitwiseExclusiveOr", expr);
  }
}
