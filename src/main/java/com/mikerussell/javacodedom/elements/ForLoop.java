package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.ExpressionStatement;
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

	public ForLoop(Statement initializtaion, Expression expr, Expression increment) {
		_initializtaion = initializtaion;
		_expr = expr;
		_increment = new ExpressionStatement(increment);
	}

	public StatementCollection getStatements() {
		return _statements;
	}

	public ForLoop addStatement(CanActAsStatement statement) {
		_statements.addStatement(statement);
		return this;
	}

	public ForLoop addStatements(CanActAsStatement... statements) {
		_statements.addStatements(statements);
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