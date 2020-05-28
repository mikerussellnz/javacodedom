package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Statement;
import com.mikerussell.javacodedom.core.StatementCollection;

import java.util.ArrayList;

public class TryCatchFinally implements Statement {
	private StatementCollection _statements = new StatementCollection();
	private ArrayList<CatchClause> _catchClauses = new ArrayList<>();
	private StatementCollection _finallyStatements = new StatementCollection();

	public TryCatchFinally() {
	}

	public TryCatchFinally(StatementCollection statements, ArrayList<CatchClause> catchClauses, StatementCollection finallyStatements) {
		_statements = statements;
		_catchClauses = catchClauses;
		_finallyStatements = finallyStatements;
	}

	public StatementCollection getStatements() {
		return _statements;
	}

	public TryCatchFinally addStatement(Statement statement) {
		_statements.addStatement(statement);
		return this;
	}

	public TryCatchFinally addStatements(Statement... statements) {
		for (Statement statement: statements) {
			_statements.addStatement(statement);
		}
		return this;
	}

	public StatementCollection getFinallyStatements() {
		return _finallyStatements;
	}

	public TryCatchFinally addFinallyStatement(Statement statement) {
		_finallyStatements.addStatement(statement);
		return this;
	}

	public TryCatchFinally addFinallyStatements(Statement... statements) {
		for (Statement statement: statements) {
			_finallyStatements.addStatement(statement);
		}
		return this;
	}

	public ArrayList<CatchClause> getCatchClauses() {
		return _catchClauses;
	}

	public TryCatchFinally addCatchClause(CatchClause catchClause) {
		_catchClauses.add(catchClause);
		return this;
	}

	public TryCatchFinally addCatchClause(CatchClause... statements) {
		for (CatchClause catchClause: statements) {
			_catchClauses.add(catchClause);
		}
		return this;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("try {");
		output.newLineIncreasingIndent();
		_statements.generate(output, context);
		output.newLineDecreasingIndent();
		output.append("}");
		for (CatchClause catchClause: _catchClauses) {
			output.append(" ");
			catchClause.generate(output, context);
		}
		output.append(" finally {");
		output.newLineIncreasingIndent();
		_finallyStatements.generate(output, context);
		output.newLineDecreasingIndent();
		output.append("}");
	}
}