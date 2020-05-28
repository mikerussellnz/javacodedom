package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;

public class PreDecrement implements Expression, CanActAsStatement {
  private Expression _applyTo;

  public PreDecrement(Expression applyTo) {
    _applyTo = applyTo;
  }

  @Override
  public void generate(OutputWriter output, GenerationContext context) {
    output.append("--");
    _applyTo.generate(output, context);
    output.append("");
  }
}
