package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;

public class BinaryOperator implements Expression {
	private Expression _left;
	private Expression _right;
	private String _operator;

	public BinaryOperator(Expression left, String operator, Expression right) {
		_left = left;
		_operator = operator;
		_right = right;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		_left.generate(output, context);
		output.append(" " + _operator + " ");
		_right.generate(output, context);
	}
}