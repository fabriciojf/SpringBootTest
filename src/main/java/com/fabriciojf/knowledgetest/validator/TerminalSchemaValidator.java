package com.fabriciojf.knowledgetest.validator;

import com.fabriciojf.knowledgetest.error.ObjectNotCorrespondingError;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import com.fabriciojf.knowledgetest.schema.JsonSchema;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.everit.json.schema.ValidationException;

/**
 * @author Fabricio S Costa fabriciojf@gmail.com
 * @class TerminalSchemaValidator
 * @since 25/02/2021
 */
public class TerminalSchemaValidator {

    private final JSONObject jsonData;
    private final JsonSchema jsonSchema;

    public TerminalSchemaValidator(JSONObject jsonData, JsonSchema jsonSchema) {
        this.jsonData = jsonData;
        this.jsonSchema = jsonSchema;
    }

    public JSONObject processValidation() {

        JSONTokener schemaTokener = new JSONTokener(jsonSchema.getSchema());
        JSONObject schema = new JSONObject(schemaTokener);

        JSONTokener jsonDataTokener = new JSONTokener(jsonData.toString());
        JSONObject jsonObject = new JSONObject(jsonDataTokener);

        try {
            Schema schemaValidator = SchemaLoader.load(schema);
            schemaValidator.validate(jsonObject);
            return jsonObject;
        } catch (ValidationException error) {

            String field = getFieldInValidationError(error.getErrorMessage());
            throw new ObjectNotCorrespondingError(
                    "Dados do Json não correspondem ao Schema " + field.trim());
        }
    }

    private String getFieldInValidationError(String errorMessage) {
        String field = "";
        Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(errorMessage);
        if (matcher.find()) {
            field = "[field: " + matcher.group(1) + "]";
        }
        return field;
    }
}
