package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;

public class AnnotationRef implements CodeElement {
	private TypeReference _typeReference;
	private Primitive _value;

	public AnnotationRef(String typeName) {
		_typeReference = TypeReference.get(typeName);
	}

	public AnnotationRef(String packageName, String className) {
		_typeReference = TypeReference.get(packageName, className);
	}

	public AnnotationRef(String typeName, Primitive value) {
		_typeReference = TypeReference.get(typeName);
		_value = value;
	}

	public AnnotationRef(String packageName, String className, Primitive value) {
		_typeReference = TypeReference.get(packageName, className);
		_value = value;
	}

	public AnnotationRef(Class type) {
		_typeReference = TypeReference.get(type);
	}

	public AnnotationRef(Class type, Primitive value) {
		_typeReference = TypeReference.get(type);
		_value = value;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("@");
		_typeReference.generate(output, context);
		if (_value != null) {
			output.append("(");
			_value.generate(output, context);
			output.append(")");
		}
	}
}