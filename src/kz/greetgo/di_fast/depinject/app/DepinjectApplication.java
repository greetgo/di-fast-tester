package kz.greetgo.di_fast.depinject.app;

import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.NoImplementor;
import kz.greetgo.depinject.gen.DepinjectUtil;
import kz.greetgo.util.ServerUtil;

import java.io.File;

import static kz.greetgo.di_fast.util.Utils.nowStr;

public class DepinjectApplication {

  private static final String GEN_SRC = "build/gen_src";

  public static void main(String[] args) throws Exception {

    System.out.println("Started main at " + nowStr());

    MainBeanContainer beanContainer = createMainBeanContainer();

    System.out.println("Created bean container at " + nowStr());

    beanContainer.mainBean().line1(false);

    System.out.println("Finished at " + nowStr());
  }

  private static MainBeanContainer createMainBeanContainer() throws Exception {
    try {
      if (new File(GEN_SRC).isDirectory()) {
        ServerUtil.addToClasspath(GEN_SRC);
      }
      System.out.println("Start creating bean container at " + nowStr());
      return Depinject.newInstance(MainBeanContainer.class);
    } catch (NoImplementor ignore) {
      System.out.println("No bean container implementation as " + nowStr());
      System.out.println("Start  generating and compiling at " + nowStr());
      DepinjectUtil.implementAndUseBeanContainers(
          MainBeanContainer.class.getPackage().getName(),
          GEN_SRC
      );
      System.out.println("Finish generating and compiling at " + nowStr());
      System.out.println("Start creating bean container (second time) at " + nowStr());
      return Depinject.newInstance(MainBeanContainer.class);
    }
  }
}
