package com.mikerussell.javacodedom.elements.operators;

import static com.mikerussell.javacodedom.core.AccessModifier.PUBLIC;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.MethodDeclaration;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PreDecrementTest extends BaseTest {

  @Test
  public void testPreDecrement() {
    PreDecrement stmt = new PreDecrement(new VariableReference("a"));
    generateAndCompare("TestPreDecrement", stmt);
  }

  @Test
  public void testAssignPreDecrement() {
    Assign assign = new Assign(new VariableReference("k"), new PreDecrement(new VariableReference("j")));
    MethodDeclaration method = new MethodDeclaration(PUBLIC, "test")
        .addStatements(assign);
    generateAndCompare("TestPreDecrement-Assign", method);
  }

  @Test
  public void testPreDecrementAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new PreDecrement(new VariableReference("a")));
    generateAndCompare("TestPreDecrement-AsStatement", condition);
  }
}