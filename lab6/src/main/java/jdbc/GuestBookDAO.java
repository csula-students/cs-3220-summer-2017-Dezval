package jdbc;

/**
 * Created by Dezval on 7/29/2017.
 */
import dao.DAO;
import dao.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class GuestBookDAO implements DAO<GuestBookEntry> {
    public List<GuestBookEntry> list() {
        List<GuestBookEntry> list = new ArrayList<>();
        Database db = new Database();
        try (Connection c = db.connection()) {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM guestbook");
            while (rs.next()) {
                list.add(new GuestBookEntry(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("message"),
                        list.size()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }

    public Optional<GuestBookEntry> get(int id) {
        return Optional.empty();
    }

    public void add(GuestBookEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO guestbook (id ,name, message) VALUES (?, ?, ?)");
            pstmt.setInt(1,entry.getId());
            pstmt.setString(2, entry.getName());
            pstmt.setString(3, entry.getComment());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(GuestBookEntry entry) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("UPDATE guestbook SET id = ?, name = ?, message = ? WHERE guestbook.id = ?");
            pstmt.setInt(1, entry.getId());
            pstmt.setString(2, entry.getName());
            pstmt.setString(3, entry.getComment());
            pstmt.setInt(4, entry.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Database db = new Database();
        try (Connection c = db.connection()) {
            PreparedStatement pstmt = c.prepareStatement("DELETE FROM guestbook WHERE guestbook.id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.list().remove(id);
    }
}
