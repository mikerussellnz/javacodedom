package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class LocalFieldReferenceTest extends BaseTest {

  @Test
  public void testLocalFieldReference() {
    FieldReference fieldReference = new LocalFieldReference("testingField");
    generateAndCompare("TestLocalFieldReference", fieldReference);
  }
}
