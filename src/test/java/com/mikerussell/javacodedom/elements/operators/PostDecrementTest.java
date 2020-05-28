package com.mikerussell.javacodedom.elements.operators;

import static com.mikerussell.javacodedom.core.AccessModifier.PUBLIC;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.MethodDeclaration;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PostDecrementTest extends BaseTest {

  @Test
  public void testPostDecrement() {
    PostDecrement stmt = new PostDecrement(new VariableReference("a"));
    generateAndCompare("TestPostDecrement", stmt);
  }

  @Test
  public void testAssignPostDecrement() {
    Assign assign = new Assign(new VariableReference("k"), new PostDecrement(new VariableReference("j")));
    MethodDeclaration method = new MethodDeclaration(PUBLIC, "test")
        .addStatements(assign);
    generateAndCompare("TestPostDecrement-Assign", method);
  }

  @Test
  public void testPostDecrementAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new PostDecrement(new VariableReference("a")));
    generateAndCompare("TestPostDecrement-AsStatement", condition);
  }
}