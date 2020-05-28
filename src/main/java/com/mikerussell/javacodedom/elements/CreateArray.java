package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;

public class CreateArray implements Expression {
	private TypeReference _type;
	private int _length;

	public CreateArray(TypeReference type, int length) {
		_type = type;
		_length = length;
	}

	public TypeReference getType() {
		return _type;
	}

	public void setType(TypeReference type) {
		_type = type;
	}

	public int getLength() {
		return _length;
	}

	public void setLength(int length) {
		_length = length;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("new ");
		_type.generate(output, context);
		output.append("[" + _length + "]");
	}
}