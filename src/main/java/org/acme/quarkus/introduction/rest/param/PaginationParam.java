package org.acme.quarkus.introduction.rest.param;


import javax.validation.constraints.Min;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PaginationParam {

    @Min(value = 1, message = "page start at 1")
    @QueryParam("page")
    @DefaultValue("1")
    public int page;

    @QueryParam("per_page")
    @DefaultValue("50")
    public int per_page;
}
