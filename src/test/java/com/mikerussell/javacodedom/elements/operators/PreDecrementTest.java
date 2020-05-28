package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PreDecrementTest extends BaseTest {

  @Test
  public void testPreDecrement() {
    PreDecrement stmt = new PreDecrement(new VariableReference("a"));
    generateAndCompare("TestPreDecrement", stmt);
  }
}