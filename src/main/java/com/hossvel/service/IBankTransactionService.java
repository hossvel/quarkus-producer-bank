package com.hossvel.service;

import com.hossvel.model.BankTransaction;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface IBankTransactionService {
    public Uni<BankTransaction> create(BankTransaction bankTransaction);
    public Uni<List<BankTransaction>> getlistAll();
}
