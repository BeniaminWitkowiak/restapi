package pl.edu.uam.restapi.edge.resources;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pl.edu.uam.restapi.edge.dao.CarShowroomDao;
import pl.edu.uam.restapi.edge.excepction.CustomNotFoundException;
import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.CarShowroom;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



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
    @ApiOperation(value = "Tries to update teacher with given id, or creates new teacher",
            notes = "If user with given first and last name (passed in teacher object) exists it does nothing. If there is no teacher with given id it creates new teacher, in other case it updates the already existing one")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Teacher Created"),
            @ApiResponse(code = 200, message = "Teacher updated"),
            @ApiResponse(code = 409, message = "There is already a teacher like this in our db.") })
    public Response list() {
        return Response.ok().entity(new CollectionResourceCarShowroom(carShowroomDao.getAll())).build();
    }


    @POST
    @Path("/addcarshowroom")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCarShowroom(@Valid CarShowroom carShowroom){
        CarShowroom saved = carShowroomDao.addCarShowroom(carShowroom);
        return Response.status(Response.Status.CREATED).entity(saved).build();

    }

    @DELETE
    @Path("{showroomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCarShowroomFromId(@PathParam("showroomId") int id){
        carShowroomDao.deleteCarShowroom(id);
    }


    @POST
    @Path("/addcar/{ShowroomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCarToCarshowroom2(@PathParam("ShowroomId") int carShowroomId, @Valid Car car){
        carShowroomDao.addCarToCarShowroom(car, carShowroomId);
        return Response.ok().entity(carShowroomDao.getById(carShowroomId)).build();
    }


    @DELETE
    @Path("/deleteCar/{showroomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCarFromCarshowroom2(@PathParam("showroomId") int carShowroomId, @Valid int carId){
        CarShowroom carShowroom = carShowroomDao.deleteCarFromCarshowroom(carShowroomId, carId);
        return Response.ok().entity(carShowroom).build();
    }

    @GET
    @Path("/{ShowroomId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarShowroomFromId(@PathParam("ShowroomId") int ShowroomId) throws Exception{
        CarShowroom carShowroom = carShowroomDao.getById(ShowroomId);

        if (carShowroom == null) {
            throw new CustomNotFoundException(7878, "Showroom: " + ShowroomId + " is not found");
        }
        return Response.status(Response.Status.CREATED).entity(carShowroom).build();
    }

}
