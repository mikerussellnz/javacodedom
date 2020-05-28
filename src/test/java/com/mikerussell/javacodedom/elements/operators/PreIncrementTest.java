package com.mikerussell.javacodedom.elements.operators;

import static com.mikerussell.javacodedom.core.AccessModifier.PUBLIC;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.MethodDeclaration;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PreIncrementTest extends BaseTest {

  @Test
  public void testPreIncrement() {
    PreIncrement stmt = new PreIncrement(new VariableReference("a"));
    generateAndCompare("TestPreIncrement", stmt);
  }

  @Test
  public void testAssignPreIncrement() {
    Assign assign = new Assign(new VariableReference("k"), new PreIncrement(new VariableReference("j")));
    MethodDeclaration method = new MethodDeclaration(PUBLIC, "test")
        .addStatements(assign);
    generateAndCompare("TestPreIncrement-Assign", method);
  }

  @Test
  public void testPreDecrementAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new PreDecrement(new VariableReference("a")));
    generateAndCompare("TestPreDecrement-AsStatement", condition);
  }
}