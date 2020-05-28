package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;

import java.util.ArrayList;

public class CompilationUnit implements CodeElement {
  private Package _package;
  private ArrayList<TypeReference> _imports = new ArrayList<>();
  private ArrayList<ClassDeclaration> _typeDeclarations = new ArrayList<>();

  public CompilationUnit() {
  }

  public Package getPackage() {
    return this._package;
  }

  public void setPackage(Package aPackage) {
    this._package = aPackage;
  }

  public void setPackageName(String packageName) {
    this._package = new Package(packageName);
  }

  public ArrayList<TypeReference> getImports() {
    return _imports;
  }

  public CompilationUnit addImport(TypeReference imp) {
    _imports.add(imp);
    return this;
  }

  public ArrayList<ClassDeclaration> getTypeDeclarations() {
    return _typeDeclarations;
  }

  public CompilationUnit addTypeDeclaration(ClassDeclaration classDeclaration) {
    _typeDeclarations.add(classDeclaration);
    return this;
  }

  public void generate(OutputWriter output, GenerationContext context) {
    if (_package != null) {
      _package.generate(output, context);
      output.newLine();
      output.newLine();
    }
    for (TypeReference importStatement: _imports) {
      output.append("import ");
      importStatement.generateFull(output, context);
      output.append(";");
      output.newLine();
    }
    if (_imports.size() > 0) {
      output.newLine();
    }
    for (ClassDeclaration typeDeclaration: _typeDeclarations) {
      typeDeclaration.generate(output, context);
    }
  }

}
