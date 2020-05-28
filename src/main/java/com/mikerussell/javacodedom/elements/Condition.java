package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;
import com.mikerussell.javacodedom.core.StatementCollection;

public class Condition implements Statement {
	private StatementCollection _true = new StatementCollection();
	private StatementCollection _false = new StatementCollection();
	private Expression _expression;

	public Condition() {
	}

	public Condition(Expression expression, StatementCollection ifTrue, StatementCollection ifFalse) {
		_expression = expression;
		_true = ifTrue;
		_false = ifFalse;
	}

	public Expression getExpression() {
		return _expression;
	}

	public Condition setExpression(Expression expression) {
		_expression = expression;
		return this;
	}

	public StatementCollection getTrueStatements() {
		return _true;
	}

	public Condition addTrueStatement(Statement statement) {
		_true.addStatement(statement);
		return this;
	}

	public Condition addTrueStatements(Statement... statements) {
		_true.addStatements(statements);
		return this;
	}

	public StatementCollection getFalseStatements() {
		return _false;
	}

	public Condition addFalseStatement(Statement statement) {
		_false.addStatement(statement);
		return this;
	}

	public Condition addFalseStatements(Statement... statements) {
		_false.addStatements(statements);
		return this;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("if (");
		_expression.generate(output, context);
		output.append(") {");
		output.newLineIncreasingIndent();
		_true.generate(output, context);
		output.newLineDecreasingIndent();
		output.append("}");
		if (_false.size() > 0) {
			output.append(" else {");
			output.newLineIncreasingIndent();
			_false.generate(output, context);
			output.newLineDecreasingIndent();
			output.append("}");
		}
	}

}