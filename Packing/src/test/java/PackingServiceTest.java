import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.ProductRepository;
import Slaughterhouse.Repository.TrayRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Slaughterhouse.PackingApplication.class)
@AutoConfigureMockMvc
public class PackingServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private TrayRepository trayRepository;

    // Test for creating a product
    @Test
    public void testCreateProduct() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setDescription("Test Product");

        Tray tray = new Tray();
        tray.setId(1);
        tray.setType("Leg");

        product.setTrays(List.of(tray));

        Mockito.when(trayRepository.findById(1)).thenReturn(Optional.of(tray));
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/api/packing/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"description\": \"Test Product\", \"trays\": [{\"id\": 1}] }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description").value("Test Product"));
    }

    // Test for getting all products
    @Test
    public void testGetAllProducts() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setDescription("Test Product");
        product.setStatus(Product.ProductStatus.ACTIVE);

        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/api/packing/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].description").value("Test Product"));
    }

    // Test for getting a product by ID
    @Test
    public void testGetProductById() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setDescription("Test Product");

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

        mockMvc.perform(get("/api/packing/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.description").value("Test Product"));
    }

    // Test for recalling products by animal ID
    @Test
    public void testRecallProductsByAnimal() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setDescription("Test Product");

        Tray tray = new Tray();
        tray.setId(1);

        product.setTrays(List.of(tray));

        Mockito.when(productRepository.findAll()).thenReturn(List.of(product));

        mockMvc.perform(get("/api/packing/products/recall/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }

    // Test for marking a product as recalled
    @Test
    public void testMarkProductRecalled() throws Exception {
        Product product = new Product();
        product.setId(1);
        product.setStatus(Product.ProductStatus.ACTIVE);

        Mockito.when(productRepository.findById(1)).thenReturn(Optional.of(product));

        mockMvc.perform(put("/api/packing/products/1/recall"))
                .andExpect(status().isOk());

        Mockito.verify(productRepository).save(Mockito.any(Product.class));
    }
}
