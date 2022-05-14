package com.BKS.webservice.springboot.web;

//import com.BKS.webserivce.springboot.web.dto.HelloResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
        import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = HelloController.class)
@WebMvcTest(controllers = HelloController.class)

// @SpringBootTest(classes = HelloController.class)
//@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    public void hello_리턴된다() throws Exception {
        String hello = "hello";

        this.mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        this.mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
