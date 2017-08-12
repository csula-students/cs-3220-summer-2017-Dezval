package edu.csula.jaxrs;

import edu.csula.jaxrs.models.FoodItem;
import edu.csula.jaxrs.models.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Path("")
@Singleton // used to keep resource between requests otherwise request cope
public class OrderResource {
    private List<Order> orders = new ArrayList<>(Arrays.asList(new Order(0,new FoodItem(0,"Coffee", "Deliciousness", 4.95),"Eric Liao", Order.Status.IN_QUEUE, Date.from(Instant.EPOCH))));
//    private List<Order> orders = new ArrayList<>(1);


    @GET
    @Path("orders")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders() {
        return orders;
    }

    @GET
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("id") int id){
        return orders.get(id);
    }

    @POST
    @Path("orders")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addOrder(Order newOrder) {
        System.out.println(newOrder);
        newOrder.setId(orders.size());
        orders.add(newOrder);
        System.out.println(orders);
        return true;
    }

    @PUT
    @Path("order/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateOrder(Order newOrder, @PathParam("id") int id){
        if(id > orders.size() || id < 0){
            return false;
        }
        orders.set(id,newOrder);
        return true;
    }

    @DELETE
    @Path("order/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteOrder(@PathParam("id") int id) {
        if(id > orders.size() || id < 0){
            return false;
        }
        orders.remove(id);
        for(int i = id; i < orders.size(); i++){
            orders.get(i).setId(orders.get(i).getId()-1);
        }
        return true;
    }

}

