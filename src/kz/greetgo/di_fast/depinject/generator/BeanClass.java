package kz.greetgo.di_fast.depinject.generator;

import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.di_fast.util.JavaFilePrinter;

public class BeanClass extends ParentBeanClass {

  @Override
  protected void printContent(JavaFilePrinter p) {

    if (nextOnLine1 != null) {
      p.ofs(1).prn("public " + p.i(BeanGetter.class) + "<" + p.i(nextOnLine1.fullName()) + "> nextOnLine1;");
      p.ofs(1).prn();
    }

    p.ofs(1).prn("public void line1(boolean printPath) {");
    p.ofs(2).prn("if(printPath) {");
    p.ofs(3).prn("System.out.println(\"\\t-- passing line1 in \" + getClass().getSimpleName());");
    p.ofs(2).prn("}");
    if (nextOnLine1 == null) {
      p.ofs(2).prn("System.out.println(\"LINE1 : Hello from \" + getClass().getSimpleName());");
    } else {
      p.ofs(2).prn("nextOnLine1.get().line1(printPath);");
    }

    p.ofs(1).prn("}");
  }

  public BeanClass nextOnLine1 = null;
}
