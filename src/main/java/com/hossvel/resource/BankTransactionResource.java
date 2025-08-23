package com.hossvel.resource;

import com.hossvel.model.BankTransaction;
import com.hossvel.service.IBankTransactionService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;

@Path( "/transactions" )
@Produces( MediaType.APPLICATION_JSON)
@Consumes( MediaType.APPLICATION_JSON)
public class BankTransactionResource {

    @Inject
    IBankTransactionService iBankTransactionService;

    @POST
    public Uni<Response> publish(BankTransaction bankTransaction) {

        return iBankTransactionService.create(bankTransaction)
                .map(p -> Response.status(Response.Status.CREATED).entity(p).build());

    }

    @GET
    public Uni<List<BankTransaction>> getAll() {
        return iBankTransactionService.getlistAll();
    }

}
