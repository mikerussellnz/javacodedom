package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseAndAssign extends BinaryOperator {

	public BitwiseAndAssign(Expression left, Expression right) {
		super(left, "&=", right);
	}
}