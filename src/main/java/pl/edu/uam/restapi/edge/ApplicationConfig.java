package pl.edu.uam.restapi.edge;
import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.server.ResourceConfig;
import pl.edu.uam.restapi.edge.resources.CarShowroomsResource;
import pl.edu.uam.restapi.edge.resources.CarsResource;
import pl.edu.uam.restapi.edge.resources.UsersResource;


public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(UsersResource.class);
        register(CarsResource.class);
        register(CarShowroomsResource.class);

        packages("io.swagger.jaxrs.listing");
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("restapi-akmebeixgswvcewm.rhcloud.com");
        beanConfig.setBasePath("");
        beanConfig.setResourcePackage("pl.edu");
        beanConfig.setScan(true);
    }

}