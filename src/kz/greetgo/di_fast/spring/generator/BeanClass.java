package kz.greetgo.di_fast.spring.generator;

import org.springframework.beans.factory.annotation.Autowired;

public class BeanClass extends ParentBeanClass {

  @Override
  protected void printContent(JavaFilePrinter p) {

    if (nextOnLine1 != null) {
      p.ofs(1).prn("@" + p.i(Autowired.class));
      p.ofs(1).prn("private " + p.i(nextOnLine1.fullName()) + " nextOnLine1;");
      p.ofs(1).prn();
    }

    p.ofs(1).prn("public void line1(boolean printPath) {");
    p.ofs(2).prn("if(printPath) {");
    p.ofs(3).prn("System.out.println(\"\\t-- passing line1 in \" + getClass().getSimpleName());");
    p.ofs(2).prn("}");
    if (nextOnLine1 == null) {
      p.ofs(2).prn("System.out.println(\"LINE1 : Hello from \" + getClass().getSimpleName());");
    } else {
      p.ofs(2).prn("nextOnLine1.line1(printPath);");
    }

    p.ofs(1).prn("}");
  }

  public BeanClass nextOnLine1 = null;
}
