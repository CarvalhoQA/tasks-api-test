package br.ce.carvalhoqa.taks.apitest.get;

import br.ce.carvalhoqa.taks.apitest.BaseTest;
import br.ce.carvalhoqa.taks.apitest.get.GetTodoList;
import org.junit.Assert;
import org.junit.Test;

import org.apache.http.HttpStatus;

public class GetToDoListTest extends BaseTest {
    public GetTodoList getTodoList;
    public GetToDoListTest() { getTodoList = new GetTodoList();}

    @Test
    public void healthCheckConsultarListaTarefasTest() {

        getTodoList.healthCheckConsultarListaTarefas();

        Assert.assertEquals(HttpStatus.SC_OK, getTodoList.respostaConsultarTodoList.getStatusCode());
    }
}
