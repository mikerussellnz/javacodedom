package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class PreIncrementTest extends BaseTest {

  @Test
  public void testPostIncrement() {
    PreIncrement stmt = new PreIncrement(new VariableReference("a"));
    generateAndCompare("TestPreIncrement", stmt);
  }
}