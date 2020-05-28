package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class FieldReferenceTest extends BaseTest {

  @Test
  public void testFieldReference() {
    FieldReference fieldReference = new FieldReference(
      new VariableReference("thevar"), "testingField");
    generateAndCompare("TestFieldReference", fieldReference);
  }
}
