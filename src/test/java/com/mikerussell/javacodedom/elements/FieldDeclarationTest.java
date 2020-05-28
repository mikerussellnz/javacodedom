package com.mikerussell.javacodedom.elements;

import static com.mikerussell.javacodedom.core.AccessModifier.FINAL;
import static com.mikerussell.javacodedom.core.AccessModifier.PRIVATE;
import static com.mikerussell.javacodedom.core.AccessModifier.PUBLIC;
import static com.mikerussell.javacodedom.core.AccessModifier.STATIC;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class FieldDeclarationTest extends BaseTest{

  @Test
  public void testFieldDeclaration() {
    FieldDeclaration fieldDeclaration = new FieldDeclaration(PRIVATE, TypeReference.INT, "a");
    generateAndCompare("TestFieldDeclaration", fieldDeclaration);
  }

  @Test
  public void testFieldDeclarationFinal() {
    FieldDeclaration fieldDeclaration = new FieldDeclaration(PUBLIC | FINAL | STATIC , TypeReference.INT, "a");
    generateAndCompare("TestFieldDeclarationConstant", fieldDeclaration);
  }

  @Test
  public void testFieldDeclarationWithInitializer() {
    FieldDeclaration fieldDeclaration = new FieldDeclaration(PRIVATE, TypeReference.INT, "a")
      .initializeWith(new Primitive(5));
    generateAndCompare("TestFieldDeclarationWithInitializer", fieldDeclaration);
  }
}
