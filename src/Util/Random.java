package Util;

public class Random {
  
  public static java.util.Random rand = new java.util.Random();
  
  public static int range(Range range) {
    return rand.nextInt(range.high - range.low) + range.low;
  }

  public static int range(int low, int high) {
    return rand.nextInt(high - low) + low;
  }

  public static int range(int high) {
    return rand.nextInt(high);
  }
  
}

