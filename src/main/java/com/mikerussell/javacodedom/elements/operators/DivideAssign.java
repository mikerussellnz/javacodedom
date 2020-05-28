package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class DivideAssign extends BinaryOperator {

	public DivideAssign(Expression left, Expression right) {
		super(left, "/=", right);
	}
}