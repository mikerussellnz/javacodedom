package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;

public class Return implements Statement {
	private Expression _returnVal;

	public Return() {
	}

	public Return(Expression returnVal) {
		_returnVal = returnVal;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		if (_returnVal == null) {
			output.append("return;");
		} else {
			output.append("return ");
			_returnVal.generate(output, context);
			output.append(";");
		}
	}
}