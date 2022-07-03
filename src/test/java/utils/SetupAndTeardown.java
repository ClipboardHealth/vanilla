package utils;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;

public class SetupAndTeardown {

    @BeforeEach
    public void setUp(){
        Configuration.timeout = 7000;
    }
}
