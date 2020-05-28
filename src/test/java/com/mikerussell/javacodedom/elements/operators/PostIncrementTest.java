package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.BaseTest;
import com.mikerussell.javacodedom.elements.VariableReference;
import org.junit.Test;

public class PostIncrementTest extends BaseTest {

  @Test
  public void testPostIncrement() {
    PostIncrement stmt = new PostIncrement(new VariableReference("a"));
    generateAndCompare("TestPostIncrement", stmt);
  }
}