package com.fabriciojf.knowledgetest.resources;

import com.fabriciojf.knowledgetest.error.ObjectNotFoundError;
import com.fabriciojf.knowledgetest.model.Terminal;
import com.fabriciojf.knowledgetest.repository.TerminalRepository;
import com.fabriciojf.knowledgetest.schema.TerminalSchema;
import com.fabriciojf.knowledgetest.util.TerminalUtil;
import com.fabriciojf.knowledgetest.validator.TerminalSchemaValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class TerminalResource
 * @since 24/02/2021
 */
@RestController
@RequestMapping(value = "/1.0b/terminals")
@ResponseBody
public class TerminalResource {

    @Autowired
    TerminalRepository terminalRepository;

    @RequestMapping(value = "/{logic}", method = RequestMethod.GET)
    public ResponseEntity<?> getTerminalByLogic(@PathVariable int logic) {
        terminalExists(logic);
        Terminal terminal = terminalRepository.findByLogic(logic);
        return new ResponseEntity<>(terminal, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST,
            consumes = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<?> insert(@RequestBody String terminalData) {
        
        JSONObject jsonData = new TerminalUtil(terminalData).adaptCsvLineToJson();
        JSONObject terminalJson = new TerminalSchemaValidator(
                jsonData, new TerminalSchema()).processValidation();

        Terminal terminal = new Terminal();
        terminal.adaptJsonObject(terminalJson);

        terminalRepository.save(terminal);
        return new ResponseEntity<>(terminal, HttpStatus.OK);
    }    
    
    @RequestMapping(value = "/{logic}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Terminal terminal, @PathVariable int logic) {
        
        terminalExists(logic); 
        terminalIsValid(new JSONObject(terminal));
        
        terminal.setLogic(logic);        
        terminalRepository.save(terminal);
        
        return new ResponseEntity<>(terminal, HttpStatus.OK);
    }

    private void terminalExists(int logic) {
        Terminal terminal = terminalRepository.findByLogic(logic);
        if (terminal == null) {
            throw new ObjectNotFoundError("Terminal for logic " + logic + " not exists.");
        }
    }
    
    private void terminalIsValid(JSONObject jsonTerminal) {        
        new TerminalSchemaValidator(
                jsonTerminal, new TerminalSchema()).processValidation();        
    }
}
