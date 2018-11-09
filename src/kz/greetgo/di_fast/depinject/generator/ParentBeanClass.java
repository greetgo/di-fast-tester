package kz.greetgo.di_fast.depinject.generator;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.di_fast.util.JavaFilePrinter;

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
    p.classHeader = "public class " + name;
    p.className = name;

    p.beforeHeader.add("@" + p.i(Bean.class));

    printContent(p);

    p.printToSrc(destSrc);
  }

  protected abstract void printContent(JavaFilePrinter p);
}
