package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class GreaterThanOrEqual extends BinaryOperator {

	public GreaterThanOrEqual(Expression left, Expression right) {
		super(left, ">=", right);
	}
}