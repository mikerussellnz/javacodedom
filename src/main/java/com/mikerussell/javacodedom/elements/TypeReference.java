package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;

public class TypeReference implements CodeElement {

	public static final String JAVA_LANG_PACKAGE_NAME = "java.lang";
	public static final java.lang.Package JAVA_LANG_PACKAGE = Package.class.getPackage();

	public static final TypeReference BYTE = new TypeReference(byte.class, true);
	public static final TypeReference SHORT = new TypeReference(short.class, true);
	public static final TypeReference INT = new TypeReference(int.class, true);
	public static final TypeReference LONG = new TypeReference(long.class, true);
	public static final TypeReference FLOAT = new TypeReference(float.class, true);
	public static final TypeReference DOUBLE = new TypeReference(double.class, true);
	public static final TypeReference BOOLEAN = new TypeReference(boolean.class, true);
	public static final TypeReference CHAR = new TypeReference(char.class, true);

	public static final TypeReference C_BYTE = new TypeReference(Byte.class, true);
	public static final TypeReference C_SHORT = new TypeReference(Short.class, true);
	public static final TypeReference C_INT = new TypeReference(Integer.class, true);
	public static final TypeReference C_LONG = new TypeReference(Long.class, true);
	public static final TypeReference C_FLOAT = new TypeReference(Float.class, true);
	public static final TypeReference C_DOUBLE = new TypeReference(Double.class, true);
	public static final TypeReference C_BOOLEAN = new TypeReference(Boolean.class, true);
	public static final TypeReference C_CHAR = new TypeReference(Character.class, true);

	public static final TypeReference VOID = new TypeReference(void.class, true);
	public static final TypeReference C_VOID = new TypeReference(Void.class, true);

	public static final TypeReference OBJECT = new TypeReference(Object.class, true);
	public static final TypeReference CLASS = new TypeReference(Class.class, true);
	public static final TypeReference STRING = new TypeReference(String.class, true);

	private String _package;
	private String _name;
	private Class _type;
	private Boolean _isJavaLangClass = false;

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
			java.lang.Package clzPackage = _type.getPackage();
			if (clzPackage == null) {
				return null;
			} else {
				return clzPackage.getName();
			}
		} else if (_package != null && !_package.equals("")) {
			return _package;
		}
		return null;
	}

	public boolean needsImport() {
		return !_isJavaLangClass;
	}

	public String getFullName() {
		return getPackage() != null ? getPackage() + "." + getClassName() : getClassName();
	}

	public TypeReference(String typeName) {
		_name = typeName;
		_isJavaLangClass = true;
	}

	public TypeReference(String packageName, String typeName) {
		_package = packageName;
		_name = typeName;
		_isJavaLangClass = packageName.equals(JAVA_LANG_PACKAGE_NAME);
	}

	public TypeReference(Class type) {
		_type = type;
		_isJavaLangClass = type.getPackage() == JAVA_LANG_PACKAGE;
	}

	private TypeReference(Class type, boolean isJavaLangClass) {
		_type = type;
		_isJavaLangClass = isJavaLangClass;
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