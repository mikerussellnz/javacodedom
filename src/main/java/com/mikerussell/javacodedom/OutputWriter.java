package com.mikerussell.javacodedom;

import java.io.IOException;
import java.io.Writer;

public class OutputWriter {
  private Writer _output;
  private boolean _newLine = false;
  private int _indentationLevel = 0;

  public OutputWriter(Writer output) {
    _output = output;
  }

  public void append(String string) {
    try {
      if (_newLine) {
        _newLine = false;
        _output.write("\n");
        for (int i = 0; i < _indentationLevel; i++) {
          _output.write("    ");
        }
      }
      _output.write(string);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void append(char character) {
    append(character + "");
  }

  public void newLine() {
    if (_newLine == true) {
      try {
        _output.write("\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    _newLine = true;
  }

  public void increaseIndent() {
    _indentationLevel++;
  }

  public void decreaseIndent() {
    _indentationLevel--;
  }

  public void newLineIncreasingIndent() {
    _newLine = true;
    _indentationLevel++;
  }

  public void newLineDecreasingIndent() {
    _newLine = true;
    if (_indentationLevel == 0) {
      return;
    }
    _indentationLevel--;
  }
}
