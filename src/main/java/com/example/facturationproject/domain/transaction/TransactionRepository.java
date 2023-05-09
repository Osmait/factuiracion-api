package com.example.facturationproject.domain.transaction;

import com.example.facturationproject.domain.Sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction,Long> {


    Optional<List<Transaction>> findAllBySaleIdAndUserId(Long saleId, Long userId);
}
