package com.fabriciojf.knowledgetest.model;

import com.fabriciojf.knowledgetest.error.ObjectNotCorrespondingError;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TerminalTest {

    private Terminal terminal;
    private JSONObject jsonData;

    @BeforeEach
    public void setUp() {
        terminal = new Terminal();
        jsonData = new JSONObject();
        try {

            jsonData.put("logic", 44332211);
            jsonData.put("serial", "123");
            jsonData.put("model", "PWWIN");
            jsonData.put("sam", 0);
            jsonData.put("ptid", "F04A2E4088B");
            jsonData.put("plat", 4);
            jsonData.put("version", "8.00b3");
            jsonData.put("mxr", 0);
            jsonData.put("mxf", "16777216");
            jsonData.put("verfm", "PWWIN");

        } catch (JSONException ex) {
            fail("Erro ao criar o Json Object com o modelo de dados válido");
        }
    }

    @Test
    public void testAdaptJsonObjectWithValidJson() {
        terminal.adaptJsonObject(jsonData);
        assertEquals("PWWIN", terminal.getModel());
    }

    @Test
    public void testAdaptJsonObjectWithEmptyJson() {

        RuntimeException runtimeException = assertThrows(
                ObjectNotCorrespondingError.class,
                () -> terminal.adaptJsonObject(new JSONObject()));

        assertTrue(runtimeException.getMessage().contains(
                "Falha ao adaptar o Objeto Json ao modelo Terminal"));
    }

    @Test
    public void testAdaptJsonObjectWithInvalidJson() {

        try {
            jsonData.remove("logic");
            jsonData.put("logic", "PWD");
        } catch (JSONException ex) {
            fail("Erro ao alterar o Json Object");
        }

        RuntimeException runtimeException = assertThrows(
                ObjectNotCorrespondingError.class,
                () -> terminal.adaptJsonObject(jsonData));

        assertTrue(runtimeException.getMessage().contains(
                "Falha ao adaptar o Objeto Json ao modelo Terminal"));
    }
}
