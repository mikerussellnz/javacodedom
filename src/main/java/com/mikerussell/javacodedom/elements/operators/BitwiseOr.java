package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseOr extends BinaryOperator {

	public BitwiseOr(Expression left, Expression right) {
		super(left, "|", right);
	}
}