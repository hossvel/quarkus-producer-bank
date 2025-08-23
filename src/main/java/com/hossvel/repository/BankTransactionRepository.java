package com.hossvel.repository;

import com.hossvel.model.BankTransaction;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BankTransactionRepository  implements PanacheRepository<BankTransaction> {

    public Uni<BankTransaction> save(BankTransaction product) {
        return persist(product);
    }

    public Uni<List<BankTransaction>> getlistAll() {
        return listAll();
    }
}
