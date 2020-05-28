package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.*;
import com.mikerussell.javacodedom.core.*;

import java.util.ArrayList;
import java.util.List;

public class MethodDeclaration implements CodeElement {
	private int _modifier;
	private String _name;
	private DelimiterSeparatedList<TypeReference> _throws = new DelimiterSeparatedList<>(", ");
	private DelimiterSeparatedList<MethodArgument> _arguments = new DelimiterSeparatedList<>(", ");
	private TypeReference _returnType = TypeReference.VOID;

	private StatementCollection _statements = new StatementCollection();
	private List<AnnotationRef> _annotations = new ArrayList<>();

	public MethodDeclaration(int modifier, String name) {
		_modifier = modifier;
		_name = name;
	}

	public MethodDeclaration(int modifier, String name, DelimiterSeparatedList<MethodArgument> arguments, TypeReference returnType) {
		_modifier = modifier;
		_name = name;
		_arguments = arguments;
		_returnType = returnType;
	}

	public StatementCollection getStatements() {
		return _statements;
	}

	public MethodDeclaration addStatement(CanActAsStatement statement) {
		_statements.addStatement(statement);
		return this;
	}

	public MethodDeclaration addStatements(CanActAsStatement... statements) {
		_statements.addStatements(statements);
		return this;
	}

	public MethodDeclaration addThrows(TypeReference exceptionType) {
		_throws.add(exceptionType);
		return this;
	}

	public MethodDeclaration addArgument(MethodArgument argument) {
		_arguments.add(argument);
		return this;
	}

	public MethodDeclaration addArgument(TypeReference type, String name) {
		_arguments.add(new MethodArgument(type, name));
		return this;
	}

	public MethodDeclaration setReturnType(TypeReference returnType) {
		_returnType = returnType;
		return this;
	}

	public MethodDeclaration addAnnotation(AnnotationRef annotationRef) {
		_annotations.add(annotationRef);
		return this;
	}

	public void generate(OutputWriter output, GenerationContext context) {
		if (_annotations.size() > 0) {
			for (AnnotationRef annotation: _annotations) {
				annotation.generate(output, context);
				output.newLine();
			}
		}
		AccessModifier.generate(_modifier, output);
		_returnType.generate(output, context);
		output.append(" " + _name);
		output.append("(");
		_arguments.generate(output, context);
		output.append(")");
		if (_throws.size() > 0) {
			output.append(" throws ");
			_throws.generate(output, context);
		}
		output.append(" {");
		output.newLineIncreasingIndent();

		_statements.generate(output, context);

		output.newLineDecreasingIndent();
		output.append("}");
	}
}