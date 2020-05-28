package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class TypeReferenceTest extends BaseTest {

  @Test
  public void testStringTypeReference() {
    TypeReference typeReference = new TypeReference("SomeClass");
    generateAndCompare("TestStringTypeReference", typeReference);
  }

  @Test
  public void testClassTypeReference() {
    TypeReference typeReference = new TypeReference(java.lang.Thread.class);
    generateAndCompare("TestClassTypeReference", typeReference);
  }

  @Test
  public void testTypeReferenceWithGenericParameter() {
    TypeReference typeReference = new TypeReference(java.util.ArrayList.class)
      .addGenericParameter(new TypeReference(String.class));
    generateAndCompare("TestGenericParameterTypeReference", typeReference);
  }

  @Test
  public void testTypeReferenceWithGenericParameters() {
    TypeReference typeReference = new TypeReference(java.util.Map.class)
      .addGenericParameter(new TypeReference(String.class))
      .addGenericParameter(new TypeReference(Object.class));

    generateAndCompare("TestGenericParametersTypeReference", typeReference);
  }

  @Test
  public void testTypeReferenceWithGenericParametersPackageAndClassName() {
    TypeReference typeReference = new TypeReference("java.util", "Map")
        .addGenericParameter(new TypeReference(String.class))
        .addGenericParameter(new TypeReference(Object.class));

    generateAndCompare("TestGenericParametersTypeReference", typeReference);
  }
}
