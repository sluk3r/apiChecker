package readContentFromClasspathFile;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

import static org.junit.Assert.*;

public class ClassPathFileCotentReaderTest {
    String path = "readContent/xmlContentForTest.xml";


    @Test
    public void readContent() throws IOException {
        //这里添加了“classpath”关键字后， 才不抛异常。
        File file = ResourceUtils.getFile("classpath:" + path);
        String content = new String(Files.readAllBytes(file.toPath()));
        assertNotNull(content);
        assertTrue(content.contains("sssssssssssssssssss"));
    }


    @Test
    public void readContentWithoutClasspathThrowException() throws IOException {

        try {
            File file = ResourceUtils.getFile(path);
            String content = new String(Files.readAllBytes(file.toPath()));
            fail("因为抛异常不应该到这里");
        } catch (Exception e) {
            //没有使用“classpath”关键字抛异常。  ATTENTION
            assertTrue(e instanceof  NoSuchFileException);
        }



    }
}
