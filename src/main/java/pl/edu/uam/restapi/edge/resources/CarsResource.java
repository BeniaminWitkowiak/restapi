package pl.edu.uam.restapi.edge.resources;

import pl.edu.uam.restapi.edge.dao.CarDao;
import pl.edu.uam.restapi.edge.excepction.CustomNotFoundException;
import pl.edu.uam.restapi.edge.model.Car;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by ben_a_000 on 2016-06-06.
 */
@Path("/cars")
public class CarsResource {
    private static CarDao carDao = new CarDao();

    public CarsResource() {
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(new CollectionResourceCar(carDao.getAll())).build();
    }

    @Path("/{carId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCarFromId(@PathParam("carId") int carId) throws Exception{
        Car car = carDao.getById(carId);

        if (car == null) {
            throw new CustomNotFoundException(7878, "car: " + carId + " is not found");
        }
        return car;
    }

}
