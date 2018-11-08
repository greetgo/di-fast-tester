package kz.greetgo.di_fast.app;

import kz.greetgo.di_fast.generated.MainBean;
import kz.greetgo.di_fast.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("kz.greetgo.di_fast.generated")
public class DiFastApp {
  public static void main(String[] args) {
    System.out.println("Started main at " + Utils.nowStr());
    SpringApplication.run(DiFastApp.class, args);
  }

  @Autowired
  private MainBean mainBean;

  @PostConstruct
  public void init() {
    System.out.println("Start passing " + Utils.nowStr());
    mainBean.line1(true);
    System.out.println("Finish passing " + Utils.nowStr());
  }
}
