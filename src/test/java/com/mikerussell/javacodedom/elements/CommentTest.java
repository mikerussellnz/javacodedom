package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class CommentTest extends BaseTest {
  @Test
  public void testComment() {
    Comment statement = new Comment("This is a comment.");
    generateAndCompare("TestComment", statement);
  }
}
