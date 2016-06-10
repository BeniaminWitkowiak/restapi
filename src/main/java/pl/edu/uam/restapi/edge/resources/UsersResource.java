package pl.edu.uam.restapi.edge.resources;

import pl.edu.uam.restapi.edge.excepction.CustomNotFoundException;
import pl.edu.uam.restapi.edge.model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/users")
public class UsersResource {
    private static Map<String, User> users = new HashMap<>();

    public UsersResource() {
        addUser(new User("0", "Mieszko111", "Pierwszy"));
        addUser(new User("1", "Bolesław111", "Chrobry"));
        addUser(new User("2", "Kazimierz111", "Wielki"));
    }

    private void addUser(User user) {
        users.put(user.getId(), user);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> list() {
        return users.values();
    }

    @Path("/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userId") String userId) throws Exception {
        User user = users.get(userId);

        if (user == null) {
            throw new CustomNotFoundException(7878, "User, " + userId + ", is not found");
        }

        return user;
    }
}

