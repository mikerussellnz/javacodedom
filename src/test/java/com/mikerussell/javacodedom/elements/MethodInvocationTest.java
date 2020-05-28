package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import org.junit.Test;

public class MethodInvocationTest extends BaseTest {

  @Test
  public void testMethodInvocation() {
    MethodInvocation methodInvocation = new MethodInvocation(TypeReference.get("this"),"multiArgFunction")
      .addArgument(new Primitive("test arg"))
      .addArgument(new VariableReference("a"))
      .addArgument(new LocalFieldReference("b"));
    generateAndCompare("TestMethodInvocation", new ExpressionStatement(methodInvocation));
  }

  @Test
  public void testMethodInvocationTargetImplicitThis() {
    MethodInvocation methodInvocation = new MethodInvocation("multiArgFunction")
      .addArgument(new Primitive("test arg"))
      .addArgument(new VariableReference("a"))
      .addArgument(new LocalFieldReference("b"));
    generateAndCompare("TestMethodInvocationTargetImplicitThis", new ExpressionStatement(methodInvocation));
  }

  @Test
  public void testMethodInvocationWithGenericParameters() {
    MethodInvocation methodInvocation = new MethodInvocation(TypeReference.get("this"),"multiArgGenericFunction")
      .addArgument(new Primitive("test arg"))
      .addArgument(new VariableReference("a"))
      .addArgument(new LocalFieldReference("b"))
      .addGenericParameter(TypeReference.get(int.class))
      .addGenericParameter(TypeReference.get(String.class));
    generateAndCompare("TestMethodInvocationWithGenericParameters", new ExpressionStatement(methodInvocation));
  }
}
