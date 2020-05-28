package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class ThrowTest extends BaseTest {

  @Test
  public void testThrow() {
    ThrowException throwException = new ThrowException(new CreateObject(new TypeReference("FileNotFoundException")));
    generateAndCompare("ThrowTest", throwException);
  }
}
