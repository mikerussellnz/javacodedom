package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BooleanAnd extends BinaryOperator {

	public BooleanAnd(Expression left, Expression right) {
		super(left, "&&", right);
	}
}