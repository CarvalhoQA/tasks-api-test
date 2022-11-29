package br.ce.carvalhoqa.taks.apitest.post;

import br.ce.carvalhoqa.taks.apitest.BaseTest;
import br.ce.carvalhoqa.taks.apitest.post.PostTodoList;
import org.junit.Assert;
import org.junit.Test;

import org.apache.http.HttpStatus;

public class PostTodoListTest extends BaseTest {

    public PostTodoList postTodoList;

    public PostTodoListTest() {
        postTodoList = new PostTodoList();
    }

    @Test
    public void healthCheckCadastrarTasklistTest() {
        postTodoList.healthCheckCadastrarTasklist();

        Assert.assertEquals(HttpStatus.SC_CREATED, postTodoList.respostaCadastrarTasklist.getStatusCode());
    }

    @Test
    public void funcionalCadastrarTasklistTest() {
        postTodoList.funcionalCadastrarTasklist();

        Assert.assertEquals(HttpStatus.SC_CREATED, postTodoList.respostaCadastrarTasklist.getStatusCode());
        Assert.assertNotNull(postTodoList.respostaCadastrarTasklist.jsonPath().get("id"));
        Assert.assertEquals("Tarefa teste funcional", postTodoList.respostaCadastrarTasklist.jsonPath().get("task"));
        Assert.assertNotNull(postTodoList.respostaCadastrarTasklist.jsonPath().get("dueDate"));
    }

    @Test
    public void cadastrarTasklistParametroDataInvalidoTest() {
        postTodoList.cadastrarTasklistParametroDataInvalido();

        Assert.assertEquals(HttpStatus.SC_BAD_REQUEST, postTodoList.respostaCadastrarTasklist.getStatusCode());
        Assert.assertEquals("Due date must not be in past", postTodoList.respostaCadastrarTasklist.jsonPath().get("message"));
    }
}