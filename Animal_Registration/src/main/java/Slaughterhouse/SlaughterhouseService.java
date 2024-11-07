package Slaughterhouse;

import io.grpc.stub.StreamObserver;
import org.example.slaughterhouse.SlaughterServiceProto;
import org.example.slaughterhouse.SlaughterhouseServiceGrpc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SlaughterhouseService extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {

    private static final String DB_URL = "jdbc:sqlite:slaughterhouse.db";

    @Override
    public void getAnimalsForProduct(SlaughterServiceProto.ProductRequest request, StreamObserver<SlaughterServiceProto.AnimalListResponse> responseObserver) {
        SlaughterServiceProto.AnimalListResponse.Builder responsebuilder = SlaughterServiceProto.AnimalListResponse.newBuilder();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Animals WHERE id in (SELECT animal_id FROM Parts WHERE id IN (SELECT part_id FROM ProductParts WHERE product_id = " + request.getProductId() + "))";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                SlaughterServiceProto.Animal animal = SlaughterServiceProto.Animal.newBuilder()
                        .setId(rs.getInt("id"))
                        .setRegistrationNumber(rs.getString("registration_number"))
                        .build();
                responsebuilder.addAnimals(animal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        responseObserver.onNext(responsebuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getProductsForAnimal(SlaughterServiceProto.AnimalRequest request, StreamObserver<SlaughterServiceProto.ProductListResponse> responseObserver) {
        SlaughterServiceProto.ProductListResponse.Builder responseBuilder = SlaughterServiceProto.ProductListResponse.newBuilder();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Products WHERE id IN (SELECT product_id FROM ProductParts WHERE part_id IN (SELECT id FROM Parts WHERE animal_id = " + request.getAnimalId() + "))";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                SlaughterServiceProto.Product product = SlaughterServiceProto.Product.newBuilder()
                        .setId(rs.getInt("id"))
                        .setDescription("Product with ID: " + rs.getInt("id"))
                        .build();
                responseBuilder.addProducts(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }
}

