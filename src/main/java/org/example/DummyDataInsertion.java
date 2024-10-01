package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DummyDataInsertion {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:slaughterhouse.db";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            // animals
            stmt.execute("INSERT INTO Animals (id, registration_number) VALUES (1, 'A001')");
            stmt.execute("INSERT INTO Animals (id, registration_number) VALUES (2, 'A002')");
            stmt.execute("INSERT INTO Animals (id, registration_number) VALUES (3, 'A003')");

            // parts
            stmt.execute("INSERT INTO Parts (id, animal_id) VALUES (1, 1)");
            stmt.execute("INSERT INTO Parts (id, animal_id) VALUES (2, 1)");
            stmt.execute("INSERT INTO Parts (id, animal_id) VALUES (3, 2)");
            stmt.execute("INSERT INTO Parts (id, animal_id) VALUES (4, 3)");

            // trays
            stmt.execute("INSERT INTO Trays (id, part_type, max_capacity) VALUES (1, 'Leg', 100.0)");
            stmt.execute("INSERT INTO Trays (id, part_type, max_capacity) VALUES (2, 'Ribs', 150.0)");

            // products
            stmt.execute("INSERT INTO Products (id, tray_id) VALUES (1, 1)");
            stmt.execute("INSERT INTO Products (id, tray_id) VALUES (2, 2)");

            // product parts
            stmt.execute("INSERT INTO ProductParts (product_id, part_id) VALUES (1, 1)");
            stmt.execute("INSERT INTO ProductParts (product_id, part_id) VALUES (1, 2)");
            stmt.execute("INSERT INTO ProductParts (product_id, part_id) VALUES (2, 3)");
            stmt.execute("INSERT INTO ProductParts (product_id, part_id) VALUES (2, 4)");

            System.out.println("Dummy data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
