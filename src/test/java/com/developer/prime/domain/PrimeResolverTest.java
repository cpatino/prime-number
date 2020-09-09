package com.developer.prime.domain;

import com.developer.prime.model.TwinPrime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeResolverTest {
  
  private PrimeResolver primerResolver;
  
  @BeforeEach
  public void setup() {
    primerResolver = new PrimeResolver();
  }
  
  @Test
  void givenANumber_whenGetPrimes_thenReturnListOfPrimes() {
    List<Integer> primes = primerResolver.getPrimes(1);
    assertThat(primes).containsExactly(2);
    primes = primerResolver.getPrimes(2);
    assertThat(primes).containsExactly(2, 3);
    primes = primerResolver.getPrimes(3);
    assertThat(primes).containsExactly(2, 3, 5);
    primes = primerResolver.getPrimes(10);
    assertThat(primes).containsExactly(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
  }
  
  @Test
  void givenANumber_whenGetPrimesWithStartingPoint_thenReturnListOfPrimes() {
    List<Integer> primes = primerResolver.getPrimes(3, 1);
    assertThat(primes).containsExactly(3);
    primes = primerResolver.getPrimes(3, 2);
    assertThat(primes).containsExactly(3, 5);
    primes = primerResolver.getPrimes(3, 3);
    assertThat(primes).containsExactly(3, 5, 7);
    primes = primerResolver.getPrimes(3, 9);
    assertThat(primes).containsExactly(3, 5, 7, 11, 13, 17, 19, 23, 29);
  }
  
  @Test
  void givenANumber_whenGetTwinPrimes_thenReturnListOfTwinPrimes() {
    List<TwinPrime> twinPrimes = primerResolver.getTwinPrimes(1);
    assertThat(twinPrimes).containsExactly(new TwinPrime(3, 5));
    twinPrimes = primerResolver.getTwinPrimes(2);
    assertThat(twinPrimes).containsExactly(new TwinPrime(3, 5), new TwinPrime(5, 7));
    twinPrimes = primerResolver.getTwinPrimes(3);
    assertThat(twinPrimes).containsExactly(new TwinPrime(3, 5), new TwinPrime(5, 7), new TwinPrime(11, 13));
    twinPrimes = primerResolver.getTwinPrimes(4);
    assertThat(twinPrimes).containsExactly(new TwinPrime(3, 5), new TwinPrime(5, 7), new TwinPrime(11, 13), new TwinPrime(17, 19));
  }
  
  @Test
  void givenANumber_whenGetTwinPrimesWithStartingPoint_thenReturnListOfTwinPrimes() {
    List<TwinPrime> twinPrimes = primerResolver.getTwinPrimes(5, 1);
    assertThat(twinPrimes).containsExactly(new TwinPrime(5, 7));
    twinPrimes = primerResolver.getTwinPrimes(5, 2);
    assertThat(twinPrimes).containsExactly(new TwinPrime(5, 7), new TwinPrime(11, 13));
    twinPrimes = primerResolver.getTwinPrimes(5, 3);
    assertThat(twinPrimes).containsExactly(new TwinPrime(5, 7), new TwinPrime(11, 13), new TwinPrime(17, 19));
  }
}
