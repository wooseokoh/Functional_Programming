package exam.ex12.optional.functional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exam.ex09.streammapexception.Result;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class ExampleRefactoredImproved {

    private final ObjectMapper objectMapper;

    public Map buildResponseMessageMapAfter(String response, String responseType){
        return Optional.of(jsonMessage(response, responseType))
                .map(StringUtils::stripToNull)
                .map(message -> Result.attempt(() -> {
                    try {
                        return objectMapper.readValue(message, Map.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }))
                .map(Result::getValue)
                .orElse(Collections.emptyMap());
    }

    private String jsonMessage(String message, String type){
        if(type.equals("NONEXCEPTION")) {
            return message;
        }
        return  String.format("{\"message\":%s}",
                Optional.of(message)
                        .filter(this::hasBrackets)
                        .map(this::errorMessage)
                        .orElse(message));
    }

    private String errorMessage(String message) {
        return "{\"message\":[\"Error." + message.replace("\"", "\\\"") + "\"]}";
    }

    private boolean hasBrackets(String message) {
        return !message.contains("{") && !message.contains("[");
    }
}
