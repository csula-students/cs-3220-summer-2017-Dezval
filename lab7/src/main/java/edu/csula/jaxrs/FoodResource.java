package edu.csula.jaxrs;

import edu.csula.jaxrs.models.FoodItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Path("")
@Singleton // used to keep resource between requests otherwise request cope
public class FoodResource {
    private List<FoodItem> foods = new ArrayList<>(Arrays.asList(new FoodItem(0,"Coffee", "Deliciousness", 4.95)));


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayFoodsList() {
        return "Hello, Welcome to Casa de Cafe";
    }

    @GET
    @Path("fooditems")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodItem> getFoods() {
        return foods;
    }

    @GET
    @Path("fooditem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FoodItem getFood(@PathParam("id") int id){
        return foods.get(id);
    }

    @POST
    @Path("fooditems")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addFood(FoodItem newFood) {
        System.out.println(newFood);
        newFood.setId(foods.size());
        foods.add(newFood);
        System.out.println(foods);
        return true;
    }

    @PUT
    @Path("fooditem/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateFood(FoodItem newFood, @PathParam("id") int id){
        if(id > foods.size() || id < 0){
            return false;
        }
        foods.set(id,newFood);
        return true;
    }

    @DELETE
    @Path("fooditem/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteFood(@PathParam("id") int id) {
        if(id > foods.size() || id < 0){
            return false;
        }
        foods.remove(id);
        for(int i = id; i < foods.size(); i++){
            foods.get(i).setId(foods.get(i).getId()-1);
        }
        return true;
    }

}


