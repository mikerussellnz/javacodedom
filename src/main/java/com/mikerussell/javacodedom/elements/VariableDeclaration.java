package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.ExpressionStatement;
import com.mikerussell.javacodedom.core.Statement;

public class VariableDeclaration implements Statement {
	private TypeReference _type;
	private String _name;
	private Statement _initializer;

	public VariableDeclaration(TypeReference type, String varName) {
		_type = type;
		_name = varName;
	}

	public VariableDeclaration initializeWith(Statement initializer) {
		_initializer = initializer;
		return this;
	}

	public VariableDeclaration initializeWith(Expression expression) {
		_initializer = new ExpressionStatement(expression);
		return this;
	}

	public VariableReference getReference() {
		return new VariableReference(_name);
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		_type.generate(output, context);
		output.append(" ");
		output.append(_name);
		if (_initializer != null) {
			output.append(" = ");
			_initializer.generate(output, context);
		} else {
			output.append(";");
		}
	}
}