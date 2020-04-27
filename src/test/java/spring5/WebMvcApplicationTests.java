package spring5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import spring5.webmvc.model.Events;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class WebMvcApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void form1() throws Exception {
        mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("events"))
                .andExpect(request().sessionAttribute("events", notNullValue()));
    }

    @Test
    void form2() throws Exception {
        mockMvc.perform(post("/events")
                .param("name", "디디")
                .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());

    }

    @Test
    void getEvents() throws Exception {
        mockMvc.perform(get("/events/list")
                .sessionAttr("visitTime", LocalDateTime.now())
                .flashAttr("newEvent", new Events()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
