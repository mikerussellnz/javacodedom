package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import org.junit.Test;

public class ConditionTest extends BaseTest {

  @Test
  public void testConditionWithTrueFalseStatements() {
    Condition condition = new Condition()
      .setExpression(new Equality(new Primitive(1), new Primitive(2)))
      .addTrueStatements(
        new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
      .addArgument(new Primitive("True Statement")))
      ).addFalseStatements(
        new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
          .addArgument(new Primitive("False Statement")))
      );
    generateAndCompare("TestConditionWithTrueFalseStatements", condition);
  }

  @Test
  public void testConditionWithTrueStatements() {
    Condition condition = new Condition()
      .setExpression(new Equality(new Primitive(1), new Primitive(2)))
      .addTrueStatements(
        new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
          .addArgument(new Primitive("True Statement")))
      );
    generateAndCompare("TestConditionWithTrueStatements", condition);
  }

  @Test
  public void testConditionWithFalseStatements() {
    Condition condition = new Condition()
      .setExpression(new Equality(new Primitive(1), new Primitive(2)))
      .addFalseStatements(
        new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
          .addArgument(new Primitive("False Statement")))
      );
    generateAndCompare("TestConditionWithFalseStatements", condition);
  }
}
