package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;

public class MethodArgument implements CodeElement {
  private TypeReference _type;
  private String _name;
  private DelimiterSeparatedList<AnnotationRef> _annotations = new DelimiterSeparatedList<>(" ");

  public MethodArgument(TypeReference type, String name) {
    _type = type;
    _name = name;
  }

  public VariableReference getReference() {
    return new VariableReference(_name);
  }

  public MethodArgument addAnnotation(AnnotationRef annotationRef) {
    _annotations.add(annotationRef);
    return this;
  }

  public void generate(OutputWriter output, GenerationContext context) {
    _annotations.generate(output, context);
    _type.generate(output, context);
    output.append(" " + _name);
  }
}
