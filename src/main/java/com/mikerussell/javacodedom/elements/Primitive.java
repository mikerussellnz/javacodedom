package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;

public class Primitive implements Expression {
	private Object _value;

	public Primitive(Object value) {
		_value = value;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		if (_value instanceof String) {
			output.append("\"");
		}
		output.append(String.valueOf(_value));
		if (_value instanceof String) {
			output.append("\"");
		}
	}
}