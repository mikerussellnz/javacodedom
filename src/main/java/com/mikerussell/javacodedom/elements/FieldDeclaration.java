package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.AccessModifier;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;
import com.mikerussell.javacodedom.core.Expression;
import com.mikerussell.javacodedom.core.Statement;

public class FieldDeclaration extends VariableDeclaration {
	private int _modifier;
	private DelimiterSeparatedList<AnnotationRef> _annotations = new DelimiterSeparatedList<>("\n");

	public FieldDeclaration(int modifier, TypeReference type, String name) {
		super(type, name);
		_modifier = modifier;
	}

	public FieldDeclaration initializeWith(Statement initializer) {
		super.initializeWith(initializer);
		return this;
	}

	public FieldDeclaration initializeWith(Expression expression) {
		super.initializeWith(expression);
		return this;
	}

	public FieldDeclaration addAnnotation(AnnotationRef annotationRef) {
		_annotations.add(annotationRef);
		return this;
	}

	public void generate(OutputWriter output, GenerationContext context) {
		if (_annotations.size() > 0) {
			_annotations.generate(output, context);
			output.newLine();
		}
		AccessModifier.generate(_modifier, output);
		super.generate(output, context);
	}
}