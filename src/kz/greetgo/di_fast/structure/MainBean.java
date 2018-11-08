package kz.greetgo.di_fast.structure;

import kz.greetgo.di_fast.util.Utils;
import org.springframework.stereotype.Component;

@Component
public class MainBean {
  public void printHello() {
    System.out.println("Hello form MainBean as " + Utils.nowStr());
  }
}
