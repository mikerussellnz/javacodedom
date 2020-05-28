package com.mikerussell.javacodedom.core;

import com.mikerussell.javacodedom.OutputWriter;

public class AccessModifier {
  public static final int DEFAULT = 0;
  public static final int PUBLIC = 1;
  public static final int PRIVATE = 2;
  public static final int PROTECTED = 4;
  public static final int STATIC = 8;
  public static final int ABSTRACT = 16;
  public static final int FINAL = 32;

  private static boolean isStatic(int flags) {
    return (flags & STATIC) == STATIC;
  }

  private static boolean isPublic(int flags) {
    return (flags & PUBLIC) == PUBLIC;
  }

  private static boolean isPrivate(int flags) {
    return (flags & PRIVATE) == PRIVATE;
  }

  private static boolean isProtected(int flags) {
    return (flags & PROTECTED) == PROTECTED;
  }

  private static boolean isAbstract(int flags) {
    return (flags & ABSTRACT) == ABSTRACT;
  }

  private static boolean isFinal(int flags) {
    return (flags & FINAL) == FINAL;
  }

  public static void generate(int flags, OutputWriter output) {
    if (isPublic(flags)) {
      output.append("public ");
    } else if (isPrivate(flags)) {
      output.append("private ");
    } else if (isProtected(flags)) {
      output.append("protected ");
    }
    if (isStatic(flags)) {
      output.append("static ");
    } else {
      if (isAbstract(flags)) {
        output.append("abstract ");
      }
    }
    if (isFinal(flags)) {
      output.append("final ");
    }
  }
}
