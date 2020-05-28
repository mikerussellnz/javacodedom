package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;

public interface CodeElement {
  void generate(OutputWriter output, GenerationContext context);
}
