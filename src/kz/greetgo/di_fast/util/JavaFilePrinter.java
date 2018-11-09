package kz.greetgo.di_fast.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class JavaFilePrinter {

  public String packageName;
  public String classHeader;
  public String className;

  public final List<String> beforeHeader = new ArrayList<>();

  private final StringBuilder content = new StringBuilder();

  private final Map<String, String> imports = new HashMap<>();

  public JavaFilePrinter pr(String str) {
    content.append(str);
    return this;
  }

  public JavaFilePrinter prn(String str) {
    content.append(str).append("\n");
    return this;
  }

  public JavaFilePrinter prn() {
    content.append("\n");
    return this;
  }

  public JavaFilePrinter ofs(int tabCount) {
    for (int i = 0; i < tabCount; i++) {
      content.append("  ");
    }
    return this;
  }

  public static String extractSimpleName(String fullName) {
    int index = fullName.lastIndexOf('.');
    if (index < 0) {
      return fullName;
    }
    return fullName.substring(index + 1);
  }

  public String i(Class<?> aClass) {
    return i(aClass.getName());
  }

  public String i(String fullName) {
    if (fullName == null) {
      throw new IllegalArgumentException("fullName == null");
    }
    String simpleName = extractSimpleName(fullName);
    if (Objects.equals(simpleName, fullName)) {
      return fullName;
    }

    String fullNameStored = imports.get(simpleName);
    if (fullNameStored == null) {
      imports.put(simpleName, fullName);
      return simpleName;
    }

    if (Objects.equals(fullName, fullNameStored)) {
      return simpleName;
    }

    return fullName;
  }

  public StringBuilder result() {
    StringBuilder result = new StringBuilder();
    if (packageName != null) {
      result.append("package ").append(packageName).append(";\n");
    }

    result.append("\n");

    result.append(imports.values().stream().sorted().map(fn -> "import " + fn + ";").collect(Collectors.joining("\n")));

    result.append("\n\n");

    for (String line : beforeHeader) {
      result.append(line).append("\n");
    }

    result.append(classHeader).append(" {\n");

    result.append(content);

    if (!content.toString().endsWith("\n")) {
      result.append("\n");
    }

    result.append("}\n");

    return result;
  }

  public void printTo(PrintStream pr) {
    pr.print(result());
  }

  public void printToFile(File file) {
    //noinspection ResultOfMethodCallIgnored
    file.getParentFile().mkdirs();
    try (PrintStream pr = new PrintStream(file, "UTF-8")) {
      printTo(pr);
    } catch (FileNotFoundException | UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }

  public void printToSrc(Path destDir) {
    Path finishedDir = destDir.resolve(String.join("/", packageName.split("\\.")));

    printToFile(finishedDir.resolve(className + ".java").toFile());
  }
}
