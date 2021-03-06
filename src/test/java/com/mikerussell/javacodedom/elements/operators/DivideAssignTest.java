package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class DivideAssignTest extends BaseTest {

  @Test
  public void testDivideAssign() {
    DivideAssign expr = new DivideAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestDivideAssign", expr);
  }

  @Test
  public void testDivideAssignAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new DivideAssign(new VariableReference("a"), new Primitive(5)));
    generateAndCompare("TestDivideAssign-AsStatement", condition);
  }
}
