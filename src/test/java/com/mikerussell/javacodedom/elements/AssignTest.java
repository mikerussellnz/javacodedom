package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class AssignTest extends BaseTest {

  @Test
  public void testAssign() {
    Assign statement = new Assign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestAssign", statement);
  }

  @Test
  public void testAssignFromMethodCall() {
    Assign statement = new Assign(new VariableReference("a"), new MethodInvocation(new TypeReference("SomeClass"), "getInt"));
    generateAndCompare("TestAssignFromMethodCall", statement);
  }

  @Test
  public void testAssignFromExpression() {
    Assign statement = new Assign(new VariableReference("a"), new Add(new Primitive(5), new Primitive(6)));
    generateAndCompare("TestAssignFromExpression", statement);
  }
}
