package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;

public class InterfaceDeclaration extends TypeDeclaration<InterfaceDeclaration> {
	private DelimiterSeparatedList<TypeReference> _extends = new DelimiterSeparatedList<>(", ");

	public InterfaceDeclaration(String name) {
		super(name);
	}

	public InterfaceDeclaration(int accessModifier, String name) {
		super(accessModifier, name);
	}

	public InterfaceDeclaration addExtends(TypeReference extend) {
		_extends.add(extend);
		return this;
	}

	@Override
	protected void writeExtendsAndImplements(OutputWriter output, GenerationContext context) {
		if (_extends.size() > 0) {
			output.append(" extends ");
			_extends.generate(output, context);
		}
	}

	@Override
	protected String getTypeKeyword() {
		return "interface";
	}
}