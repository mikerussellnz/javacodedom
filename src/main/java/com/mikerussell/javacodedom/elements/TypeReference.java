package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;
import com.mikerussell.javacodedom.elements.internal.JavaClassTypeReference;
import com.mikerussell.javacodedom.elements.internal.JavaNameTypeReference;
import com.mikerussell.javacodedom.elements.internal.TypeDeclarationTypeReference;

public abstract class TypeReference implements CodeElement {

	public static final String JAVA_LANG_PACKAGE_NAME = "java.lang";
	public static final java.lang.Package JAVA_LANG_PACKAGE = Package.class.getPackage();

	public static final TypeReference BYTE = TypeReference.get(byte.class, true);
	public static final TypeReference SHORT = TypeReference.get(short.class, true);
	public static final TypeReference INT = TypeReference.get(int.class, true);
	public static final TypeReference LONG = TypeReference.get(long.class, true);
	public static final TypeReference FLOAT = TypeReference.get(float.class, true);
	public static final TypeReference DOUBLE = TypeReference.get(double.class, true);
	public static final TypeReference BOOLEAN = TypeReference.get(boolean.class, true);
	public static final TypeReference CHAR = TypeReference.get(char.class, true);

	public static final TypeReference C_BYTE = TypeReference.get(Byte.class, true);
	public static final TypeReference C_SHORT = TypeReference.get(Short.class, true);
	public static final TypeReference C_INT = TypeReference.get(Integer.class, true);
	public static final TypeReference C_LONG = TypeReference.get(Long.class, true);
	public static final TypeReference C_FLOAT = TypeReference.get(Float.class, true);
	public static final TypeReference C_DOUBLE = TypeReference.get(Double.class, true);
	public static final TypeReference C_BOOLEAN = TypeReference.get(Boolean.class, true);
	public static final TypeReference C_CHAR = TypeReference.get(Character.class, true);

	public static final TypeReference VOID = TypeReference.get(void.class, true);
	public static final TypeReference C_VOID = TypeReference.get(Void.class, true);

	public static final TypeReference OBJECT = TypeReference.get(Object.class, true);
	public static final TypeReference CLASS = TypeReference.get(Class.class, true);
	public static final TypeReference STRING = TypeReference.get(String.class, true);

	protected Boolean _isJavaLangClass = false;

	private DelimiterSeparatedList<TypeReference> _genericParameters = new DelimiterSeparatedList<>(", ");

	public String getFullName() {
		return getPackageName() != null ? getPackageName() + "." + getClassName() : getClassName();
	}

	public abstract String getClassName();

	public abstract String getPackageName();

	public boolean needsImport() {
		return !_isJavaLangClass;
	}


	public static TypeReference get(String typeName) {
		return new JavaNameTypeReference(typeName);
	}

	public static TypeReference get(String packageName, String typeName) {
		return new JavaNameTypeReference(packageName, typeName);
	}

	public static TypeReference get(TypeDeclaration typeDeclaration) {
		return new TypeDeclarationTypeReference(typeDeclaration);
	}

	public static TypeReference get(Class type) {
		return new JavaClassTypeReference(type);
	}

	private static TypeReference get(Class type, boolean isJavaLangClass) {
		return new JavaClassTypeReference(type, isJavaLangClass);
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