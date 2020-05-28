package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.elements.MethodInvocation;

import java.util.ArrayList;

public class StatementCollection extends ArrayList<Statement> {

  public StatementCollection addStatement(Statement statement) {
    if (statement instanceof MethodInvocation) {
      add(new ExpressionStatement((Expression) statement));
    } else {
      add(statement);
    }
    return this;
  }

  public StatementCollection addStatements(Statement... statements) {
    for (Statement statement : statements) {
      addStatement(statement);
    }
    return this;
  }

  public void generate(OutputWriter output, GenerationContext context) {
    for (Statement statement: this) {
      statement.generate(output, context);
      output.newLine();
    }
  }
}
