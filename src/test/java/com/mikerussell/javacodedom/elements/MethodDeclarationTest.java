package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class MethodDeclarationTest extends BaseTest {

  @Test
  public void testMethodDeclaration() {
    MethodDeclaration methodDeclaration = new MethodDeclaration(AccessModifier.PUBLIC, "")
      .addThrows(TypeReference.get(Exception.class))
      .addArgument(TypeReference.get(int.class), "a")
      .addArgument(TypeReference.get(String.class), "b")
      .addStatements(
        new VariableDeclaration(TypeReference.get(String.class), "c")
          .initializeWith(new Primitive("Test"))
      );
    generateAndCompare("TestMethodDeclaration", methodDeclaration);
  }
}
