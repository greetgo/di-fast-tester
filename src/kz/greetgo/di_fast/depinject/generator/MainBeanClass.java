package kz.greetgo.di_fast.depinject.generator;

import kz.greetgo.di_fast.util.JavaFilePrinter;
import org.springframework.beans.factory.annotation.Autowired;

public class MainBeanClass extends ParentBeanClass {
  @Override
  protected void printContent(JavaFilePrinter p) {

    if (startLine1 != null) {

      p.ofs(1).prn("@" + p.i(Autowired.class));
      p.ofs(1).prn("private " + p.i(startLine1.fullName()) + " startOnLine1;");
      p.ofs(1).prn();

      p.ofs(1).prn("public void line1(boolean printPath) {");
      p.ofs(2).prn("if(printPath) {");
      p.ofs(3).prn("System.out.println(\"\\t-- passing line1 start\");");
      p.ofs(2).prn("}");
      p.ofs(2).prn("startOnLine1.line1(printPath);");
      p.ofs(1).prn("}");

    }

  }

  public BeanClass startLine1;
}
