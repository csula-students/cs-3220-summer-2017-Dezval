package edu.csula.jaxrs;

import edu.csula.jaxrs.models.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Path("hello-json-resource")
@Singleton // used to keep resource between requests otherwise request cope
public class HelloJSONResource {
    private List<User> users = new ArrayList<>(Arrays.asList(new User(0,"Eric", "Liao")));


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "Hello, JAX-RS";
    }

    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUser() {
        return users;
    }

    @GET
    @Path("users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id){
        return users.get(id);
    }

    @POST
    @Path("users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addUser(User newUser) {
        System.out.println(newUser);
        newUser.setId(users.size());
        users.add(newUser);
        System.out.println(users);
        return true;
    }

    @PUT
    @Path("users/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateUser(User newUser, @PathParam("id") int id){
        if(id > users.size() || id < 0){
            return false;
        }
        users.set(id,newUser);
        return true;
    }

    @DELETE
    @Path("users/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteUser(@PathParam("id") int id) {
        if(id > users.size() || id < 0){
            return false;
        }
        users.remove(id);
        for(int i = id; i < users.size(); i++){
            users.get(i).setId(users.get(i).getId()-1);
        }
        return true;
    }

}
