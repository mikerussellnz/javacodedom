package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class ModulusAssign extends BinaryOperator {

	public ModulusAssign(Expression left, Expression right) {
		super(left, "%=", right);
	}
}