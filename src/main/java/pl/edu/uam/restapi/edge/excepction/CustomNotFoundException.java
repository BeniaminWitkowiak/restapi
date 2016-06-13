package pl.edu.uam.restapi.edge.excepction;

import pl.edu.uam.restapi.edge.model.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class CustomNotFoundException extends WebApplicationException {

    /**
     * Create a HTTP 404 (Not Found) exception.
     */
    public CustomNotFoundException() {
        super(Response.status(NOT_FOUND).build());
    }

    /**
     * Create a HTTP 404 (Not Found) exception.
     *
     * @param message the String that is the entity of the 404 response.
     */
    public CustomNotFoundException(int code, String message) {
        super(Response.status(
                NOT_FOUND).
                entity(new ErrorResponse(code, message)).type(MediaType.APPLICATION_JSON).build());
    }
}
