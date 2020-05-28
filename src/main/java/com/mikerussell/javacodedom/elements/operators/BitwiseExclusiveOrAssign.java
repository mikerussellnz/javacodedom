package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseExclusiveOrAssign extends BinaryOperator {

	public BitwiseExclusiveOrAssign(Expression left, Expression right) {
		super(left, "^=", right);
	}
}