package com.mikerussell.javacodedom.elements.internal;

import com.mikerussell.javacodedom.elements.TypeReference;

public class JavaClassTypeReference extends TypeReference {
    private final Class _type;

    public JavaClassTypeReference(Class type) {
        _type = type;
        _isJavaLangClass = type.getPackage() == JAVA_LANG_PACKAGE;
    }

    public JavaClassTypeReference(Class type, boolean isJavaLangClass) {
        _type = type;
        _isJavaLangClass = isJavaLangClass;
    }

    @Override
    public String getClassName() {
        return _type.getSimpleName();
    }

    @Override
    public String getPackageName() {
        Package pkg =  _type.getPackage();
        return pkg == null ? null : pkg.getName();
    }
}
