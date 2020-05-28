package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.CanActAsStatement;
import com.mikerussell.javacodedom.core.Expression;

public class AddAssign extends BinaryOperator implements CanActAsStatement {
    public AddAssign(Expression left, Expression right) {
        super(left, "+=", right);
    }
}
