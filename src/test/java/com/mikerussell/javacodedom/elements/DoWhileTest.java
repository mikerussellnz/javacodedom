package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import com.mikerussell.javacodedom.elements.operators.Add;
import com.mikerussell.javacodedom.elements.operators.LessThan;

import org.junit.Test;

public class DoWhileTest extends BaseTest {

  @Test
  public void testDoWhileLoop() {
    DoWhileLoop iteration = new DoWhileLoop(
      new LessThan(new VariableReference("i"), new Primitive(5))
    ).addStatements(
      new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
        .addArgument(new Add(new Primitive("Hello World "), new VariableReference("i"))))
    );
    generateAndCompare("TestDoWhileLoop", iteration);
  }
}
