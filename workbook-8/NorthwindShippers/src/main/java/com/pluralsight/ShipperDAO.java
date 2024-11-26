package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShipperDAO {
    private BasicDataSource dataSource;

    public ShipperDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Shipper> getAllShippers() {
        List<Shipper> shippers = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM shippers");
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                int shipperID = results.getInt("ShipperID");
                String companyName = results.getString("CompanyName");
                String phone = results.getString("Phone");
                Shipper s = new Shipper(shipperID, companyName, phone);
                shippers.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return shippers;
    }

    public void add(Shipper s) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                     INSERT INTO shippers (CompanyName, Phone)
                     VALUES (?, ?);""", Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, s.getCompanyName());
            statement.setString(2, s.getPhone());

            int rows = statement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);

            try (ResultSet keys = statement.getGeneratedKeys()) {
                while (keys.next()) {
                    System.out.printf("%d key was added\n", keys.getLong(1));
                    s.setShipperID((int) keys.getLong(1));
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePhone(int id, String phone) {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("""
                    UPDATE shippers
                    SET Phone = ?
                    WHERE ShipperID = ?""")
        ) {
            statement.setString(1, phone);
            statement.setLong(2, id);

            int rows = statement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteRecord(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("""
                    DELETE FROM shippers
                    WHERE ShipperID = ?""")
        ) {
            statement.setLong(1, id);

            int rows = statement.executeUpdate();

            System.out.printf("Rows updated %d\n", rows);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
