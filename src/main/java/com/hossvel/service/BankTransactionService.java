package com.hossvel.service;

import com.hossvel.model.BankTransaction;
import com.hossvel.repository.BankTransactionRepository;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.Instant;
import java.util.List;

@ApplicationScoped
public class BankTransactionService implements IBankTransactionService {

    @Inject
    BankTransactionRepository bankTransactionRepository;

    @WithSession
    @Override
    public Uni<BankTransaction> create(BankTransaction bankTransaction) {
        bankTransaction.setTimestamp(Instant.now());
        return bankTransactionRepository.save(bankTransaction);
    }

    @WithSession
    @Override
    public Uni<List<BankTransaction>> getlistAll() {
        return bankTransactionRepository.getlistAll();
    }


}
