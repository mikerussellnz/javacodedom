package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Add extends BinaryOperator {

	public Add(Expression left, Expression right) {
		super(left, "+", right);
	}
}