import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Recall;
import Slaughterhouse.PackingApplication;
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

@SpringBootTest(classes = PackingApplication.class)
public class RecallServiceTest {

    @Autowired
    private RecallService recallService;

    @MockBean
    private RecallRepository recallRepository;

    @MockBean
    private CuttingService cuttingService;

    @MockBean
    private PackingService packingService;

    // Test for initiating a recall
    @Test
    public void testInitiateRecall() {
        Part part = new Part();
        part.setId(1);

        Product product = new Product();
        product.setId(1);
        product.setDescription("Recalled Product");

        Mockito.when(cuttingService.getPartsByAnimal(1)).thenReturn(List.of(part));
        Mockito.when(packingService.getProductsByAnimal(1)).thenReturn(List.of(product));
        Mockito.when(recallRepository.save(Mockito.any(Recall.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Recall recall = recallService.initiateRecall(1);

        assertNotNull(recall);
        assertEquals(1, recall.getAnimalId());
        assertEquals("1", recall.getAffectedProducts());
        Mockito.verify(packingService).markProductRecalled(1);
    }
}
