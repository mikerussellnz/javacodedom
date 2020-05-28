package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;

import java.util.ArrayList;

public class ClassDeclaration extends TypeDeclaration<ClassDeclaration> {
	private TypeReference _extends;
	private DelimiterSeparatedList<TypeReference> _implements = new DelimiterSeparatedList<>(", ");

	public ClassDeclaration(String name) {
		super(name);
	}

	public ClassDeclaration(int accessModifier, String name) {
		super(accessModifier, name);
	}

	public TypeReference getExtends() {
		return _extends;
	}

	public ClassDeclaration setExtends(TypeReference extendsType) {
		_extends = extendsType;
		return this;
	}

	public ArrayList<TypeReference> getImplements() {
		return _implements;
	}

	public ClassDeclaration addImplements(TypeReference implementedInterface) {
		_implements.add(implementedInterface);
		return this;
	}

	@Override
	protected void writeExtendsAndImplements(OutputWriter output, GenerationContext context) {
		if (_extends != null) {
			output.append(" extends ");
			_extends.generate(output, context);
		}
		if (_implements.size() > 0) {
			output.append(" implements ");
			_implements.generate(output, context);
		}
	}

	@Override
	protected String getTypeKeyword() {
		return "class";
	}
}