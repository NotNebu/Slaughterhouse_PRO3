import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Recall;
import Slaughterhouse.Repository.RecallRepository;
import Slaughterhouse.Service.CuttingService;
import Slaughterhouse.Service.PackingService;
import Slaughterhouse.Service.RecallService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Slaughterhouse.PackingApplication.class)
public class RecallServiceTest {

    @Autowired
    private RecallService recallService;

    @MockBean
    private RecallRepository recallRepository;

    @MockBean
    private CuttingService cuttingService;

    @MockBean
    private PackingService packingService;

    @Test
    public void testInitiateRecall() {
        // Mocking animal details from CuttingService
        Animal animal = new Animal();
        animal.setId(1);

        Product product = new Product();
        product.setId(1);
        product.setDescription("Recalled Product");

        Mockito.when(cuttingService.getAnimalById(1)).thenReturn(animal);
        Mockito.when(packingService.getProductsByAnimal(1)).thenReturn(List.of(product));
        Mockito.when(recallRepository.save(Mockito.any(Recall.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Recall recall = recallService.initiateRecall(1);

        assertNotNull(recall);
        assertEquals(1, recall.getAnimalId());
        assertEquals("1", recall.getAffectedProducts());
        Mockito.verify(packingService).markProductRecalled(1);
    }
}
