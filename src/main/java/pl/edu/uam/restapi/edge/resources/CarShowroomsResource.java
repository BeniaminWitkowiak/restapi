package pl.edu.uam.restapi.edge.resources;

import pl.edu.uam.restapi.edge.dao.CarShowroomDao;
import pl.edu.uam.restapi.edge.excepction.CustomNotFoundException;
import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.CarShowroom;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ben_a_000 on 2016-06-06.
 */
@Path("/carshowrooms")
public class CarShowroomsResource {
    private static CarShowroomDao carShowroomDao = new CarShowroomDao();

    public CarShowroomsResource(){
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok().entity(new CollectionResourceCarShowroom(carShowroomDao.getAll())).build();
    }


    @POST
    @Path("/post")
    @Consumes("application/json")
    public Response addCarShowroom(@Valid CarShowroom carShowroom){

        carShowroomDao.addCarShowroom(carShowroom);
        String result = "carShowroom created : " +
                carShowroom.getId() + " " +
                carShowroom.getAdress() + " " +
                carShowroom.getCarBrand();
        return Response.status(201).entity(result).build();

    }



    @POST
    @Path("/addcar")
    @Consumes("application/json")
    public Response addCarToCarshowroom2(@Valid Car car){
        carShowroomDao.addCarToCarShowroom(car);
        String result ="Car "+ car + " successfully added to "+ 11 + " car showroom.";

        return Response.status(201).entity(result).build();

    }


    @Path("/{ShowroomId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CarShowroom getCarShowroomFromId(@PathParam("ShowroomId") int ShowroomId) throws Exception{
        CarShowroom carShowroom = carShowroomDao.getById(ShowroomId);

        if (carShowroom == null) {
            throw new CustomNotFoundException(7878, "Showroom: " + ShowroomId + " is not found");
        }

        return carShowroom;
    }



}
