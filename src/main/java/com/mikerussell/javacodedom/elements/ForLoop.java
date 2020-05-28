package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;
import com.mikerussell.javacodedom.core.StatementCollection;

public class ForLoop implements Statement {
	private Statement _initializtaion;
	private Expression _expr;
	private Statement _increment;

	private StatementCollection _statements = new StatementCollection();

	public ForLoop(Statement initializtaion, Expression expr, Statement increment) {
		_initializtaion = initializtaion;
		_expr = expr;
		_increment = increment;
	}

	public StatementCollection getStatements() {
		return _statements;
	}

	public ForLoop addStatement(Statement statement) {
		_statements.addStatement(statement);
		return this;
	}

	public ForLoop addStatements(Statement... statements) {
		for (Statement statement: statements) {
			_statements.addStatement(statement);
		}
		return this;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("for (");
		_initializtaion.generate(output, context);
		output.append(" ");
		_expr.generate(output, context);
		output.append(";");
		output.append(" ");
		_increment.generate(output, context);
		output.append(") {");
		output.newLineIncreasingIndent();
		_statements.generate(output, context);
		output.newLineDecreasingIndent();
		output.append("}");
	}
}