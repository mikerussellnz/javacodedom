package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;

public class Assign implements Statement {
	private Expression _left;
	private Expression _rightExpr;
	private Statement _rightStatement;

	public Assign(Expression left, Statement right) {
		_left = left;
		_rightStatement = right;
	}

	public Assign(Expression left, Expression right) {
		_left = left;
		_rightExpr = right;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		_left.generate(output, context);
		output.append(" = ");
		if (_rightExpr != null) {
			_rightExpr.generate(output, context);
			output.append(";");
		} else {
			_rightStatement.generate(output, context);
		}
	}
}