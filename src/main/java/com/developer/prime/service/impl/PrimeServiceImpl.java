package com.developer.prime.service.impl;

import com.developer.prime.domain.PrimeResolver;
import com.developer.prime.model.TwinPrime;
import com.developer.prime.repository.PrimeRepository;
import com.developer.prime.service.PrimeService;
import com.developer.prime.service.map.PrimeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.developer.prime.domain.PrimeResolver.STARTING_NUMBER;
import static java.util.function.Predicate.not;

@Service
public class PrimeServiceImpl implements PrimeService {
  
  private final PrimeResolver primeResolver;
  private final PrimeRepository primeRepository;
  private final PrimeMapper mapper;
  
  public PrimeServiceImpl(PrimeResolver primeResolver, PrimeRepository primeRepository, PrimeMapper mapper) {
    this.primeResolver = primeResolver;
    this.primeRepository = primeRepository;
    this.mapper = mapper;
  }
  
  @Override
  public List<Integer> getPrimes(int nPrimes) {
    List<Integer> primes = new ArrayList<>();
    addPrimesFromDatabase(primes, nPrimes);
    if (nPrimes > primes.size()) {
      addPrimesFromResolver(primes, nPrimes - primes.size());
    }
    return primes;
  }
  
  @Override
  public List<TwinPrime> getTwinPrimes(int nTwinPrimes) {
    return primeResolver.getTwinPrimes(nTwinPrimes);
  }
  
  private void addPrimesFromResolver(List<Integer> primes, int nPrimes) {
    Optional.of(primes)
      .map(this::nextNumber)
      .map(startingNumber -> primeResolver.getPrimes(startingNumber, nPrimes))
      .ifPresent(primes::addAll);
    
    Optional.of(primes)
      .map(mapper::from)
      .ifPresent(primeRepository::saveAll);
  }
  
  private void addPrimesFromDatabase(List<Integer> primes, int nPrimes) {
    Optional.of(primeRepository.findAll(PageRequest.of(0, nPrimes)))
      .map(Page::toList)
      .map(mapper::to)
      .ifPresent(primes::addAll);
  }
  
  private Integer nextNumber(List<Integer> primes) {
    return Optional.of(primes)
      .filter(not(List::isEmpty))
      .map(given -> given.get(given.size() - 1) + 1)
      .orElse(STARTING_NUMBER);
  }
}
