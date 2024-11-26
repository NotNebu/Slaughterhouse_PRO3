import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Slaughterhouse.AnimalRegistrationApplication.class)
@AutoConfigureMockMvc
public class AnimalServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnimalRepository animalRepository;

    @Test
    public void testRegisterAnimal() throws Exception {
        Animal animal = new Animal();
        animal.setId(1);
        animal.setRegistrationNumber("A01");
        animal.setWeight(300.5);
        animal.setArrivalDate("2024-11-01");
        animal.setOrigin("Farm A");

        Mockito.when(animalRepository.save(Mockito.any(Animal.class))).thenReturn(animal);

        mockMvc.perform(post("/api/animals")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"registrationNumber\": \"A01\", \"weight\": 300.5, \"arrivalDate\": \"2024-11-01\", \"origin\": \"Farm A\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registrationNumber").value("A01"))
                .andExpect(jsonPath("$.weight").value(300.5));
    }

    @Test
    public void testGetAnimalById() throws Exception {
        Animal animal = new Animal();
        animal.setId(1);
        animal.setRegistrationNumber("A01");

        Mockito.when(animalRepository.findById(1)).thenReturn(Optional.of(animal));

        mockMvc.perform(get("/api/animals/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registrationNumber").value("A01"));
    }
}
