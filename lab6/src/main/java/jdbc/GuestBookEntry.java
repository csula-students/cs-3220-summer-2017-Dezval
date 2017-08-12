package jdbc;


import java.util.Date;

/**
 * Created by Dezval on 7/29/2017.
 */
public class GuestBookEntry {

    public final int id;
    public final String name;
    public String comment;
    public Date created;
    public int currentListSize;

    public GuestBookEntry (int id, String name, String comment, int currentListSize) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.currentListSize = currentListSize;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCurrentListSize() {
        return currentListSize;
    }

    public void setCurrentListSize(int currentListSize) {
        this.currentListSize = currentListSize;
    }
}
