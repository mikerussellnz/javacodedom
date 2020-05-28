package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;

public class BitwiseOrAssign extends BinaryOperator implements CanActAsStatement {

	public BitwiseOrAssign(Expression left, Expression right) {
		super(left, "|=", right);
	}
}