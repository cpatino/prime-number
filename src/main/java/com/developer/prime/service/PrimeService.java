package com.developer.prime.service;

import com.developer.prime.model.TwinPrime;

import java.util.List;

public interface PrimeService {
  
  List<Integer> getPrimes(int nPrimes);
  
  List<TwinPrime> getTwinPrimes(int nTwinPrimes);
}
