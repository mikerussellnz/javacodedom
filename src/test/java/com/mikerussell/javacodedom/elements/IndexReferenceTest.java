package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class IndexReferenceTest extends BaseTest {
  @Test
  public void testIndexReference() {
    IndexReference indexReference = new IndexReference(new VariableReference("testVariable"), 5);
    generateAndCompare("TestIndexReference", indexReference);
  }
}
