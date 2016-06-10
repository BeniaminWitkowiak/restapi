package pl.edu.uam.restapi.edge.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String id;
    private String firstName;
    private String lastname;

    public User(String id, String firstName, String lastname) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }
}