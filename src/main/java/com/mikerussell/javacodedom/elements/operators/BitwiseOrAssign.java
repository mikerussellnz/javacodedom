package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseOrAssign extends BinaryOperator {

	public BitwiseOrAssign(Expression left, Expression right) {
		super(left, "|=", right);
	}
}