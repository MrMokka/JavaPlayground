package Util;

public class Range {

  public int low, high;

  public Range(int low, int high) {
    if(high < low) {
      this.low = high;
      this.high = high;
      System.err.println("Failed to create a range with a low value higher than high");
    } else {
      this.low = low;
      this.high = high;
    }
  }
}
