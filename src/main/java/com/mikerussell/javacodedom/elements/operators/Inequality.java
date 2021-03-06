package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class Inequality extends BinaryOperator {

	public Inequality(Expression left, Expression right) {
		super(left, "!=", right);
	}
}