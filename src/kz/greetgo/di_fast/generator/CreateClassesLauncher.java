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

    for (int i = 0; i < 10_000; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(destPackage);

      {
        final int factor = 7;
        int ii = i;
        while (ii != 0) {
          sb.append(".p").append(ii % factor);
          ii /= factor;
        }
      }

      BeanClass beanClass = new BeanClass();
      beanClass.name = "HelloWorld" + i;
      beanClass.packageName = sb.toString();
      beanClass.printTo(destDir);
    }


  }
}
