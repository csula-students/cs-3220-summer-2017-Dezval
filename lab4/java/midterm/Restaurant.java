package midterm;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public final int id;
    public String name;
    public String URL;
    public ArrayList<Integer> designRatings = new ArrayList<>();
    public ArrayList<Integer> tasteRatings = new ArrayList<>();

    public Restaurant (int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.URL = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public void addDesignRating(Integer rating){
        designRatings.add(rating);
    }

    public Integer getDesignRating(){
        int tmp = 0;
        for(int i = 0; i < designRatings.size(); i++){
            tmp += designRatings.get(i);
        }
        if(designRatings.size() != 0){
            return tmp/designRatings.size();
        }
        return tmp;
    }

    public void addTasteRating(Integer rating){
        tasteRatings.add(rating);
    }

    public Integer getTasteRating(){
        int tmp = 0;
        for(int i = 0; i < tasteRatings.size(); i++){
            tmp += tasteRatings.get(i);
        }
        if(tasteRatings.size() != 0){
            return tmp/tasteRatings.size();
        }
        return tmp;
    }
}
