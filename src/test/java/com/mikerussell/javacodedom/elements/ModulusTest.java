package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class ModulusTest extends BaseTest {

  @Test
  public void testModulus() {
    Modulus expr = new Modulus(new Primitive(5), new Primitive(6));
    generateAndCompare("TestModulus", expr);
  }
}
