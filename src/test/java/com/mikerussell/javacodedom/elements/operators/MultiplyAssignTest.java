package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class MultiplyAssignTest extends BaseTest {

  @Test
  public void testMultiplyAssign() {
    MultiplyAssign expr = new MultiplyAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestMultiplyAssign", expr);
  }
}
