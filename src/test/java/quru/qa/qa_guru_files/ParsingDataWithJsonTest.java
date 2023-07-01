package quru.qa.qa_guru_files;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quru.qa.qa_guru_files.model.JsonSample;

import java.io.IOException;
import java.io.InputStream;


public class ParsingDataWithJsonTest {

    ClassLoader cl = ParsingDataWithJsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonTest() throws IOException {
        InputStream stream = cl.getResourceAsStream("id.json");
        JsonSample jsonObject = objectMapper.readValue(stream, JsonSample.class);

            Assertions.assertEquals(2122, jsonObject.getId());
            Assertions.assertEquals("ТОО", jsonObject.getName());
            Assertions.assertEquals("12334235566", jsonObject.getIdn());
            Assertions.assertEquals("1995", jsonObject.getPosList().get(0).getId());
            Assertions.assertEquals("asd", jsonObject.getPosList().get(0).getName());
            Assertions.assertEquals("площадь Республики", jsonObject.getPosList().get(0).getAddress());
            Assertions.assertTrue(jsonObject.getPosList().get(0).isStatus());


    }
}
