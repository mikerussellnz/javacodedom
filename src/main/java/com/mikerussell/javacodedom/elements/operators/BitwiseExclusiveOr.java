package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseExclusiveOr extends BinaryOperator {

	public BitwiseExclusiveOr(Expression left, Expression right) {
		super(left, "^", right);
	}
}