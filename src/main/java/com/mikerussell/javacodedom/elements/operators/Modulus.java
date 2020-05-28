package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Modulus extends BinaryOperator {

	public Modulus(Expression left, Expression right) {
		super(left, "%", right);
	}
}