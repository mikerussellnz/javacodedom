package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.CodeElement;
import com.mikerussell.javacodedom.core.Parent;

import java.util.ArrayList;

public class CompilationUnit implements CodeElement, Parent {
  private Package _package;
  private ArrayList<TypeReference> _imports = new ArrayList<>();
  private ArrayList<TypeDeclaration> _typeDeclarations = new ArrayList<>();

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

  public ArrayList<TypeDeclaration> getTypeDeclarations() {
    return _typeDeclarations;
  }

  public CompilationUnit addTypeDeclaration(TypeDeclaration typeDeclaration) {
    if (typeDeclaration.getParent() != null) {
      throw new IllegalArgumentException("Type: " + typeDeclaration.getName() + " is already added to: "
          + typeDeclaration.getParent().getFullName());
    }
    typeDeclaration.setParent(this);
    _typeDeclarations.add(typeDeclaration);
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
    for (TypeDeclaration typeDeclaration: _typeDeclarations) {
      typeDeclaration.generate(output, context);
    }
  }

  @Override
  public String getFullName() {
    return _package != null ? _package.getFullName() : "";
  }
}
