package com.mikerussell.javacodedom;

import com.mikerussell.javacodedom.elements.TypeReference;

import java.util.ArrayList;
import java.util.List;

public class GenerationContext {
    private List<TypeReference> _typeReferences = new ArrayList<>();

    public void addTypeReference(TypeReference typeReference) {
        _typeReferences.add(typeReference);
    }

    public List<TypeReference> getTypeReferences() {
        return _typeReferences;
    }
}
