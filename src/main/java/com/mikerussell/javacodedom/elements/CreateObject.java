package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;
import com.mikerussell.javacodedom.core.Expression;

import java.util.ArrayList;

public class CreateObject implements Expression {
	private TypeReference _type;
	private DelimiterSeparatedList<Expression> _constructorArgs = new DelimiterSeparatedList<>(", ");
	private DelimiterSeparatedList<TypeReference> _genericParameters = new DelimiterSeparatedList<>(", ");

	public CreateObject(TypeReference type, DelimiterSeparatedList<Expression> constructorArgs) {
		_type = type;
		_constructorArgs = constructorArgs;
	}

	public CreateObject(TypeReference type) {
		_type = type;
	}

	public TypeReference getType() {
		return _type;
	}

	public void setType(TypeReference type) {
		_type = type;
	}

	public ArrayList<Expression> getArguments() {
		return _constructorArgs;
	}

	public CreateObject addArgument(Expression arg) {
		_constructorArgs.add(arg);
		return this;
	}

	public CreateObject addGenericParameter(TypeReference arg) {
		_genericParameters.add(arg);
		return this;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("new ");
		_type.generate(output, context);
		if (_genericParameters.size() > 0) {
			output.append("<");
			_genericParameters.generate(output, context);
			output.append(">");
		}
		output.append("(");
		_constructorArgs.generate(output, context);
		output.append(")");
	}
}