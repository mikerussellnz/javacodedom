package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.MethodInvocation;
import com.mikerussell.javacodedom.elements.Primitive;
import com.mikerussell.javacodedom.elements.TypeReference;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class AssignTest extends BaseTest {

  @Test
  public void testAssign() {
    Assign statement = new Assign(new VariableReference("a"), new Primitive(6));
    generateAndCompare("TestAssign", statement);
  }

  @Test
  public void testAssignFromMethodCall() {
    Assign statement = new Assign(new VariableReference("a"), new MethodInvocation(TypeReference.get("SomeClass"), "getInt"));
    generateAndCompare("TestAssignFromMethodCall", statement);
  }

  @Test
  public void testAssignFromExpression() {
    Assign statement = new Assign(new VariableReference("a"), new Add(new Primitive(5), new Primitive(6)));
    generateAndCompare("TestAssignFromExpression", statement);
  }
}
