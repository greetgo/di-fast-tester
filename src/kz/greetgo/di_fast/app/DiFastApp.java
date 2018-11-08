package kz.greetgo.di_fast.app;

import kz.greetgo.di_fast.structure.BeanScanner;
import kz.greetgo.di_fast.structure.MainBean;
import kz.greetgo.di_fast.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(BeanScanner.class)
public class DiFastApp {
  public static void main(String[] args) {
    System.out.println("Started main at " + Utils.nowStr());
    SpringApplication.run(DiFastApp.class, args);
  }

  @Autowired
  private MainBean mainBean;

  @PostConstruct
  public void init() {
    System.out.println("Hello in post construct at " + Utils.nowStr());
    mainBean.printHello();
  }
}
