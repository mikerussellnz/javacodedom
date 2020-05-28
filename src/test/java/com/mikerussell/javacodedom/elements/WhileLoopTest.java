package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import org.junit.Test;

public class WhileLoopTest extends BaseTest {

  @Test
  public void testWhileLoop() {
    WhileLoop iteration = new WhileLoop(
      new LessThan(new VariableReference("i"), new Primitive(5))
    ).addStatements(
      new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
        .addArgument(new Add(new Primitive("Hello World "), new VariableReference("i"))))
    );
    generateAndCompare("TestWhileLoop", iteration);
  }
}