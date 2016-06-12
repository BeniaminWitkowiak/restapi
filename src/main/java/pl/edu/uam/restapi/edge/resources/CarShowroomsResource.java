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
    public Response list() {
        return Response.ok().entity(new CollectionResourceCarShowroom(carShowroomDao.getAll())).build();
    }


    @POST
    @Path("/addcarshowroom")
    @Consumes("application/json")
    public Response addCarShowroom(@Valid CarShowroom carShowroom){

        carShowroomDao.addCarShowroom(carShowroom);
        String result = "carShowroom created : " +
                carShowroom.getId() + " " +
                carShowroom.getAdress() + " " +
                carShowroom.getCarBrand();
        return Response.status(201).entity(result).build();

    }

    @Path("/deletecarshowroom/{ShowroomId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCarShowroomFromId(@PathParam("ShowroomId") int id){
        carShowroomDao.deleteCarShowroom(id);
    }


    @POST
    @Path("/addcar/{ShowroomId}")
    @Consumes("application/json")
    public Response addCarToCarshowroom2(@PathParam("ShowroomId") int carShowroomId, @Valid Car car){
        int status  = carShowroomDao.addCarToCarShowroom(car, carShowroomId);
        String result_ok ="Car "+ car + " successfully added to "+ carShowroomId + " car showroom.";
        String result_carShowrrom_not_found ="Sorry, car showroom "+ carShowroomId + " not found.";
        String result_brands_do_not_match ="Sorry, car showroom "+ carShowroomId + " exists, but brands do not match.";

        if (status == -1){
            return Response.status(Response.Status.NOT_FOUND).entity(result_carShowrrom_not_found).build();
        } else if (status == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(result_brands_do_not_match).build();
        }else{
            return Response.status(Response.Status.CREATED).entity(result_ok).build();
        }
    }


    @POST
    @Path("/deletecarfromcarshowroom/{ShowroomId}")
    @Consumes("application/json")
    public Response deleteCarFromCarshowroom2(@PathParam("ShowroomId") int carShowroomId, @Valid int carId){
        int status  = carShowroomDao.deleteCarFromCarshowroom(carShowroomId, carId);
        String result_ok ="Car "+ carId + " successfully removed from "+ carShowroomId + " car showroom.";
        String result_carShowrrom_not_found ="Sorry, car showroom "+ carShowroomId + " not found.";
        String result_car_not_found ="Sorry, car "+ carId + " not found.";

        // WRZUCIC TO W METODE ! !
        if (status == -1){
            return Response.status(Response.Status.NOT_FOUND).entity(result_carShowrrom_not_found).build();
        } else if (status == 0) {
            return Response.status(Response.Status.NOT_FOUND).entity(result_car_not_found).build();
        }else{
            return Response.status(Response.Status.CREATED).entity(result_ok).build();
        }
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
