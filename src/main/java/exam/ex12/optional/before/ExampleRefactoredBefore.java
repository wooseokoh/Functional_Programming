package exam.ex12.optional.before;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.Map;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
public class ExampleRefactoredBefore {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public Map buildResponseMessageMap(String response, String responseType){
        String mapMsg = "";
        Map rspMsgObj = null;
        if (responseType.equals("NONEXCEPTION")){
            mapMsg = response;
        }else if(response != null){
            if(response.indexOf('{') != 0 && response.indexOf('[') != 0){
                mapMsg = "{\"message\":[\"Error." + response.replace("\"", "\\\"") + "\"]}";
            }else{
                mapMsg = "{\"message\":" + response +"}";
            }
        }
        if(!mapMsg.equals("")){
            rspMsgObj = objectMapper.readValue(mapMsg, Map.class);
        }
        return rspMsgObj;
    }
}
