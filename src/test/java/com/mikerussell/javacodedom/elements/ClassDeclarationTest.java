package com.mikerussell.javacodedom.elements;

import static com.mikerussell.javacodedom.core.AccessModifier.ABSTRACT;
import static com.mikerussell.javacodedom.core.AccessModifier.PRIVATE;
import static com.mikerussell.javacodedom.core.AccessModifier.PROTECTED;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class ClassDeclarationTest extends BaseTest {
  @Test
  public void testClassDeclarationFields() {
    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass");
    classDeclaration.addField(new FieldDeclaration(PRIVATE, new TypeReference(int.class), "field1"));
    classDeclaration.addField(new FieldDeclaration(PRIVATE, new TypeReference(String.class), "field2")
      .initializeWith(new Primitive("Hello")));

    generateAndCompare("TestClassDeclarationFields", classDeclaration);
  }

  @Test
  public void testClassDeclarationAbstract() {
    ClassDeclaration classDeclaration = new ClassDeclaration(PROTECTED | ABSTRACT, "TestClass");
    generateAndCompare("TestClassDeclarationAbstract", classDeclaration);
  }

  @Test
  public void testClassGenericParameters() {
    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass");
    classDeclaration.addGenericParameter(new GenericParameter("T")
      .addBound(new TypeReference(Integer.class))
      .addBound(new TypeReference(String.class)));
    classDeclaration.addGenericParameter(new GenericParameter("V"));

    generateAndCompare("TestClassGenericParameters", classDeclaration);
  }

  @Test
  public void testClassDeclarationMethods() {
    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass")
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodOne"))
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodTwo"));

    generateAndCompare("TestClassDeclarationMethods", classDeclaration);
  }

  @Test
  public void testClassDeclarationInnerClass() {
    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass");
    classDeclaration.addInnerType(new ClassDeclaration("TestInner"));
    classDeclaration.addInnerType(new ClassDeclaration("TestInner2"));

    generateAndCompare("TestClassDeclarationInnerClass", classDeclaration);
  }

  @Test
  public void testClassDeclarationFieldsAndMethods() {
    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass")
      .addField(new FieldDeclaration(PRIVATE, new TypeReference(int.class), "field1"))
      .addField(new FieldDeclaration(PRIVATE, new TypeReference(String.class), "field2")
        .initializeWith(new Primitive("Hello")))
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodOne"))
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodTwo"));

    generateAndCompare("TestClassDeclarationFieldsAndMethods", classDeclaration);
  }

  @Test
  public void testClassDeclarationExtendsAndImplements() {
    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass")
      .setExtends(new TypeReference("BaseClass"))
      .addImplements(new TypeReference("Interface1"))
      .addImplements(new TypeReference("Interface2"))
      .addImplements(new TypeReference("Interface3"));

    generateAndCompare("TestClassDeclarationExtendsAndImplements", classDeclaration);
  }
}
