package quru.qa.qa_guru_files;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quru.qa.qa_guru_files.model.JsonSample;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ParsingDataWithJsonTest {

    Gson gson = new Gson();

    @Test
    void jsonTest() throws Exception {
        try (InputStream stream = getClass().getResourceAsStream("/id.json");
             Reader reader = new InputStreamReader(stream)) {
             JsonSample jsonObject  = gson.fromJson(reader, JsonSample.class);

            Assertions.assertEquals(2122, jsonObject.getId());
            Assertions.assertEquals("ТОО", jsonObject.getName());
            Assertions.assertEquals("12334235566", jsonObject.getIdn());
            Assertions.assertEquals("1995", jsonObject.getJsonSampleModel().getId());
            Assertions.assertEquals("asd", jsonObject.getJsonSampleModel().getName());
            Assertions.assertEquals("площадь Республики", jsonObject.getJsonSampleModel().getAddress());
            Assertions.assertTrue(jsonObject.getJsonSampleModel().isStatus());

        }
    }
}
