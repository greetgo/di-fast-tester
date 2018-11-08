package kz.greetgo.di_fast.generator;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateClassesLauncher {
  public static void main(String[] args) {
    new CreateClassesLauncher().exec();
  }

  private void exec() {
    Path destDir = Paths.get("src");

    String destPackage = "kz.greetgo.di_fast.generated";

    JavaFilePrinter p = new JavaFilePrinter();
    p.packageName = destPackage;
    p.classHeader = "public class Hello";
    p.className = "Hello";

    p.beforeHeader.add("@" + p.i(Component.class));

    p.printToSrc(destDir);
  }
}
