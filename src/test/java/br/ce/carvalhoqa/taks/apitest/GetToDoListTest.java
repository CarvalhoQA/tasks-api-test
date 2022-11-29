package br.ce.carvalhoqa.taks.apitest;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetToDoListTest extends BaseTest {
    public GetTodoList getTodoList;
    public GetToDoListTest() { getTodoList = new GetTodoList();}

    @Test
    @DisplayName("Consulta Lista de Tarefas - Health Check")
    public void healthCheckConsultarListaTarefasTest() {

        getTodoList.healthCheckConsultarListaTarefas();

        assertEquals(HttpStatus.SC_OK, getTodoList.respostaConsultarTodoList.getStatusCode());
    }
}
