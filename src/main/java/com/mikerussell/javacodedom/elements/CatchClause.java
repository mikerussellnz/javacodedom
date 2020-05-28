package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.StatementCollection;

public class CatchClause implements CodeElement {
  private TypeReference _catchType;
  private String _varName;
  private StatementCollection _statements = new StatementCollection();

  public CatchClause(TypeReference catchType, String varName) {
    _catchType = catchType;
    _varName = varName;
  }

  public StatementCollection getStatements() {
    return _statements;
  }

  public CatchClause addStatement(CanActAsStatement statement) {
    _statements.addStatement(statement);
    return this;
  }

  public CatchClause addStatements(CanActAsStatement... statements) {
    _statements.addStatements(statements);
    return this;
  }

  public void generate(OutputWriter output, GenerationContext context) {
    output.append("catch (");
    _catchType.generate(output, context);
    output.append(" " + _varName);
    output.append(") {");
    output.newLineIncreasingIndent();
    _statements.generate(output, context);
    output.newLineDecreasingIndent();
    output.append("}");
  }
}
