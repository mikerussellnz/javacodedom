package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;

public class VariableReference implements Expression {
	private String _name;

	public VariableReference(String varName) {
		_name = varName;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append(_name);
	}
}