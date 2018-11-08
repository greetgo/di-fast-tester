package kz.greetgo.di_fast.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
  public static String nowStr() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    return sdf.format(new Date());
  }
}
