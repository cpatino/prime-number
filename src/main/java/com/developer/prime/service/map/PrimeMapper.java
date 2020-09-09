package com.developer.prime.service.map;

import com.developer.prime.entity.Prime;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrimeMapper {
  
  public List<Integer> to(List<Prime> primes) {
    return primes.stream()
      .map(Prime::getNumber)
      .collect(Collectors.toList());
  }
  
  public List<Prime> from(List<Integer> primes) {
    return primes.stream()
      .map(Prime::new)
      .collect(Collectors.toList());
  }
}
