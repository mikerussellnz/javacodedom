package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;

import java.util.ArrayList;

public class DelimiterSeparatedList<E extends CodeElement> extends ArrayList<E> implements CodeElement {
  private String _delimiter;

  public DelimiterSeparatedList(String delimiter) {
    _delimiter = delimiter;
  }

  @Override
  public void generate(OutputWriter output, GenerationContext context) {
    for (int i = 0; i < size(); i++) {
      get(i).generate(output, context);
      if (i < size() -1) {
        outputDelimeter(output);
      }
    }
  }

  private void outputDelimeter(OutputWriter output) {
    for (int j = 0; j < _delimiter.length(); j++) {
      if (_delimiter.charAt(j) == '\n') {
        output.newLine();
      } else {
        output.append(_delimiter.charAt(j));
      }
    }
  }
}
