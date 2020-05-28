package com.mikerussell.javacodedom;

import com.mikerussell.javacodedom.elements.CompilationUnit;

import java.io.FileWriter;
import java.io.IOException;

public class JavaCodeGenerator {
  public static void generateCode(CompilationUnit compilationUnit, String outputFilename) throws IOException {
    try (FileWriter fileWriter = new FileWriter(outputFilename)) {
      OutputWriter outputWriter = new OutputWriter(fileWriter);
      compilationUnit.generate(outputWriter, new GenerationContext());
    }
  }
}
