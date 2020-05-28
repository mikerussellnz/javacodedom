package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class AnnotationRefTest extends BaseTest {
  @Test
  public void testAnnotation() {
    AnnotationRef annotation = new AnnotationRef("Override");
    generateAndCompare("TestAnnotation", annotation);
  }

  @Test
  public void testClassAnnotation() {
    ClassDeclaration cd = new ClassDeclaration("TestClass");
    cd.addAnnotation(new AnnotationRef("ModelClass"));
    cd.addAnnotation(new AnnotationRef("JsonSerializable"));
    generateAndCompare("TestAnnotationClass", cd);
  }

  @Test
  public void testFieldAnnotation() {
    FieldDeclaration fd = new FieldDeclaration(AccessModifier.PUBLIC, new TypeReference("int"), "test");
    fd.addAnnotation(new AnnotationRef("ModelClass"));
    fd.addAnnotation(new AnnotationRef("JsonSerializable"));
    generateAndCompare("TestAnnotationField", fd);
  }

  @Test
  public void testAnnotationArg() {
    AnnotationRef arf = new AnnotationRef("JsonProperty", new Primitive("json"));
    generateAndCompare("TestAnnotationArg", arf);
  }

  @Test
  public void testAnnotationArg2() {
    AnnotationRef arf = new AnnotationRef("JsonProperty", new Primitive(2));
    generateAndCompare("TestAnnotationArg2", arf);
  }
}
