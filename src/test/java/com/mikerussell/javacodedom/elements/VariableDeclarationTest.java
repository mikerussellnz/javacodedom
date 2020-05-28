package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class VariableDeclarationTest extends BaseTest {

  @Test
  public void testVariableDeclaration() {
    VariableDeclaration variableDeclaration = new VariableDeclaration(new TypeReference("int"), "a");
    generateAndCompare("VariableDeclarationTest", variableDeclaration);
  }

  @Test
  public void testVariableDeclarationWithInitializer() {
    VariableDeclaration variableDeclaration = new VariableDeclaration(new TypeReference("int"), "a")
      .initializeWith(new Primitive(5));
    generateAndCompare("TestVariableDeclarationWithInitializer", variableDeclaration);
  }
}