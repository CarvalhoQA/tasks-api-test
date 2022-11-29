package br.ce.carvalhoqa.taks.apitest;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.baseURI;

public class BaseTest {

    // Endpoint to-do

    /* Consulta lista de tarefas cadastradas (GET): /tasks-backend/to-do */
    protected static final String CONSULTAR_TASK_LIST = "/tasks-backend/todo";

    /* Consulta lista de tarefas cadastradas (POST): /tasks-backend/to-do */
    protected static final String CADASTRAR_TASK_LIST = "/tasks-backend/todo";

    @BeforeEach
    public void configuracao() {
        baseURI = "http://localhost:8001";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    public static Faker GeradorDeDados() {
        Faker geradorDeDados = new Faker();
        return geradorDeDados;
    }
}
