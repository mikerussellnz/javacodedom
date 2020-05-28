package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class TypeReferenceTest extends BaseTest {

  @Test
  public void testStringTypeReference() {
    TypeReference typeReference = TypeReference.get("SomeClass");
    generateAndCompare("TestStringTypeReference", typeReference);
  }

  @Test
  public void testClassTypeReference() {
    TypeReference typeReference = TypeReference.get(java.lang.Thread.class);
    generateAndCompare("TestClassTypeReference", typeReference);
  }

  @Test
  public void testTypeReferenceWithGenericParameter() {
    TypeReference typeReference = TypeReference.get(java.util.ArrayList.class)
      .addGenericParameter(TypeReference.get(String.class));
    generateAndCompare("TestGenericParameterTypeReference", typeReference);
  }

  @Test
  public void testTypeReferenceWithGenericParameters() {
    TypeReference typeReference = TypeReference.get(java.util.Map.class)
      .addGenericParameter(TypeReference.get(String.class))
      .addGenericParameter(TypeReference.get(Object.class));

    generateAndCompare("TestGenericParametersTypeReference", typeReference);
  }

  @Test
  public void testTypeReferenceWithGenericParametersPackageAndClassName() {
    TypeReference typeReference = TypeReference.get("java.util", "Map")
        .addGenericParameter(TypeReference.get(String.class))
        .addGenericParameter(TypeReference.get(Object.class));

    generateAndCompare("TestGenericParametersTypeReference", typeReference);
  }
}
