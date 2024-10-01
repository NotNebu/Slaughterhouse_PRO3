package org.slaugterhouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:slaughterhouse.db";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");

            // Laver alle tabellerne
            // Animals
            String createAnimalsTable = "CREATE TABLE IF NOT EXISTS Animals (" +
                    "id INTEGER PRIMARY KEY," +
                    "registration_number TEXT NOT NULL" +
                    ")";
            stmt.execute(createAnimalsTable);

            // Parts
            String createPartsTable = "CREATE TABLE IF NOT EXISTS Parts (" +
                    "id INTEGER PRIMARY KEY," +
                    "animal_id INTEGER NOT NULL," +
                    "FOREIGN KEY (animal_id) REFERENCES Animals(id)" +
                    ")";
            stmt.execute(createPartsTable);

            // Trays
            String createTraysTable = "CREATE TABLE IF NOT EXISTS Trays (" +
                    "id INTEGER PRIMARY KEY," +
                    "part_type TEXT NOT NULL," +
                    "max_capacity REAL NOT NULL" +
                    ")";
            stmt.execute(createTraysTable);

            // Products
            String createProductsTable = "CREATE TABLE IF NOT EXISTS Products (" +
                    "id INTEGER PRIMARY KEY," +
                    "tray_id INTEGER NOT NULL," +
                    "FOREIGN KEY (tray_id) REFERENCES Trays(id)" +
                    ")";
            stmt.execute(createProductsTable);

            // Product Parts
            String createProductPartsTable = "CREATE TABLE IF NOT EXISTS ProductParts (" +
                    "product_id INTEGER," +
                    "part_id INTEGER," +
                    "FOREIGN KEY (product_id) REFERENCES Products(id)," +
                    "FOREIGN KEY (part_id) REFERENCES Parts(id)" +
                    ")";
            stmt.execute(createProductPartsTable);

            System.out.println("Database and tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
