package kz.greetgo.di_fast.depinject.app;

import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.gen.DepinjectUtil;
import kz.greetgo.di_fast.util.Utils;

public class DepinjectApplication {
  public static void main(String[] args) throws Exception {

    System.out.println("Started main at " + Utils.nowStr());

    DepinjectUtil.implementAndUseBeanContainers(
        MainBeanContainer.class.getPackage().getName(),
        "build/gen_src"
    );

    System.out.println("Implemented and compiled at " + Utils.nowStr());

    MainBeanContainer beanContainer = Depinject.newInstance(MainBeanContainer.class);

    System.out.println("Created bean container at " + Utils.nowStr());

    beanContainer.mainBean().line1(true);

    System.out.println("Finished at " + Utils.nowStr());
  }
}
