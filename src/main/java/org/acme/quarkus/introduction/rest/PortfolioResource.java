package org.acme.quarkus.introduction.rest;


import org.acme.quarkus.introduction.model.Portfolio;
import org.acme.quarkus.introduction.rest.param.PaginationParam;
import org.acme.quarkus.introduction.service.PortfolioService;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@Path("portfolio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PortfolioResource {

    @Inject
    PortfolioService portfolioService;

    @GET
    public CompletionStage<Portfolio[]> doGet(@BeanParam PaginationParam queryParams) {
        return CompletableFuture.supplyAsync(() -> {
            int offset = queryParams.per_page * (queryParams.page - 1);
            return portfolioService.findPortfolio(offset,queryParams.per_page);
        });
    }

}
