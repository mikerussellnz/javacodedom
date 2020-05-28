package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import org.junit.Test;

public class BooleanOrTest extends BaseTest {

  @Test
  public void testBooleanOr() {
    BooleanOr expr = new BooleanOr(new Primitive(true), new Primitive(false));
    generateAndCompare("TestBooleanOr", expr);
  }
}
