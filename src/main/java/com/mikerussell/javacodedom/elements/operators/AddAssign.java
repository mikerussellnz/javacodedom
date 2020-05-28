package com.mikerussell.javacodedom.elements.operators;

import com.mikerussell.javacodedom.core.BinaryOperator;
import com.mikerussell.javacodedom.core.Expression;

public class AddAssign extends BinaryOperator {
    public AddAssign(Expression left, Expression right) {
        super(left, "+=", right);
    }
}
