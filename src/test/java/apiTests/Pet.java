package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pet {

    //Padrão
    //Given = dado
    //When = quando
    //Then = entao

    public String lerJason(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet() throws IOException {

        String jsonBody = lerJason("src/test/resources/data/pet.json");

        given()
                .contentType("application/json")   //tipo de conteúdo.
                .log().all()                       // registrar tudo do envio
                .body(jsonBody)
        .when()
                .post("https://petstore.swagger.io/v2/pet")     // comando +endpoint
        .then()
                .log().all()            //registrar tudo da volta
                .statusCode(200)        //código do estado. 200 significa que você transmitir seu pedido e recebeu um retorno
                .body("id", is(1987))       // faz a mesma coisa da linha de cima
                .body("name", is("Snoopy"))
                .body("category.name", is("dog"))
                //valida se contem a palavra chave
                .body("tags.name", contains("vermifugado ok"))
                //.body("tags.name", containsString("vermifugado"))
        ;

    }

    @Test
    public void consultarPet(){
            String petId = "1987"; // id do animal

            given()
                    .contentType("application/json")
                    .log().all()
            .when()
                    .get("https://petstore.swagger.io/v2/pet/" + petId) //consultar
            .then()
                    .log().all()
                    .statusCode(200)
                    .body("name", is("Snoopy"))
                    .body("status", is("available"))
                    ;


    }

}
