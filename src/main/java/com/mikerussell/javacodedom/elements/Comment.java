package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Statement;

public class Comment implements Statement{
	private String _text;

	public Comment(String text) {
		_text = text;
	}

	public void generate(OutputWriter output, GenerationContext context) {
		output.append("/* ");
		output.append(_text);
		output.append(" */");
	}
}