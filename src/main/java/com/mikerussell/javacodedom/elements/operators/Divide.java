package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Divide extends BinaryOperator {

	public Divide(Expression left, Expression right) {
		super(left, "/", right);
	}
}