package pl.edu.uam.restapi.edge;
import org.glassfish.jersey.server.ResourceConfig;
import pl.edu.uam.restapi.edge.resources.CarShowroomsResource;
import pl.edu.uam.restapi.edge.resources.CarsResource;
import pl.edu.uam.restapi.edge.resources.UsersResource;

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(UsersResource.class);
        register(CarsResource.class);
        register(CarShowroomsResource.class);
    }

}