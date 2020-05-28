package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import com.mikerussell.javacodedom.elements.operators.Add;
import org.junit.Test;

public class ForeachLoopTest extends BaseTest {

  @Test
  public void testForeachLoop() {
    VariableDeclaration itemVar = new VariableDeclaration(new TypeReference(String.class), "str");
    ForeachLoop iteration = new ForeachLoop(itemVar, new VariableReference("stringCollection")
    ).addStatements(
      new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
        .addArgument(new Add(new Primitive("Hello World "), new VariableReference("str"))))
    );
    generateAndCompare("TestForeachLoop", iteration);
  }
}
