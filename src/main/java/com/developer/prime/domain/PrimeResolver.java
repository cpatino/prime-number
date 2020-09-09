package com.developer.prime.domain;

import com.developer.prime.model.TwinPrime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PrimeResolver {
  
  public static final int STARTING_NUMBER = 2;
  
  public List<Integer> getPrimes(int nPrimes) {
    return getPrimes(STARTING_NUMBER, nPrimes);
  }
  
  public List<Integer> getPrimes(int startingNumber, int nPrimes) {
    List<Integer> primes = new ArrayList<>();
    while (primes.size() < nPrimes) {
      if (isPrime(startingNumber)) {
        primes.add(startingNumber);
      }
      startingNumber++;
    }
    return primes;
  }
  
  public List<TwinPrime> getTwinPrimes(int nTwinPrimes) {
    return getTwinPrimes(STARTING_NUMBER, nTwinPrimes);
  }
  
  public List<TwinPrime> getTwinPrimes(int startingNumber, int nTwinPrimes) {
    List<TwinPrime> twinPrimes = new ArrayList<>();
    while (twinPrimes.size() < nTwinPrimes) {
      List<Integer> primes = getPrimes(startingNumber, 2);
      if (primes.get(1) - primes.get(0) == 2) {
        twinPrimes.add(new TwinPrime(primes.get(0), primes.get(1)));
      }
      startingNumber = primes.get(1);
    }
    return twinPrimes;
  }
  
  private boolean isPrime(int number) {
    return isThreeFirstPrimes(number) || !isDivisibleByThreeFirstPrimes(number);
  }
  
  private boolean isThreeFirstPrimes(int number) {
    return number == 2 || number == 3 || number == 5;
  }
  
  private boolean isDivisibleByThreeFirstPrimes(int number) {
    return (number % 2 == 0) || (number % 3 == 0) || (number % 5 == 0);
  }
}
