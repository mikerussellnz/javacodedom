package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;

public class MultiplyAssign extends BinaryOperator implements CanActAsStatement {

	public MultiplyAssign(Expression left, Expression right) {
		super(left, "*=", right);
	}
}