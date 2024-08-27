package Util;

public class Range {

  public int low, high;
  
  //Used by Jackson
  public Range(){}
  
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
  
  //Used by Jackson
  //region Getters and Setters
  
  public int getLow() {
    return low;
  }
  
  public void setLow(int low) {
    this.low = low;
  }
  
  public int getHigh() {
    return high;
  }
  
  public void setHigh(int high) {
    this.high = high;
  }
  
  //endregion
  
}

