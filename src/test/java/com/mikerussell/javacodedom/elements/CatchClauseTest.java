package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class CatchClauseTest extends BaseTest {

  @Test
  public void testCatchClause() {
    CatchClause clause = new CatchClause(new TypeReference(Exception.class), "exc")
      .addStatement(new VariableDeclaration(new TypeReference(Exception.class), "exc2").initializeWith(new VariableReference("exc")));
    generateAndCompare("TestCatchClause", clause);
  }
}
