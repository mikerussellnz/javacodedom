package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;

public class FieldReference extends VariableReference {
	private Expression _target;

	public FieldReference(Expression target, String fieldName) {
		super(fieldName);
		_target = target;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		if (_target != null) {
			_target.generate(output, context);
		} else {
			output.append("this");
		}
		output.append(".");
		super.generate(output, context);
	}
}