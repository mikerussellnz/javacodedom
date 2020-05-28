package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;

public class AnnotationRef extends TypeReference {
	private Primitive _value;

	public AnnotationRef(String typeName) {
		super(typeName);
	}

	public AnnotationRef(String packageName, String className) {
		super(packageName, className);
	}

	public AnnotationRef(String typeName, Primitive value) {
		super(typeName);
		_value = value;
	}

	public AnnotationRef(String packageName, String className, Primitive value) {
		super(packageName, className);
		_value = value;
	}

	public AnnotationRef(Class type) {
		super(type);
	}

	public AnnotationRef(Class type, Primitive value) {
		super(type);
		_value = value;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("@");
		super.generate(output, context);
		if (_value != null) {
			output.append("(");
			_value.generate(output, context);
			output.append(")");
		}
	}
}