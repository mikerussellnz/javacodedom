package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class VariableReferenceTest extends BaseTest {

  @Test
  public void testVariableReference() {
    VariableReference variableReference = new VariableReference("testVariable");
    generateAndCompare("TestVariableReference", variableReference);
  }
}
