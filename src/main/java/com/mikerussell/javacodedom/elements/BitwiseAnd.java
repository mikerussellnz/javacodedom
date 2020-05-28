package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseAnd extends BinaryOperator {

	public BitwiseAnd(Expression left, Expression right) {
		super(left, "&", right);
	}
}