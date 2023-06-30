package quru.qa.qa_guru_files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingDataWithZipFileTest {
    String pdfFile = "primerPDF.pdf";
    String xlsxFile = "Xlsx.xlsx";
    String csvFile = "countries.csv";
    @Test
    void zipTestXls() throws Exception {
        try (ZipFile zipFile = new ZipFile("src/test/resources/example.zip")) {
            ZipEntry xlsxEntry = zipFile.getEntry(xlsxFile);
            try (InputStream stream = zipFile.getInputStream(xlsxEntry)) {
                XLS xlsx = new XLS(stream);
                String actualName = xlsx.excel.getSheetAt(0)
                        .getRow(0)
                        .getCell(0)
                        .getStringCellValue();

                assertEquals("test on I v africe test", actualName);
            }
        }
    }

    @Test
    public void pdfTest() throws Exception {
        try (ZipFile zipFile = new ZipFile("src/test/resources/example.zip")) {
            ZipEntry pdfEntry = zipFile.getEntry(pdfFile);
            try (InputStream stream = zipFile.getInputStream(pdfEntry)) {
                PDF pdf = new PDF(stream);
                assertEquals("Soda PDF Server", pdf.producer);
            }
        }
    }


    @Test
    public void csvTest() throws Exception {
        try (ZipFile zipFile = new ZipFile("src/test/resources/example.zip")) {
            ZipEntry csvEntry = zipFile.getEntry(csvFile);
            try (InputStream stream = zipFile.getInputStream(csvEntry)) {
                CSVReader csvReader = new CSVReader(new InputStreamReader(stream));
                List<String[]> content = csvReader.readAll();
                assertEquals(content.size(), 4);
                final String[] firstRow = content.get(0);
                final String[] secondRow = content.get(1);
                final String[] thirdRow = content.get(2);
                final String[] fourthRow = content.get(3);

                Assertions.assertArrayEquals(new String[]{"Country", "Capital", "Language"}, firstRow);
                Assertions.assertArrayEquals(new String[]{"Russia", "Moscow", "Russian"}, secondRow);
                Assertions.assertArrayEquals(new String[]{"Ukraine", "Kiev", "Ukrainian"}, thirdRow);
                Assertions.assertArrayEquals(new String[]{"Belarus", "Minsk", "Belarusian"}, fourthRow);

            }
        }
    }
}
