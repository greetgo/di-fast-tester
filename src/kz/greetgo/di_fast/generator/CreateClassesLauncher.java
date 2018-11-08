package kz.greetgo.di_fast.generator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateClassesLauncher {
  public static void main(String[] args) {
    new CreateClassesLauncher().exec();
  }

  private void exec() {
    Path destDir = Paths.get("src");
    System.out.println("here = " + destDir.toFile().getAbsoluteFile().toPath().normalize().toFile());

    String destPackage = "kz.greetgo.di_fast.generated";

    JavaFilePrinter p = new JavaFilePrinter();
    p.packageName = destPackage;
    p.classHeader = "public class Hello";
    p.className = "Hello";

    p.printToSrc(destDir);
  }
}
