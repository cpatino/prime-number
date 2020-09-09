package com.developer.prime.service.impl;

import com.developer.prime.domain.PrimeResolver;
import com.developer.prime.repository.PrimeRepository;
import com.developer.prime.service.PrimeService;
import com.developer.prime.service.map.PrimeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class PrimeServiceImplTest {
  
  @Mock private PrimeResolver primeResolver;
  @Mock private PrimeRepository primeRepository;
  @Mock private PrimeMapper mapper;
  private PrimeService service;
  
  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    service = new PrimeServiceImpl(primeResolver, primeRepository, mapper);
  }
  
  @Test
  void whenServiceGetPrimes_thenPrimeResolverGetPrimes() {
    service.getPrimes(10);
    verify(primeResolver).getPrimes(10);
  }
  
  @Test
  void whenServiceGetTwinPrimes_thenPrimeResolverGetTwinPrimes() {
    service.getTwinPrimes(10);
    verify(primeResolver).getTwinPrimes(10);
  }
}