package Util;

import Exceptions.RangeException;

public class Random {
  
  public static java.util.Random rand = new java.util.Random();
  
  public static int range(Range range) {
    return validateRange(range);
  }

  public static int range(int low, int high) {
    return validateRange(new Range(low, high));
  }

  public static int range(int high) {
    return validateRange(new Range(0, high));
  }
  
  private static int validateRange(Range range) {
    try{
      if(range.high == 0) return 0;
      if(range.high < range.low) throw new RangeException("Invalid range.high value, can't be lower than range.low", range.low);
      
      return rand.nextInt(range.high - range.low) + range.low;
    } catch(RangeException e) {
      e.printStackTrace();
      return e.returnValue;
    }
  }
}
