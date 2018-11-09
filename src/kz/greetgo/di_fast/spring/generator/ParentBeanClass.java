package kz.greetgo.di_fast.spring.generator;

import org.springframework.stereotype.Component;

import java.nio.file.Path;

public abstract class ParentBeanClass {
  public String name;
  public String packageName;

  public String fullName() {
    return packageName + "." + name;
  }

  public void printTo(Path destSrc) {
    JavaFilePrinter p = new JavaFilePrinter();
    p.packageName = packageName;
    p.classHeader = "public class " +
        name;
    p.className = name;

    p.beforeHeader.add("@" + p.i(Component.class));

    printContent(p);

    p.printToSrc(destSrc);
  }

  protected abstract void printContent(JavaFilePrinter p);
}
