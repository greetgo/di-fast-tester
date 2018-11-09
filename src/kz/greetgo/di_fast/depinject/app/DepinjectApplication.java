package kz.greetgo.di_fast.depinject.app;

import kz.greetgo.depinject.Depinject;
import kz.greetgo.depinject.gen.DepinjectUtil;

public class DepinjectApplication {
  public static void main(String[] args) throws Exception {
    DepinjectUtil.implementAndUseBeanContainers(
        MainBeanContainer.class.getPackage().getName(),
        "build/gen_src"
    );

    MainBeanContainer beanContainer = Depinject.newInstance(MainBeanContainer.class);

    beanContainer.mainBean().line1(true);
  }
}
