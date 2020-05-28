package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;

public class CastExpression implements Expression {
	private TypeReference _type;
	private Expression _expression;

	public CastExpression(TypeReference type, Expression expr) {
		_type = type;
		_expression = expr;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("(");
		_type.generate(output, context);
		output.append(")");
		_expression.generate(output, context);
	}
}