package RestAssuredEstudo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class OlaMundoTest {

    @Test
    public void testOlaMundo(){
        RestAssured.get("http://restapi.wcaquino.me/ola").
                then().statusCode(200)
                .body(Matchers.is("Ola Mundo!"))
                .body(Matchers.is(Matchers.not(null)));
    }

}
