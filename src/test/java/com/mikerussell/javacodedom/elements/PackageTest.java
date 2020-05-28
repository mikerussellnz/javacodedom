package com.mikerussell.javacodedom.elements;

import com.mikerussell.javacodedom.BaseTest;
import org.junit.Test;

public class PackageTest extends BaseTest {

  @Test
  public void testPackage() {
    Package packageStatement = new Package("com.mike.test");
    generateAndCompare("TestPackage", packageStatement);
  }
}
