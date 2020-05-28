# javacodedom
Java Code Generator inspired by Microsoft CodeDom.

Designed to automatically generate code without appending using string builders.  

### Advantages 
* Apply's correct indentation which is tedious to do with StringBuilder. 
* Generates correct syntax for constructs automatically.
* Less error prone - Uses Java typing to disallow certain invalid constructs. 
* Encourages use of TypeReferences and VariableReferences rather than Strings to refer to types. Reduces chances of typo's and enables compile time checking of references to members, variables and types. 

### Dependencies

Requires no additional dependencies. 

## Supports Generating these Code Constructs
* Binary operators + - / * % < <= > >= == != || && | & += -= /= *= %= |= ^= &=
* Pre and Post increment and decrement operators.
* Class and Interface Declarations
* Support for nested inner classes / interfaces.
* Cast Expression
* Try, Catch, Finally exception handling.
* Throwing of exceptions
* Field and method declarations.
* Method invocation.
* Method throws declarations.
* Return values
* Defining and using generic methods
* Defining and using generic types
* For loop, While loop, Do While loop
* Package statement
* Import Statements
* Creation of Objects and Arrays
* Annotations

## Todo
* Different indentation styles (tabs / spaces, number of spaces)
* Annotations Declarations
* foreach loop
* Java 8 stuff - Lambda expressions. 

## Example: Work in progress JDBC reader generator:

```
    CompilationUnit compilationUnit = new CompilationUnit();
    compilationUnit.setPackageName(outputPackageName);
    
    TypeReference resultSetType = new TypeReference(java.sql.ResultSet.class);
    TypeReference sqlExceptionType = new TypeReference(java.sql.SQLException.class);
    
    compilationUnit.addImport(resultSetType);
    compilationUnit.addImport(sqlExceptionType);
    
    ClassDeclaration classDeclaration = new ClassDeclaration(clz.getSimpleName() + "Reader");
    compilationUnit.addTypeDeclaration(classDeclaration);
    TypeReference targetClass = new TypeReference(clz);

    MethodDeclaration readMethod = new MethodDeclaration(AccessModifier.PUBLIC, "read");
    readMethod.addThrows(sqlExceptionType);
    readMethod.setReturnType(targetClass);
    MethodArgument resultSetArg = new MethodArgument(resultSetType, "resultSet");
    readMethod.addArgument(resultSetArg);
    VariableReference resultSetReference = resultSetArg.getReference();
    classDeclaration.addMethod(readMethod);

    VariableDeclaration targetDeclaration = new VariableDeclaration(targetClass, "target")
      .initializeWith(new CreateObject(targetClass));
    readMethod.addStatement(targetDeclaration);

    VariableReference targetReference = targetDeclaration.getReference();

    Field[] fields = clz.getDeclaredFields();
    for (Field field : fields) {
      DatabaseField dbField = field.getAnnotation(DatabaseField.class);
      if (dbField == null) {
        continue;
      }
      String columnName = dbField.column();
      String getMethodName = getGetMethodName(field.getType());  // ommitted - returns getString, getInt etc.
      Expression srcValue = new MethodInvocation(resultSetReference, getMethodName)
        .addArgument(new Primitive(columnName));

      Method setMethod = resolveSetMethod(clz, field);
      readMethod.addStatement(new ExpressionStatement(new MethodInvocation(targetReference, setMethod.getName())
        .addArgument(srcValue)));
    }
    readMethod.addStatement(new Return(targetReference));
    return compilationUnit;
```

Will generate output code like this:

```
package com.example.db.readers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExampleClassReader {
    public ExampleClass read(ResultSet resultSet) throws SQLException {
        ExampleClass target = new ExampleClass();
        target.setName(resultSet.getString("name"));
        target.setAge(resultSet.getInt("age"));
        target.setAddress(resultSet.getString("address"));
        return target;
    }
}
```
