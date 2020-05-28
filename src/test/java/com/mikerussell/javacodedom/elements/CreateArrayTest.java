package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class CreateArrayTest extends BaseTest {

  @Test
  public void testCreateArray() {
    CreateArray createArray = new CreateArray(TypeReference.INT, 5);
    generateAndCompare("TestCreateArray", createArray);
  }
}
