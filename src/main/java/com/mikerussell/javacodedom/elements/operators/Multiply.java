package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Multiply extends BinaryOperator {

	public Multiply(Expression left, Expression right) {
		super(left, "*", right);
	}
}