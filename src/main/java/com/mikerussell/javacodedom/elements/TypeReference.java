package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;

public class TypeReference implements CodeElement {
	public static final TypeReference BYTE = new TypeReference("byte");
	public static final TypeReference SHORT = new TypeReference("short");
	public static final TypeReference INT = new TypeReference("int");
	public static final TypeReference LONG = new TypeReference("long");
	public static final TypeReference FLOAT = new TypeReference("float");
	public static final TypeReference DOUBLE = new TypeReference("double");
	public static final TypeReference BOOLEAN = new TypeReference("boolean");
	public static final TypeReference CHAR = new TypeReference("char");

	private String _package;
	private String _name;
	private Class _type;

	private DelimiterSeparatedList<TypeReference> _genericParameters = new DelimiterSeparatedList<>(", ");

	public String getClassName() {
		if (_type != null) {
			return _type.getSimpleName();
		} else {
			return _name;
		}
	}

	public String getPackage() {
		if (_type != null) {
			return _type.getPackage().getName();
		} else if (_package != null && !_package.equals("")) {
			return _package;
		}
		return null;
	}

	public String getFullName() {
		return getPackage() != null ? getPackage() + "." + getClassName() : getClassName();
	}

	public TypeReference(String typeName) {
		_name = typeName;
	}

	public TypeReference(String packageName, String typeName) {
		_package = packageName;
		_name = typeName;
	}

	public TypeReference(Class type) {
		_type = type;
	}

	public TypeReference addGenericParameter(TypeReference arg) {
		_genericParameters.add(arg);
		return this;
	}

	private void internalGenerate(OutputWriter output, GenerationContext context, boolean fullNames) {
		output.append(fullNames ? getFullName() : getClassName());
		if (_genericParameters.size() > 0) {
			output.append("<");
			_genericParameters.generate(output, context);
			output.append(">");
		}
	}

	public void generate(OutputWriter output, GenerationContext context) {
		internalGenerate(output, context, false);
		context.addTypeReference(this);
	}

	public void generateFull(OutputWriter output, GenerationContext context) {
		internalGenerate(output, context, true);
	}
}