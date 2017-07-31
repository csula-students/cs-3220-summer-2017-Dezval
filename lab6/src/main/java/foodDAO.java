import dao.DAO;
import dao.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dezval on 7/30/2017.
 */
public class foodDAO implements DAO<FoodEntry> {
    public List<FoodEntry> list() {
        List<FoodEntry> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM food");
            while (rs.next()) {
                list.add(new FoodEntry(
                        rs.getInt("id"),
                        rs.getString("FoodName"),
                        rs.getDouble("price"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<FoodEntry> get(int id) {

        return Optional.empty();

    }

    public void add(FoodEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO food (id ,foodName, description, price) VALUES (?, ?, ?, ?)");
            pstmt.setInt(1,entry.getId());
            pstmt.setString(2, entry.getName());
            pstmt.setString(3, entry.getDescription());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FoodEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE food SET id = ?, foodName = ?, description = ?, price = ? WHERE food.id = ?");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(2, entry.getName());
            pstmt.setString(3, entry.getDescription());
            pstmt.setDouble(4, entry.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM food WHERE food.id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
