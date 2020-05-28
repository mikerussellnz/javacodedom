package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class EqualityTest extends BaseTest {

  @Test
  public void testEquality() {
    Equality expr = new Equality(new Primitive(5), new Primitive(6));
    generateAndCompare("TestEquality", expr);
  }
}
