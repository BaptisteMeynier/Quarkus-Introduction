package org.acme.quarkus.introduction.rest;


import org.acme.quarkus.introduction.model.Portfolio;
import org.acme.quarkus.introduction.rest.param.PaginationParam;
import org.acme.quarkus.introduction.service.PortfolioService;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
