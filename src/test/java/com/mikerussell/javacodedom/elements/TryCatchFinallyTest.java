package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class TryCatchFinallyTest extends BaseTest {

  @Test
  public void testTryCatchFinally() {
      TryCatchFinally tryCatchFinally = new TryCatchFinally()
        .addStatements(
          new MethodInvocation(TypeReference.get("File"), "maybeThrows"),
          new VariableDeclaration(TypeReference.get(int.class), "a").initializeWith(new Primitive(5)))
        .addFinallyStatements(
          new MethodInvocation(TypeReference.get("System.out"),"println")
            .addArgument(new Primitive("An error occured, cleanup"))
        ).addCatchClause(new CatchClause(TypeReference.get("IOException"), "e")
          .addStatements(
            new MethodInvocation(TypeReference.get("System.out"),"println")
              .addArgument(new Primitive("An error occured, caught it"))
          ))
          .addCatchClause(new CatchClause(TypeReference.get("SomeOtherException"), "e")
            .addStatements(
              new MethodInvocation(TypeReference.get("System.out"),"println")
                .addArgument(new Primitive("Some other error occured, caught it"))
            ));

    generateAndCompare("TestTryCatchFinally", tryCatchFinally);
  }

}
