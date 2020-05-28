package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class PostIncrementTest extends BaseTest {

  @Test
  public void testPostIncrement() {
    PostIncrement stmt = new PostIncrement(new VariableReference("a"));
    generateAndCompare("TestPostIncrement", stmt);
  }
}