package RestAssuredEstudo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;


public class UsersTest {

    @Test
    @Dado("que o User esta cadastrado")
    public void que_o_user_esta_cadastrado() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users")
                .then().
                body("",Matchers.hasItems());
    }

    @Test
    @Quando("listar todos os Users")
    public void listar_todos_os_users() {
        Response response = RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users");

        System.out.println(response.asString());
    }

    @Test
    @Então("o teste deve retonar statuscode {int}")
    public void o_teste_deve_retonar_statuscode() {
               RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users")
                .then().statusCode(200);
    }

    @Test
    @Então("possuir apenas {int} Users")
    public void possuir_apenas_users() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users")
                .then().statusCode(200).
                body("", Matchers.hasSize(3));
    }

    @Test
    @Então("possuir os ids {double}")
    public void possuir_os_ids() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users")
                .then().statusCode(200).
                body("id", Matchers.hasItems(1,2,3));
    }

    @Test
    @Quando("listar User")
    public void listar_user() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/1")
                .then().
                body("",Matchers.hasItems());
    }

    @Test
    @Então("deve ter o id {int}")
    public void deve_ter_o_id() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/1")
                .then().statusCode(200).
                body("id", Matchers.is(1));
    }

    @Test
    @Então("o nome deve possuir Silva")
    public void o_nome_deve_possuir_silva() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/1")
                .then().statusCode(200).
                body("name", Matchers.containsString("Silva"));
    }

    @Test
    @Então("possuir idade maior que {int}")
    public void possuir_idade_maior_que() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/1")
                .then().statusCode(200).
                body("age", Matchers.greaterThan(18));
    }

    @Test
    @Então("salario de {double}")
    public void salario_id() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/1")
                .then().statusCode(200).
                body("salary", Matchers.is(1234.5677f));;
    }

    @Test
    @Então("o nome deve possuir Joaquina")
    public void o_nome_deve_possuir_joaquina() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/2")
                .then().statusCode(200).
                body("name", Matchers.containsString("Joaquina"));
    }

    @Test
    @Então("salario de {int}")
    public void salario_de() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/2")
                .then().statusCode(200).
                body("salary", Matchers.is(2500));;
    }

    @Test
    @Então("o endereco possuir Rua dos bobos e numero {int}")
    public void o_endereco_possuir_rua_dos_bobos_e_numero() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/2")
                .then().statusCode(200).
                body("endereco.rua", Matchers.is("Rua dos bobos")).
                body("endereco.numero", Matchers.is(0));
    }

    @Test
    @Então("o nome deve possuir Júlia")
    public void o_nome_deve_possuir_júlia() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/3")
                .then().statusCode(200).
                body("name", Matchers.containsString("Júlia"));
    }

    @Test
    @Então("ter {int} filhos")
    public void ter_filhos() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/3")
                .then().statusCode(200).
                body("filhos", Matchers.hasSize(2));
    }

    @Test
    @Então("Os nomes dos filhos deve ser Zezinho e Luizinho")
    public void os_nomes_dos_filhos_deve_ser_zezinho_e_luizinho() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/3")
                .then().statusCode(200).
                body("filhos.name", Matchers.hasItems("Zezinho", "Luizinho"));;
    }

    @Test
    @Dado("que o User não esta cadastrado")
    public void que_o_user_não_esta_cadastrado() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/4")
                .then().statusCode(404);
    }

    @Test
    @Então("deve ter o statuscode {int}")
    public void deve_ter_o_statuscode() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/4")
                .then().statusCode(404);
    }

    @Test
    @Então("body retornando uma mensagem de usuário inexistente")
    public void body_retornando_uma_mensagem_de_usuário_inexistente() {
        RestAssured.given()
                .when()
                .get("http://restapi.wcaquino.me/users/4")
                .then().
                body("error", Matchers.is("Usuário inexistente"));;
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



}
