package RestAssuredEstudo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class UsersTest {

    @Test
    public void usersGetAll(){

        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users")
                .then().statusCode(200).
                body("", Matchers.hasSize(3)).
                body("id", Matchers.hasItems(1,2,3));

    }

    @Test
    public void usersGetPrimeiroTest() {

        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/1")
                .then().statusCode(200).
                body("id", Matchers.is(1)).
                body("name", Matchers.containsString("Silva")).
                body("age", Matchers.greaterThan(18)).
                body("salary", Matchers.is(1234.5677f));

    }

    @Test
    public void usersGetSegundoTest() {

        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/2")
                .then().statusCode(200).
                body("id", Matchers.is(2)).
                body("name", Matchers.containsString("Joaquina")).
                body("age", Matchers.greaterThan(18)).
                body("endereco.rua", Matchers.is("Rua dos bobos")).
                body("endereco.numero", Matchers.is(0)).
                body("salary", Matchers.is(2500));

    }

    @Test
    public void usersGetTerceiroTest() {

        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/3")
                .then().statusCode(200).
                body("id", Matchers.is(3)).
                body("name", Matchers.containsString("Júlia")).
                body("age", Matchers.greaterThan(18)).
                body("filhos", Matchers.hasSize(2)).
                body("filhos.name", Matchers.hasItems("Zezinho", "Luizinho"));

    }

    @Test
    public void usersGetQuartoTest() {

        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/4")
                .then().statusCode(404).
                body("error", Matchers.is("Usuário inexistente"));
    }

}
