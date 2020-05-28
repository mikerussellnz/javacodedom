package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;
import com.mikerussell.javacodedom.core.Expression;

public class MethodInvocation implements Expression {
	private TypeReference _staticTypeReference;
	private Expression _target;
	private String _name;
	private DelimiterSeparatedList<Expression> _arguments = new DelimiterSeparatedList<>(", ");
	private DelimiterSeparatedList<TypeReference> _genericParameters = new DelimiterSeparatedList<>(", ");

	public MethodInvocation(String methodName) {
		_name = methodName;
	}

	public MethodInvocation(TypeReference staticTypeReference, String methodName) {
		_staticTypeReference = staticTypeReference;
		_name = methodName;
	}

	public MethodInvocation(TypeReference staticTypeReference, String methodName, DelimiterSeparatedList<Expression> arguments) {
		_staticTypeReference = staticTypeReference;
		_name = methodName;
		_arguments = arguments;
	}

	public MethodInvocation(Expression target, String methodName) {
		_target = target;
		_name = methodName;
	}

	public MethodInvocation(Expression target, String methodName, DelimiterSeparatedList<Expression> arguments) {
		_target = target;
		_name = methodName;
		_arguments = arguments;
	}

	public MethodInvocation addArgument(Expression arg) {
		_arguments.add(arg);
		return this;
	}

	public MethodInvocation addGenericParameter(TypeReference arg) {
		_genericParameters.add(arg);
		return this;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		if (_staticTypeReference != null) {
			_staticTypeReference.generate(output, context);
			output.append(".");
		} else if (_target != null) {
			_target.generate(output, context);
			output.append(".");
		}
		output.append(_name);
		if (_genericParameters.size() > 0) {
			output.append("<");
			_genericParameters.generate(output, context);
			output.append(">");
		}
		output.append("(");
		_arguments.generate(output, context);
		output.append(")");
	}
}