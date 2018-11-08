package kz.greetgo.di_fast.generator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static kz.greetgo.di_fast.util.Utils.shuffle;

public class GenerateClassesLauncher {

  private static final int GENERATE_CLASS_COUNT = 300;

  public static void main(String[] args) {
    new GenerateClassesLauncher().exec();
  }

  private void exec() {
    Path destDir = Paths.get("src");

    String destPackage = "kz.greetgo.di_fast.generated";

    BeanClass classes[] = new BeanClass[GENERATE_CLASS_COUNT];

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
      classes[refs[i]].nextOnLine1 = classes[refs[i + 1]];
    }

    MainBeanClass mainBeanClass = new MainBeanClass();
    mainBeanClass.name = "MainBean";
    mainBeanClass.packageName = destPackage;

    mainBeanClass.startLine1 = classes[refs[0]];

    Arrays.stream(classes)
        .forEachOrdered(beanClass -> beanClass.printTo(destDir));
    mainBeanClass.printTo(destDir);
  }

}
