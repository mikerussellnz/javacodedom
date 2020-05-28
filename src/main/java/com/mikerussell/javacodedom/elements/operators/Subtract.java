package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Subtract extends BinaryOperator {

	public Subtract(Expression left, Expression right) {
		super(left, "-", right);
	}
}