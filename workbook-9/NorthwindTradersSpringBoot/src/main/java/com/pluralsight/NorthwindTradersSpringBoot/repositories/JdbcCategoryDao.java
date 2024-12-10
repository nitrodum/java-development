package com.pluralsight.NorthwindTradersSpringBoot.repositories;

import com.pluralsight.NorthwindTradersSpringBoot.models.Category;
import org.hibernate.annotations.processing.SQL;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDao implements CategoryDao {

    private DataSource dataSource;

    public JdbcCategoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories");
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("CategoryID");
                String name = rs.getString("CategoryName");
                categories.add(new Category(id, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category c = null;
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("""
                    SELECT * FROM categories
                    WHERE categoryID = ?""")
        ) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("CategoryName");
                    c = new Category(id, name);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
