package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class MethodDeclarationTest extends BaseTest {

  @Test
  public void testMethodDeclaration() {
    MethodDeclaration methodDeclaration = new MethodDeclaration(AccessModifier.PUBLIC, "")
      .addThrows(new TypeReference(Exception.class))
      .addArgument(new TypeReference(int.class), "a")
      .addArgument(new TypeReference(String.class), "b")
      .addStatements(
        new VariableDeclaration(new TypeReference(String.class), "c")
          .initializeWith(new Primitive("Test"))
      );
    generateAndCompare("TestMethodDeclaration", methodDeclaration);
  }
}
