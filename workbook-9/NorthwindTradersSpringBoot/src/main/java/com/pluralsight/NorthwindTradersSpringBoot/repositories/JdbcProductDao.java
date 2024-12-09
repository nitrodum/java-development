package com.pluralsight.NorthwindTradersSpringBoot.repositories;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {

    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int add(Product product) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                     INSERT INTO products (ProductName, CategoryID, UnitPrice)
                     VALUES (?, ?, ?);""", Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, product.getName());
            statement.setInt(2, Integer.parseInt(product.getCategory()));
            statement.setDouble(3, product.getPrice());

            int rows = statement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);

            try (ResultSet keys = statement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.printf("%d key was added\n", keys.getLong(1));
                    product.setProductID((int) keys.getLong(1));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product.getProductID();
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
             ResultSet rs = statement.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("ProductID");
                String name = rs.getString("ProductName");
                String category = rs.getString("CategoryID");
                double price = rs.getDouble("UnitPrice");
                products.add(new Product(id, name, category, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        Product p = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
             SELECT * FROM products
             WHERE ProductID = ?""");
        ) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("ProductName");
                    String category = rs.getString("CategoryID");
                    double price = rs.getDouble("UnitPrice");
                    p = new Product(id, name, category, price);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    @Override
    public Product update(int id, Product product) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
