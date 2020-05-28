package com.mikerussell.javacodedom;

import com.mikerussell.javacodedom.core.CodeElement;
import org.junit.Assert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {

  protected void generateAndCompare(String testName, CodeElement element) {
    StringWriter stringWriter = new StringWriter();
    OutputWriter outputWriter = new OutputWriter(stringWriter);
    GenerationContext context = new GenerationContext();
    element.generate(outputWriter, context);
    String generated = stringWriter.toString();
    String baseLine = null;
    try {
      if (TestSettings.GenerateBaselines) {
        FileWriter writer = new FileWriter("TestBaselines/" + testName + "-output.java");
        writer.write(generated);
        writer.close();
        return;
      } else {
        Path path = Paths.get("TestBaselines/" + testName + "-output.java");
        if (!Files.exists(path)) {
          throw new Error("Baseline output for " + testName + " does not exist.");
        }
        baseLine = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    Assert.assertEquals(baseLine, generated);
  }
}
