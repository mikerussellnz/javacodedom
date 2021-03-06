package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class CastExpressionTest extends BaseTest {

  @Test
  public void testCast() {
    CastExpression castExpression = new CastExpression(TypeReference.get(int.class), new VariableReference("a"));
    generateAndCompare("TestCast", castExpression);
  }
}
