package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class ModulusAssignTest extends BaseTest {

  @Test
  public void testModulusAssign() {
    ModulusAssign expr = new ModulusAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestModulusAssign", expr);
  }
}
