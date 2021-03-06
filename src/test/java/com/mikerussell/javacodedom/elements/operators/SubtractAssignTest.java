package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class SubtractAssignTest extends BaseTest {

  @Test
  public void testSubtractAssign() {
    SubtractAssign expr = new SubtractAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestSubtractAssign", expr);
  }

  @Test
  public void testSubtractAssignAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new SubtractAssign(new VariableReference("a"), new Primitive(5)));
    generateAndCompare("TestSubtractAssign-AsStatement", condition);
  }
}
