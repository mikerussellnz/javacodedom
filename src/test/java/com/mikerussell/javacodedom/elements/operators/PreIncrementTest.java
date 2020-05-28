package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PreIncrementTest extends BaseTest {

  @Test
  public void testPreIncrement() {
    PreIncrement stmt = new PreIncrement(new VariableReference("a"));
    generateAndCompare("TestPreIncrement", stmt);
  }
}