package br.ce.carvalhoqa.taks.apitest;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostTodoListTest extends BaseTest {

    public PostTodoList postTodoList;

    public PostTodoListTest() {
        postTodoList = new PostTodoList();
    }

    @Test
    @DisplayName("Insere uma tarefa na TaskList - Health Check")
    public void HealthCheckCadastrarTasklistTest() {

        postTodoList.HealthCheckCadastrarTasklist();

        assertEquals(HttpStatus.SC_CREATED, postTodoList.respostaCadastrarTasklist.getStatusCode());
    }

    @Test
    @DisplayName("Insere uma tarefa na TaskList - Funcional")
    public void FuncionalCadastrarTasklistTest() {

        postTodoList.FuncionalCadastrarTasklist();

        assertEquals(HttpStatus.SC_CREATED, postTodoList.respostaCadastrarTasklist.getStatusCode());
        assertNotNull(postTodoList.respostaCadastrarTasklist.jsonPath().get("id"));
        assertEquals("Tarefa teste funcional", postTodoList.respostaCadastrarTasklist.jsonPath().get("task"));
        assertNotNull(postTodoList.respostaCadastrarTasklist.jsonPath().get("dueDate"));
    }

    @Test
    @DisplayName("Insere uma tarefa na TaskList - Parametro Data Invalido")
    public void CadastrarTasklistParametroDataInvalidoTest() {

        postTodoList.CadastrarTasklistParametroDataInvalido();

        assertEquals(HttpStatus.SC_BAD_REQUEST, postTodoList.respostaCadastrarTasklist.getStatusCode());
        assertEquals("Due date must not be in past", postTodoList.respostaCadastrarTasklist.jsonPath().get("message"));
    }
}