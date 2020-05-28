package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;

public class ThrowException implements Statement {
	private Expression _throwable;

	public ThrowException(Expression throwable) {
		_throwable = throwable;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("throw ");
		_throwable.generate(output, context);
		output.append(";");
	}
}