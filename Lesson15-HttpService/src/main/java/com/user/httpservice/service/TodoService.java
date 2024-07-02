package com.user.httpservice.service;

import com.user.httpservice.pojo.Todo;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.*;

/**
 * @ClassName TodoService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
public interface TodoService {
    @GetExchange("/todos/{id}")
    Todo getTodoById(@PathVariable("id") Integer id);

    @PostExchange(value = "/todos",accept = MediaType.APPLICATION_JSON_VALUE)
    Todo createTodo(@RequestBody Todo todo);

    @PutExchange("/todos/{id}")
    ResponseEntity<Todo> modifyTodo(@PathVariable("id") Integer id,@RequestBody Todo todo);

    @PatchExchange("/todos/{id}")
    Todo patchTodo(@PathVariable("id") Integer id,@RequestParam String title);

    @DeleteExchange("/todos/id")
    void deleteTodo(@PathVariable("id") Integer id);

}
