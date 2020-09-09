package com.developer.prime.repository;

import com.developer.prime.entity.Prime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeRepository extends JpaRepository<Prime, Integer> {
  
  Page<Prime> findAll(Pageable pageable);
}
