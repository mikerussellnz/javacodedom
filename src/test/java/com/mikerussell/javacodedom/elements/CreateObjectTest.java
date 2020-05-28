package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class CreateObjectTest extends BaseTest {
  @Test
  public void testCreateObject() {
    CreateObject createObject = new CreateObject(new TypeReference("MultiArgConstructor"))
      .addArgument(new Primitive(5))
      .addArgument(new VariableReference("a"))
      .addArgument(new VariableReference("b"))
      .addArgument(new VariableReference("c"));

    generateAndCompare("TestCreateObject", createObject);
  }

  @Test
  public void testCreateObjectWithGenericParameters() {
    CreateObject createObject = new CreateObject(new TypeReference("MultiArgConstructorWithGenerics"))
      .addArgument(new Primitive(5))
      .addArgument(new VariableReference("a"))
      .addArgument(new VariableReference("b"))
      .addArgument(new VariableReference("c"))
      .addGenericParameter(new TypeReference(int.class))
      .addGenericParameter(new TypeReference(String.class));

    generateAndCompare("TestCreateObjectWithGenericParameters", createObject);
  }
}
