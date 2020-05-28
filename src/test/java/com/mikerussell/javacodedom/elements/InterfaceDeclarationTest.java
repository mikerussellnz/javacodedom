package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class InterfaceDeclarationTest extends BaseTest {
  @Test
  public void testInterfaceDeclarationFields() {
    InterfaceDeclaration classDeclaration = new InterfaceDeclaration("TestInterface");
    classDeclaration.addField(new FieldDeclaration(AccessModifier.PRIVATE, new TypeReference(int.class), "field1"));
    classDeclaration.addField(new FieldDeclaration(AccessModifier.PRIVATE, new TypeReference(String.class), "field2")
      .initializeWith(new Primitive("Hello")));

    generateAndCompare("TestInterfaceDeclarationFields", classDeclaration);
  }

  @Test
  public void testInterfaceGenericParameters() {
    InterfaceDeclaration classDeclaration = new InterfaceDeclaration("TestInterface");
    classDeclaration.addGenericParameter(new GenericParameter("T")
      .addBound(new TypeReference(Integer.class))
      .addBound(new TypeReference(String.class)));
    classDeclaration.addGenericParameter(new GenericParameter("V"));

    generateAndCompare("TestInterfaceGenericParameters", classDeclaration);
  }


  @Test
  public void testInterfaceDeclarationMethods() {
    InterfaceDeclaration classDeclaration = new InterfaceDeclaration("TestInterface")
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodOne"))
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodTwo"));

    generateAndCompare("TestInterfaceDeclarationMethods", classDeclaration);
  }

  @Test
  public void testInterfaceDeclarationFieldsAndMethods() {
    InterfaceDeclaration classDeclaration = new InterfaceDeclaration("TestInterface")
      .addField(new FieldDeclaration(AccessModifier.PRIVATE, new TypeReference(int.class), "field1"))
      .addField(new FieldDeclaration(AccessModifier.PRIVATE, new TypeReference(String.class), "field2")
        .initializeWith(new Primitive("Hello")))
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodOne"))
      .addMethod(new MethodDeclaration(AccessModifier.PUBLIC, "methodTwo"));

    generateAndCompare("TestInterfaceDeclarationFieldsAndMethods", classDeclaration);
  }

  @Test
  public void testInterfaceDeclarationExtendsAndImplements() {
    InterfaceDeclaration classDeclaration = new InterfaceDeclaration("TestInterface")
      .addExtends(new TypeReference("Interface1"))
      .addExtends(new TypeReference("Interface2"))
      .addExtends(new TypeReference("Interface3"));

    generateAndCompare("TestInterfaceDeclarationExtendsAndImplements", classDeclaration);
  }
}
