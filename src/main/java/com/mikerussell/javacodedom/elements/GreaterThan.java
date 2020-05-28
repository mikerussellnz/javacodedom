package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class GreaterThan extends BinaryOperator {

	public GreaterThan(Expression left, Expression right) {
		super(left, ">", right);
	}
}