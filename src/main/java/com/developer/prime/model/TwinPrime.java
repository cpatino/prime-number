package com.developer.prime.model;

public class TwinPrime {
  
  private final int firstPrime;
  private final int secondPrime;
  
  public TwinPrime(int firstPrime, int secondPrime) {
    this.firstPrime = firstPrime;
    this.secondPrime = secondPrime;
  }
  
  public int getFirstPrime() {
    return firstPrime;
  }
  
  public int getSecondPrime() {
    return secondPrime;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    TwinPrime twinPrime = (TwinPrime) o;
    
    if (firstPrime != twinPrime.firstPrime) return false;
    return secondPrime == twinPrime.secondPrime;
  }
  
  @Override
  public int hashCode() {
    int result = firstPrime;
    result = 31 * result + secondPrime;
    return result;
  }
}
