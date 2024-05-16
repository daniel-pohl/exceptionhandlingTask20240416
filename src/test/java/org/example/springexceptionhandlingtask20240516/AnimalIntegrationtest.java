package org.example.springexceptionhandlingtask20240516;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnimalIntegrationtest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAnimalSpecies_Success() throws Exception {
        mockMvc.perform(get("/api/animals/dog")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("dog"));
    }

    @Test
    public void testGetAnimalSpecies_Failure() throws Exception {
        mockMvc.perform(get("/api/animals/cat")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Only 'dog' is allowed"));
    }
//
//    @Test
//    public void testGetAllAnimals_Exception() throws Exception {
//        mockMvc.perform(get("/api/animals")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andExpect(jsonPath("$.message").value("No Animals found"));
//    }

}
