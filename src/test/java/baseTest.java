import org.junit.Before;

import static io.restassured.RestAssured.baseURI;

public class baseTest {

    @Before
    public void
    setup_settings() {
        baseURI = "http://restapi.demoqa.com/customer";    }
}
