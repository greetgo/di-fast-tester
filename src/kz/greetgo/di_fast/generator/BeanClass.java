package kz.greetgo.di_fast.generator;

import org.springframework.stereotype.Component;

import java.nio.file.Path;

public class BeanClass {
  public String name;
  public String packageName;

  public void printTo(Path destSrc) {
    JavaFilePrinter p = new JavaFilePrinter();
    p.packageName = packageName;
    p.classHeader = "public class " +
        name;
    p.className = name;

    p.beforeHeader.add("@" + p.i(Component.class));

    p.printToSrc(destSrc);

  }
}
