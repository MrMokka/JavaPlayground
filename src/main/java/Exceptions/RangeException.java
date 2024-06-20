package Exceptions;

public class RangeException extends Exception {
  public int returnValue;
  public RangeException(String message, int returnValue) {
    super(message);
    this.returnValue = returnValue;
  }
}
