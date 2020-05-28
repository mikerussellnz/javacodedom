package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import org.junit.Test;

public class ForLoopTest extends BaseTest {

  @Test
  public void testForLoop() {
    ForLoop iteration = new ForLoop(
      new VariableDeclaration(new TypeReference("int"), "i").initializeWith(new Primitive(0)),
      new LessThan(new VariableReference("i"), new Primitive(5)),
      new PostIncrement(new VariableReference("i"))
    ).addStatements(
      new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
        .addArgument(new Add(new Primitive("Hello World "), new VariableReference("i"))))
    );
    generateAndCompare("TestForLoop", iteration);
  }
}
