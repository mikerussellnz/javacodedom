package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;

public class IndexReference implements Expression {
	private Expression _target;
	private int _index;

	public IndexReference(Expression target, int index) {
		_target = target;
		_index = index;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		_target.generate(output, context);
		output.append("[" + _index + "]");
	}
}