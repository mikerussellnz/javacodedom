package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;
import com.mikerussell.javacodedom.core.StatementCollection;

public class ForeachLoop implements Statement {
	private final VariableDeclaration _itemVariable;
	private final Expression _collection;
	private Expression _expr;
	private Statement _increment;

	private StatementCollection _statements = new StatementCollection();

	public ForeachLoop(VariableDeclaration itemVariable, Expression collection) {
		_itemVariable = itemVariable;
		_collection = collection;
	}

	public StatementCollection getStatements() {
		return _statements;
	}

	public ForeachLoop addStatement(CanActAsStatement statement) {
		_statements.addStatement(statement);
		return this;
	}

	public ForeachLoop addStatements(CanActAsStatement... statements) {
		_statements.addStatements(statements);
		return this;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("for (");
		_itemVariable.generateWithoutSemiColon(output, context);
		output.append(" : ");
		_collection.generate(output, context);
		output.append(") {");
		output.newLineIncreasingIndent();
		_statements.generate(output, context);
		output.newLineDecreasingIndent();
		output.append("}");
	}
}