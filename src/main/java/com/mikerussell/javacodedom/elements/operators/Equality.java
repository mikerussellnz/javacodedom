package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Equality extends BinaryOperator {

	public Equality(Expression left, Expression right) {
		super(left, "==", right);
	}
}