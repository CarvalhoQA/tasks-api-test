package br.ce.carvalhoqa.taks.apitest.post;

import br.ce.carvalhoqa.taks.apitest.BaseTest;
import br.ce.carvalhoqa.taks.apitest.utilitarios.Constantes;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;

import java.time.LocalDate;


public class PostTodoList extends BaseTest {

    JSONObject requisicaoCadastrarTasklist;
    public Response respostaCadastrarTasklist;
    LocalDate data = LocalDate.now();

    public void healthCheckCadastrarTasklist() {
        RequestSpecification httpRequest = RestAssured.given();

        requisicaoCadastrarTasklist = new JSONObject();
        requisicaoCadastrarTasklist.put(Constantes.TASK, GeradorDeDados().commerce().material());
        requisicaoCadastrarTasklist.put(Constantes.DATA, data.plusDays(7).toString());

        httpRequest.body(requisicaoCadastrarTasklist.toJSONString());

        respostaCadastrarTasklist = httpRequest.request(Method.POST, CADASTRAR_TASK_LIST);
    }

    public void funcionalCadastrarTasklist() {
        RequestSpecification httpRequest = RestAssured.given();

        requisicaoCadastrarTasklist = new JSONObject();
        requisicaoCadastrarTasklist.put(Constantes.TASK, Constantes.DESCRICAO_TASK);
        requisicaoCadastrarTasklist.put(Constantes.DATA, data.plusDays(7).toString());

        httpRequest.body(requisicaoCadastrarTasklist.toJSONString());

        respostaCadastrarTasklist = httpRequest.request(Method.POST, CADASTRAR_TASK_LIST);
    }

    public void cadastrarTasklistParametroDataInvalido() {
        RequestSpecification httpRequest = RestAssured.given();

        requisicaoCadastrarTasklist = new JSONObject();
        requisicaoCadastrarTasklist.put(Constantes.TASK, Constantes.DESCRICAO_TASK);
        requisicaoCadastrarTasklist.put(Constantes.DATA, data.minusDays(7).toString());

        httpRequest.body(requisicaoCadastrarTasklist.toJSONString());

        respostaCadastrarTasklist = httpRequest.request(Method.POST, CADASTRAR_TASK_LIST);
    }
}