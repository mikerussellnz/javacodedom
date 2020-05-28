package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class BitwiseExclusiveOrAssignTest extends BaseTest {

  @Test
  public void testBitwiseExclusiveOrAssign() {
    BitwiseExclusiveOrAssign expr = new BitwiseExclusiveOrAssign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestBitwiseExclusiveOrAssign", expr);
  }

  @Test
  public void testBitwiseExclusiveOrAssignAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new BitwiseExclusiveOrAssign(new VariableReference("a"), new Primitive(5)));
    generateAndCompare("TestBitwiseExclusiveOrAssign-AsStatement", condition);
  }
}
