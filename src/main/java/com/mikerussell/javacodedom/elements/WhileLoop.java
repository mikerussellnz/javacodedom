package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;
import com.mikerussell.javacodedom.core.StatementCollection;

public class WhileLoop implements Statement {
  private Expression _expr;

  private StatementCollection _statements = new StatementCollection();

  public WhileLoop(Expression expr) {
    _expr = expr;
  }

  public StatementCollection getStatements() {
    return _statements;
  }

  public WhileLoop addStatement(Statement statement) {
    _statements.addStatement(statement);
    return this;
  }

  public WhileLoop addStatements(Statement... statements) {
    for (Statement statement: statements) {
      _statements.addStatement(statement);
    }
    return this;
  }

  @Override
  public void generate(OutputWriter output, GenerationContext context) {
    output.append("while (");
    _expr.generate(output, context);
    output.append(") {");
    output.newLineIncreasingIndent();
    _statements.generate(output, context);
    output.newLineDecreasingIndent();
    output.append("}");
  }
}
