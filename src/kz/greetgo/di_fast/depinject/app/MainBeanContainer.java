package kz.greetgo.di_fast.depinject.app;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;
import kz.greetgo.di_fast.depinject.generated.BeanConfigGenerated;
import kz.greetgo.di_fast.depinject.generated.MainBean;

@Include(BeanConfigGenerated.class)
public interface MainBeanContainer extends BeanContainer {
  MainBean mainBean();
}
