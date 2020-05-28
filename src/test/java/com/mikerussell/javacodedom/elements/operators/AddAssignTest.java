package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class AddAssignTest extends BaseTest {

  @Test
  public void testAddAssign() {
    AddAssign expr = new AddAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestAddAssign", expr);
  }
}
