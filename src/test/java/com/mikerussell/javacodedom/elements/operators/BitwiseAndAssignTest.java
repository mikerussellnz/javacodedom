package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class BitwiseAndAssignTest extends BaseTest {

  @Test
  public void testBitwiseAndAssign() {
    BitwiseAndAssign expr = new BitwiseAndAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestBitwiseAndAssign", expr);
  }

  @Test
  public void testBitwiseAndAssignAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new BitwiseAndAssign(new VariableReference("a"), new Primitive(5)));
    generateAndCompare("TestBitwiseAndAssign-AsStatement", condition);
  }
}
