package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;

public class Assign implements Statement {
	private Expression _left;
	private Expression _rightExpr;

	public Assign(Expression left, Expression right) {
		_left = left;
		_rightExpr = right;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		_left.generate(output, context);
		output.append(" = ");
		_rightExpr.generate(output, context);
		output.append(";");
	}
}