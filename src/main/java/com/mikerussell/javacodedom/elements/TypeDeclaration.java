package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.AccessModifier;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;
import com.mikerussell.javacodedom.core.Parent;

import java.util.ArrayList;
import java.util.List;

public abstract class TypeDeclaration<T> implements CodeElement, Parent {
    private int _accessModifier = AccessModifier.PUBLIC;
    private String _name;
    private Parent _parent;
    private ArrayList<FieldDeclaration> _fields = new ArrayList<>();
    private DelimiterSeparatedList<MethodDeclaration> _methods = new DelimiterSeparatedList<>("\n\n");
    private ArrayList<AnnotationRef> _annotations = new ArrayList<>();
    private DelimiterSeparatedList<GenericParameter> _genericParameters = new DelimiterSeparatedList<>(", ");
    private DelimiterSeparatedList<TypeDeclaration> _innerTypes = new DelimiterSeparatedList<>("\n\n");

    public TypeDeclaration(String name) {
        _name = name;
    }

    public TypeDeclaration(int accessModifier, String name) {
        _accessModifier = accessModifier;
        _name = name;
    }

    Parent getParent() {
        return _parent;
    }

    void setParent(Parent parent) {
        _parent = parent;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public List<FieldDeclaration> getFields() {
        return _fields;
    }

    public List<MethodDeclaration> getMethods() {
        return _methods;
    }

    public List<GenericParameter> getGenericParameters() {
        return _genericParameters;
    }

    public T addGenericParameter(GenericParameter genericParameter) {
        _genericParameters.add(genericParameter);
        return (T)this;
    }

    public T addMethod(MethodDeclaration method) {
        _methods.add(method);
        return (T)this;
    }

    public T addField(FieldDeclaration field) {
        _fields.add(field);
        return (T)this;
    }

    public T addAnnotation(AnnotationRef annotation) {
        _annotations.add(annotation);
        return (T)this;
    }

    public T addInnerType(TypeDeclaration innerType) {
        if (innerType._parent != null) {
            throw new IllegalArgumentException("Type: " + innerType.getName() + " is already added to: "
                + innerType._parent.getFullName());
        }
        innerType._parent = this;
        _innerTypes.add(innerType);
        return (T)this;
    }

    @Override
    public String getFullName() {
        if (_parent != null) {
            return _parent.getFullName() + "." + _name;
        } else {
            return _name;
        }
    }

    public String getFullPackageName() {
        return _parent != null ? _parent.getFullName() : "";
    }

    @Override
    public void generate(OutputWriter output, GenerationContext context) {
        if (_annotations.size() > 0) {
            for (AnnotationRef annotation: _annotations) {
                annotation.generate(output, context);
                output.newLine();
            }
        }
        AccessModifier.generate(_accessModifier, output);
        output.append(getTypeKeyword() + " ");
        output.append(_name);

        if (_genericParameters.size() > 0) {
            output.append("<");
            _genericParameters.generate(output, context);
            output.append(">");
        }

        writeExtendsAndImplements(output, context);

        output.append(" {");
        output.newLineIncreasingIndent();

        for (FieldDeclaration field: _fields) {
            field.generate(output, context);
            output.newLine();
        }

        if (_fields.size() > 0 && _methods.size() > 0) {
            output.newLine();
        }

        if (_methods.size() > 0) {
            _methods.generate(output, context);
            output.newLine();
        }

        if (_innerTypes.size() > 0) {
            _innerTypes.generate(output, context);
            output.newLine();
        }

        output.decreaseIndent();
        output.append("}");
    }

    protected void writeExtendsAndImplements(OutputWriter output, GenerationContext context) {
    }

    protected abstract String getTypeKeyword();
}
