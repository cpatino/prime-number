package com.developer.prime.controller;

import com.developer.prime.model.TwinPrime;
import com.developer.prime.service.PrimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrimeController {
  
  private PrimeService service;
  
  public PrimeController(PrimeService service) {
    this.service = service;
  }
  
  @GetMapping("/primos")
  public List<Integer> getPrimes(@RequestParam int nPrimes) {
    return service.getPrimes(nPrimes);
  }
  
  @GetMapping("/primos-gemelos")
  public List<TwinPrime> getTwinPrimes(@RequestParam int nPrimes) {
    return service.getTwinPrimes(nPrimes);
  }
}
