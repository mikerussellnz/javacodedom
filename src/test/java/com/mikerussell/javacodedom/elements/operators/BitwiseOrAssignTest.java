package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class BitwiseOrAssignTest extends BaseTest {

  @Test
  public void testBitwiseOrAssign() {
    BitwiseOrAssign expr = new BitwiseOrAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestBitwiseOrAssign", expr);
  }

  @Test
  public void testBitwiseOrAssignAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new BitwiseOrAssign(new VariableReference("a"), new Primitive(5)));
    generateAndCompare("TestBitwiseOrAssign-AsStatement", condition);
  }
}
