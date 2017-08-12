package edu.csula.jaxrs.models;

import java.util.Date;

public class Order {

    public int id;
    public FoodItem item;
    public String customerName;

    public enum Status {IN_QUEUE, IN_PROGRESS, COMPLETED}
    public Status status;
    public Date created;

    public String description;
    public double price;


    public Order(){

    }

    public Order(int id, FoodItem item, String customerName, Status status, Date created){
        this.id = id;
        this.item = item;
        this.customerName = customerName;
        this.status = status;
        this.created = created;
        this.description = item.getDescription();
        this.price = item.getPrice();
    }

    public void setItem(FoodItem item) {
        this.item = item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getId(){
        return id;
    }

    public FoodItem getItem(){
        return item;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Date getCreated(){
        return created;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
