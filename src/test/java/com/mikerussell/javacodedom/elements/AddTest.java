package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class AddTest extends BaseTest {

  @Test
  public void testAdd() {
    Add expr = new Add(new Primitive(5), new Primitive(6));
    generateAndCompare("TestAdd", expr);
  }
}
