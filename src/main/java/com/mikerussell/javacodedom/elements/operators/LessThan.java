package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class LessThan extends BinaryOperator {

	public LessThan(Expression left, Expression right) {
		super(left, "<", right);
	}
}