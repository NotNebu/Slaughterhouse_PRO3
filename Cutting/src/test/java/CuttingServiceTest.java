import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.PartRepository;
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

@SpringBootTest(classes = Slaughterhouse.CuttingApplication.class)
@AutoConfigureMockMvc
public class CuttingServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartRepository partRepository;

    @MockBean
    private TrayRepository trayRepository;

    // Test for registering a new part
    @Test
    public void testRegisterPart() throws Exception {
        Part part = new Part();
        part.setId(1);
        part.setType("Leg");
        part.setWeight(25.0);

        Mockito.when(partRepository.save(Mockito.any(Part.class))).thenReturn(part);

        mockMvc.perform(post("/api/cutting/parts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"type\": \"Leg\", \"weight\": 25.0 }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Leg"))
                .andExpect(jsonPath("$.weight").value(25.0));
    }

    // Test for assigning a part to a tray
    @Test
    public void testAssignPartToTray() throws Exception {
        Part part = new Part();
        part.setId(1);
        part.setType("Leg");
        part.setWeight(25.0);

        Tray tray = new Tray();
        tray.setId(1);
        tray.setType("Leg");
        tray.setCapacity(100.0);
        tray.setCurrentWeight(50.0);

        // Mock repository calls
        Mockito.when(partRepository.findById(1)).thenReturn(Optional.of(part));
        Mockito.when(trayRepository.findById(1)).thenReturn(Optional.of(tray));
        Mockito.when(partRepository.save(Mockito.any(Part.class))).thenReturn(part);
        Mockito.when(trayRepository.save(Mockito.any(Tray.class))).thenReturn(tray);

        mockMvc.perform(put("/api/cutting/parts/1/assign-tray/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)) // Check Part ID
                .andExpect(jsonPath("$.type").value("Leg")) // Check Part Type
                .andExpect(jsonPath("$.weight").value(25.0)) // Check Part Weight
                .andExpect(jsonPath("$.tray.id").value(1)); // Check Tray ID
    }


    // Test for retrieving parts by animal ID
    @Test
    public void testGetPartsByAnimal() throws Exception {
        Part part = new Part();
        part.setId(1);
        part.setType("Leg");

        Mockito.when(partRepository.findByAnimalId(1)).thenReturn(List.of(part));

        mockMvc.perform(get("/api/cutting/parts/animal/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("Leg"));
    }

    // Test for retrieving trays by type
    @Test
    public void testGetTraysByType() throws Exception {
        Tray tray = new Tray();
        tray.setId(1);
        tray.setType("Leg");

        Mockito.when(trayRepository.findByType("Leg")).thenReturn(List.of(tray));

        mockMvc.perform(get("/api/cutting/trays?type=Leg"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].type").value("Leg"));
    }
}
