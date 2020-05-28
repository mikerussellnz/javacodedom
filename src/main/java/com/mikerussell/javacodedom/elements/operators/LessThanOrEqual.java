package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class LessThanOrEqual extends BinaryOperator {

	public LessThanOrEqual(Expression left, Expression right) {
		super(left, "<=", right);
	}
}