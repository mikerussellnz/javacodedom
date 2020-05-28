package com.mikerussell.javacodedom.elements.operators;

import static com.mikerussell.javacodedom.core.AccessModifier.PUBLIC;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.StatementCollection;
import com.mikerussell.javacodedom.elements.Condition;
import com.mikerussell.javacodedom.elements.MethodDeclaration;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PostIncrementTest extends BaseTest {

  @Test
  public void testPostIncrement() {
    PostIncrement stmt = new PostIncrement(new VariableReference("a"));
    generateAndCompare("TestPostIncrement", stmt);
  }

  @Test
  public void testAssignPostIncrement() {
    Assign assign = new Assign(new VariableReference("k"), new PostIncrement(new VariableReference("j")));
    MethodDeclaration method = new MethodDeclaration(PUBLIC, "test")
        .addStatements(assign);
    generateAndCompare("TestPostIncrement-Assign", method);
  }

  @Test
  public void testPostIncrementAsStatement() {
    Condition condition = new Condition(new Primitive(true))
        .addTrueStatement(new PostIncrement(new VariableReference("a")));
    generateAndCompare("TestPostIncrement-AsStatement", condition);
  }
}