package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.DelimiterSeparatedList;

import java.util.ArrayList;

public class GenericParameter implements CodeElement {
  private String _alias;
  private DelimiterSeparatedList<TypeReference> _bounds = new DelimiterSeparatedList<>(" & ");

  public GenericParameter(String alias) {
    _alias = alias;
  }

  public ArrayList<TypeReference> getBounds() {
    return _bounds;
  }

  public GenericParameter addBound(TypeReference bound) {
    _bounds.add(bound);
    return this;
  }

  @Override
  public void generate(OutputWriter output, GenerationContext context) {
    output.append(_alias);
    if (_bounds.size() > 0) {
      output.append(" extends ");
      _bounds.generate(output, context);
    }
  }
}
