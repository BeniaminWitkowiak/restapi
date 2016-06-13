package pl.edu.uam.restapi.edge.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import java.io.IOException;

/**
 * Created by ben_a_000 on 2016-06-13.
 */
public class ContentResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        responseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type");
        responseContext.getHeaders().add("Access-Control-Allow-Methods:", "GET, POST, DELETE, PUT");
        responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
    }
}
