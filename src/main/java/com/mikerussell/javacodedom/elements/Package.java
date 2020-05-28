package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.GenerationContext;
import com.mikerussell.javacodedom.OutputWriter;
import com.mikerussell.javacodedom.core.Parent;
import com.mikerussell.javacodedom.core.Statement;

public class Package implements Statement, Parent {
	private String _name;

	public Package(String packageName) {
		_name = packageName;
	}

	@Override
	public void generate(OutputWriter output, GenerationContext context) {
		output.append("package ");
		output.append(_name);
		output.append(";");
	}

	@Override
	public String getFullName() {
		return _name;
	}
}