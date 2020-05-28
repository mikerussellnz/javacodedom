package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class SubtractAssign extends BinaryOperator {

	public SubtractAssign(Expression left, Expression right) {
		super(left, "-=", right);
	}
}