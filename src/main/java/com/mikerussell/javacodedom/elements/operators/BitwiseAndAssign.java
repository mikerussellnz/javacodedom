package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseAndAssign extends BinaryOperator implements CanActAsStatement {

	public BitwiseAndAssign(Expression left, Expression right) {
		super(left, "&=", right);
	}
}