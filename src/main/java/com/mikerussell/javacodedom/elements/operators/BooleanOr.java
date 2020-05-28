package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BooleanOr extends BinaryOperator {

	public BooleanOr(Expression left, Expression right) {
		super(left, "||", right);
	}
}