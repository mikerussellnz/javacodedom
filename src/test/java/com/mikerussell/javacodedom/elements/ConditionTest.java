package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.operators.Equality;

import org.junit.Test;

public class ConditionTest extends BaseTest {

  @Test
  public void testConditionWithTrueFalseStatements() {
    Condition condition = new Condition()
      .setExpression(new Equality(new Primitive(1), new Primitive(2)))
      .addTrueStatements(new MethodInvocation(TypeReference.get("System.out"),"println")
        .addArgument(new Primitive("True Statement")))
      .addFalseStatements(new MethodInvocation(TypeReference.get("System.out"),"println")
        .addArgument(new Primitive("False Statement")));
    generateAndCompare("TestConditionWithTrueFalseStatements", condition);
  }

  @Test
  public void testConditionWithTrueStatements() {
    Condition condition = new Condition()
      .setExpression(new Equality(new Primitive(1), new Primitive(2)))
      .addTrueStatements(new MethodInvocation(TypeReference.get("System.out"),"println")
          .addArgument(new Primitive("True Statement")));
    generateAndCompare("TestConditionWithTrueStatements", condition);
  }

  @Test
  public void testConditionWithFalseStatements() {
    Condition condition = new Condition()
      .setExpression(new Equality(new Primitive(1), new Primitive(2)))
      .addFalseStatements(new MethodInvocation(TypeReference.get("System.out"),"println")
          .addArgument(new Primitive("False Statement")));
    generateAndCompare("TestConditionWithFalseStatements", condition);
  }
}
