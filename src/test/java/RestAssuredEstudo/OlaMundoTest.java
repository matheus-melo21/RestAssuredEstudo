package RestAssuredEstudo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class OlaMundoTest {

    @Test
    @Dado("que get foi um sucesso")
    public void que_get_foi_um_sucesso() {
        RestAssured.get("http://restapi.wcaquino.me/ola").
                then().statusCode(200)
                .body(Matchers.is("Ola Mundo!"));
    }

    @Então("possuir a mensagem {string} no body")
    public void possuir_a_mensagem_no_body(String string) {

        RestAssured.get("http://restapi.wcaquino.me/ola").
                then()
                .body(Matchers.is("Ola Mundo!"));

    }

}
