package com.mikerussell.javacodedom.elements.internal;

import com.mikerussell.javacodedom.elements.TypeReference;

public class JavaNameTypeReference extends TypeReference {
    private String _package;
    private String _name;

    public JavaNameTypeReference(String typeName) {
        _name = typeName;
        _isJavaLangClass = true;
    }

    public JavaNameTypeReference(String packageName, String typeName) {
        _package = packageName;
        _name = typeName;
        _isJavaLangClass = JAVA_LANG_PACKAGE_NAME.equals(packageName);
    }

    @Override
    public String getClassName() {
        return _name;
    }

    @Override
    public String getFullPackageName() {
        return _package;
    }
}
