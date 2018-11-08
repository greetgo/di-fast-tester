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

    BeanClass beanClass=new BeanClass();
    beanClass.name = "HelloWorld";
    beanClass.packageName = destPackage;
    beanClass.printTo(destDir);
  }
}
