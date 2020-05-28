package com.mikerussell.javacodedom.elements.internal;

import com.mikerussell.javacodedom.elements.TypeDeclaration;
import com.mikerussell.javacodedom.elements.TypeReference;

public class TypeDeclarationTypeReference extends TypeReference {
    private final TypeDeclaration _type;

    public TypeDeclarationTypeReference(TypeDeclaration typeDeclaration) {
        _type = typeDeclaration;
    }

    @Override
    public String getClassName() {
        return _type.getName();
    }

    @Override
    public String getPackageName() {
        return null; // todo:
    }
}
