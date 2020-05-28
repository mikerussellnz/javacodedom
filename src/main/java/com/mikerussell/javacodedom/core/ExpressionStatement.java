package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;

public class ExpressionStatement implements Statement {
  private Expression _expression;

  public ExpressionStatement(Expression expression) {
    _expression = expression;
  }

  @Override
  public void generate(OutputWriter output, GenerationContext context) {
    _expression.generate(output, context);
    output.append(";");
  }
}
