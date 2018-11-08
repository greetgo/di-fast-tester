package kz.greetgo.di_fast.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
  public static String nowStr() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    return sdf.format(new Date());
  }

  public static void shuffle(int[] refs) {
    Random rnd = new Random();
    for (int i = 0; i < refs.length; i++) {
      int j = rnd.nextInt(refs.length);

      int tmp = refs[i];
      refs[i] = refs[j];
      refs[j] = tmp;
    }
  }
}
