package pl.edu.uam.restapi.edge.excepction;

import pl.edu.uam.restapi.edge.model.ErrorResponse;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/**
 * Created by ben_a_000 on 2016-06-13.
 */
public class CustomException extends WebApplicationException {

    public CustomException(Response.StatusType statusType) {
        super(Response.status(statusType.getStatusCode()).build());
    }

    public CustomException(Response.StatusType statusType, int code, String message) {
        super(Response.status(
                statusType.getStatusCode()).
                entity(new ErrorResponse(code, message)).type(MediaType.APPLICATION_JSON).build());
    }
}
