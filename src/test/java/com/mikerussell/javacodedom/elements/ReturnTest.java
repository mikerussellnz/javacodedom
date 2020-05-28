package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class ReturnTest extends BaseTest {
  @Test
  public void testReturningVoid() {
    Return statement = new Return();
    generateAndCompare("TestReturningVoid", statement);
  }

  @Test
  public void testReturningValue() {
    Return statement = new Return(new VariableReference("a"));
    generateAndCompare("TestReturningValue", statement);
  }
}
