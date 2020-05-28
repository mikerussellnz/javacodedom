package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PostDecrementTest extends BaseTest {

  @Test
  public void testPostDecrement() {
    PostDecrement stmt = new PostDecrement(new VariableReference("a"));
    generateAndCompare("TestPostDecrement", stmt);
  }
}