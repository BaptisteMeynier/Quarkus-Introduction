package org.acme.quarkus.introduction.rest;


import org.acme.quarkus.introduction.model.Portfolio;
import org.acme.quarkus.introduction.repository.PortfolioRepository;
import org.acme.quarkus.introduction.rest.param.PaginationParam;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


@Path("portfolio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PortfolioResource {

    @Inject
    private PortfolioRepository portfolioRepository;

    @GET
    public CompletionStage<List<Portfolio>> doGet(@BeanParam PaginationParam queryParams) {
        return CompletableFuture.supplyAsync(() -> {
            int offset = queryParams.per_page * (queryParams.page - 1);
            return portfolioRepository.getPortfolios(offset, queryParams.per_page);
        });
    }

}
