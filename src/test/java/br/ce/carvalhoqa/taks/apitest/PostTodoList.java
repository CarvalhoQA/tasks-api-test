package br.ce.carvalhoqa.taks.apitest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;

import java.time.LocalDate;


public class PostTodoList extends BaseTest{

    JSONObject requisicaoCadastrarTasklist;
    public Response respostaCadastrarTasklist;
    LocalDate data = LocalDate.now();
    public void HealthCheckCadastrarTasklist() {
        RequestSpecification httpRequest = RestAssured.given();

        requisicaoCadastrarTasklist = new JSONObject();
        requisicaoCadastrarTasklist.put(Constantes.DESCRICAO_TASK, GeradorDeDados().commerce().material());
        requisicaoCadastrarTasklist.put(Constantes.DATA, data.plusDays(7).toString());

        httpRequest.body(requisicaoCadastrarTasklist.toJSONString());

        respostaCadastrarTasklist = httpRequest.request(Method.POST, CADASTRAR_TASK_LIST);
    }

    public void FuncionalCadastrarTasklist() {
        RequestSpecification httpRequest = RestAssured.given();

        requisicaoCadastrarTasklist = new JSONObject();
        requisicaoCadastrarTasklist.put(Constantes.DESCRICAO_TASK, "Tarefa teste funcional");
        requisicaoCadastrarTasklist.put(Constantes.DATA, data.plusDays(7).toString());

        httpRequest.body(requisicaoCadastrarTasklist.toJSONString());

        respostaCadastrarTasklist = httpRequest.request(Method.POST, CADASTRAR_TASK_LIST);
    }

    public void CadastrarTasklistParametroDataInvalido() {
        RequestSpecification httpRequest = RestAssured.given();

        requisicaoCadastrarTasklist = new JSONObject();
        requisicaoCadastrarTasklist.put(Constantes.DESCRICAO_TASK, "Tarefa teste funcional");
        requisicaoCadastrarTasklist.put(Constantes.DATA, data.minusDays(7).toString());

        httpRequest.body(requisicaoCadastrarTasklist.toJSONString());

        respostaCadastrarTasklist = httpRequest.request(Method.POST, CADASTRAR_TASK_LIST);
    }
}
