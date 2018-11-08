package kz.greetgo.di_fast.generator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateClassesLauncher {
  public static void main(String[] args) {
    new CreateClassesLauncher().exec();
  }

  private void exec() {
    Path destDir = Paths.get("src");

    String destPackage = "kz.greetgo.di_fast.generated";

    for (int i = 0; i < 100; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(destPackage);

      {
        int ii = i;
        while (ii != 0) {
          sb.append(".p").append(ii % 3);
          ii /= 3;
        }
      }

      BeanClass beanClass = new BeanClass();
      beanClass.name = "HelloWorld" + i;
      beanClass.packageName = sb.toString();
      beanClass.printTo(destDir);
    }


  }
}
