package com.user.httpservice;

import com.user.httpservice.pojo.Todo;
import com.user.httpservice.service.TodoService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class TodoServiceTest {

    @Resource
    private TodoService todoService;
    @Test
    void testGetExchange() {
        Todo todo = todoService.getTodoById(5);
        System.out.println("todo = " + todo);
    }

    @Test
    void testPostExchange() {
        Todo todo = new Todo();
        todo.setId(203);
        todo.setUserId(20);
        todo.setTitle("录制视频");
        todo.setCompleted(true);
        Todo save = todoService.createTodo(todo);
        System.out.println("save = " + save);

        Todo todo1 = new Todo();
        todo1.setId(204);
        todo1.setUserId(22);
        todo1.setTitle("录制音乐");
        todo1.setCompleted(true);
        Todo save1 = todoService.createTodo(todo1);
        System.out.println("save1 = " + save1);

    }

    @Test
    void testPutExchange() {
        Todo todo = new Todo();
        todo.setUserId(5002);
        todo.setTitle("录制视频");
        todo.setCompleted(false);
        ResponseEntity<Todo> responseEntity = todoService.modifyTodo(2, todo);
        HttpStatusCode statusCode = responseEntity.getStatusCode();
        HttpHeaders headers = responseEntity.getHeaders();
        Todo body = responseEntity.getBody();
        System.out.println("statusCode = " + statusCode);
        System.out.println("headers = " + headers);
        System.out.println("body = " + body);
    }

    @Test
    void testPatchExchange() {
//        HttpHeaders httpHeaders = todoService.patchTodo(5, "homework");
//        httpHeaders.forEach((name,value)->{
//            System.out.println(name+"="+value);
//            System.out.println("==================");
//        });
        Todo todo = todoService.patchTodo(5, "homework");
        System.out.println("todo = " + todo);

    }

    @Test
    void testDeleteExchange() {
        todoService.deleteTodo(3);
    }
}
