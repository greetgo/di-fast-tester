package kz.greetgo.di_fast.generator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static kz.greetgo.di_fast.util.Utils.shuffle;

public class CreateClassesLauncher {
  public static void main(String[] args) {
    new CreateClassesLauncher().exec();
  }

  private void exec() {
    Path destDir = Paths.get("src");

    String destPackage = "kz.greetgo.di_fast.generated";

    BeanClass classes[] = new BeanClass[10];

    for (int i = 0; i < classes.length; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(destPackage);
      sb.append(".wow");

      {
        final int factor = 7;
        int ii = i;
        while (ii > 7) {
          sb.append(".p").append(ii % factor);
          ii /= factor;
        }
      }

      BeanClass beanClass = new BeanClass();
      beanClass.name = "HelloWorld" + i;
      beanClass.packageName = sb.toString();

      classes[i] = beanClass;
    }

    int refs[] = new int[classes.length];
    for (int i = 0; i < refs.length; i++) {
      refs[i] = i;
    }

    shuffle(refs);

    for (int i = 0; i < refs.length - 1; i++) {
      classes[i].nextOnLine1 = classes[i + 1];
    }

    MainBeanClass mainBeanClass = new MainBeanClass();
    mainBeanClass.name = "MainBean";
    mainBeanClass.packageName = destPackage;

    mainBeanClass.startLine1 = classes[0];

    Arrays.stream(classes)
        .forEachOrdered(beanClass -> beanClass.printTo(destDir));
    mainBeanClass.printTo(destDir);
  }

}
