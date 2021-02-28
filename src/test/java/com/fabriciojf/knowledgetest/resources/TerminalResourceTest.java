package com.fabriciojf.knowledgetest.resources;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import com.fabriciojf.knowledgetest.model.Terminal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.fabriciojf.knowledgetest.repository.TerminalRepository;
import com.google.common.base.Optional;
import static org.hamcrest.CoreMatchers.containsString;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.mockito.Mockito.when;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WithMockUser(username = "/admin", password = "spr1n6b00t")    
public class TerminalResourceTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TerminalRepository terminalRepository;
    
    @Test
    public void testGetTerminalByLogicNotFound() throws Exception {
        
        when(terminalRepository.findByLogic(11)).thenReturn(
                Optional.of(new Terminal()));
        
        mockMvc
                .perform(get("/1.0b/terminals/11"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("not found")));
    }
    
    @Test
    public void testGetTerminalByLogicWithValidObject() throws Exception {
        
        Terminal terminal = getTerminal();
        Optional<Terminal> terminalMock = Optional.of(terminal);
        when(terminalRepository.findByLogic(44332211)).thenReturn(terminalMock);
        
        mockMvc
                .perform(get("/1.0b/terminals/44332211"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.logic").value(
                        terminal.getLogic()));
        
    }
    
    @Test
    public void testInsertWithValidInput() throws Exception {
        
        String terminalCsv = "44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
        
        mockMvc
                .perform(post("/1.0b/terminals")
                    .contentType(MediaType.TEXT_HTML)
                    .characterEncoding("utf-8")
                    .content(terminalCsv))
                .andExpect(status().isNotFound());
    }
    
    @Test
    public void testInsertInvalidWithLogicNull() throws Exception {
        
        String terminalCsv = ";123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN";
        
        mockMvc
                .perform(post("/1.0b/terminals")
                    .contentType(MediaType.TEXT_HTML)
                    .characterEncoding("utf-8")
                    .content(terminalCsv))
                .andExpect(status().is(404));
    }
    
    @Test
    public void testInsertInvalidWithJson() throws Exception {        
        mockMvc
                .perform(post("/1.0b/terminals")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(objectMapper.writeValueAsString(terminal)))
                .andExpect(status().isNotFound());
    }
        
    
    public Terminal getTerminal() {        
        Terminal terminal = new Terminal();
        terminal.setLogic(123);
        terminal.setModel("Model test");
        terminal.setMxf("");
        terminal.setMxr(0);
        terminal.setPlat(0);
        terminal.setPtid("");
        terminal.setSam(0);
        terminal.setSerial("");
        terminal.setVerfm("");
        terminal.setVersion("");
        
        return terminal;
    }

}
