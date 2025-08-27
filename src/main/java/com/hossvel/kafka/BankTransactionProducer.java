package com.hossvel.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hossvel.model.BankTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class BankTransactionProducer {

    @Channel("bank-transactions")
    Emitter<BankTransaction> emitter;

    public void sendBankAccountEvent(String accountId, double amount, String type) {
        emitter.send(new BankTransaction(accountId, amount, type));
    }

}