package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.elements.MethodInvocation;

import java.util.ArrayList;

public class StatementCollection extends ArrayList<Statement> {

  public StatementCollection addStatement(CanActAsStatement statement) {
    if (statement instanceof Statement) {
      add((Statement) statement);
    } else if (statement instanceof CanActAsStatement) {
      add(new ExpressionStatement((Expression) statement));
    }
    return this;
  }

  public StatementCollection addStatements(CanActAsStatement... statements) {
    for (CanActAsStatement statement : statements) {
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
