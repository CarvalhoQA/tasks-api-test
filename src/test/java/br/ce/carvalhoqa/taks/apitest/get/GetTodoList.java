package br.ce.carvalhoqa.taks.apitest.get;

import br.ce.carvalhoqa.taks.apitest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTodoList extends BaseTest {
    public Response respostaConsultarTodoList;

    public void healthCheckConsultarListaTarefas() {
        RequestSpecification httpRequest = RestAssured.given();

        respostaConsultarTodoList = httpRequest.request(Method.GET, CONSULTAR_TASK_LIST);
    }
}
