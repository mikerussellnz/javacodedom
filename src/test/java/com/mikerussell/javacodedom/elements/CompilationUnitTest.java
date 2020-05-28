package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.core.AccessModifier;
import org.junit.Test;

public class CompilationUnitTest extends BaseTest {
  @Test
  public void testCompilationUnitPackage() {
    CompilationUnit compilationUnit = new CompilationUnit();
    compilationUnit.setPackage(new Package("com.example.test"));
    compilationUnit.addImport(TypeReference.get("java.sql","ResultSet"));

    ClassDeclaration classDeclaration = new ClassDeclaration("TestClass");
    classDeclaration.addField(new FieldDeclaration(AccessModifier.PRIVATE, TypeReference.get(int.class), "field1"));

    compilationUnit.addTypeDeclaration(classDeclaration);

    generateAndCompare("TestCompilationUnitPackage", compilationUnit);
  }
}
