package Utils;
import Objects.LoginCreds;
import com.fasterxml.jackson.databind.ObjectMapper;
import rethink.selenium.BaseTest;

import java.io.IOException;
import java.io.InputStream;
public class JacksonUtils  extends BaseTest {

    public static LoginCreds deserializeJson(InputStream is , LoginCreds loginCreds) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is,loginCreds.getClass());
    }
}
