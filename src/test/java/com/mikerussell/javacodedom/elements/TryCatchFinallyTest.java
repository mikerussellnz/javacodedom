package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import org.junit.Test;

public class TryCatchFinallyTest extends BaseTest {

  @Test
  public void testTryCatchFinally() {
      TryCatchFinally tryCatchFinally = new TryCatchFinally()
        .addStatements(
          new ExpressionStatement(new MethodInvocation(new TypeReference("File"), "maybeThrows")),
          new VariableDeclaration(new TypeReference(int.class), "a").initializeWith(new Primitive(5))
        )
        .addFinallyStatements(
          new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
            .addArgument(new Primitive("An error occured, cleanup")))
        ).addCatchClause(new CatchClause(new TypeReference("IOException"), "e")
          .addStatements(
            new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
              .addArgument(new Primitive("An error occured, caught it")))
          ))
          .addCatchClause(new CatchClause(new TypeReference("SomeOtherException"), "e")
            .addStatements(
              new ExpressionStatement(new MethodInvocation(new TypeReference("System.out"),"println")
                .addArgument(new Primitive("Some other error occured, caught it")))
            ));

    generateAndCompare("TestTryCatchFinally", tryCatchFinally);
  }

}
