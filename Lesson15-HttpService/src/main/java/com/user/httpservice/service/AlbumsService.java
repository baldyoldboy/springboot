package com.user.httpservice.service;

import com.user.httpservice.pojo.Albums;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * @ClassName AlbumsService
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@HttpExchange(url = "https://jsonplaceholder.typicode.com/")
public interface AlbumsService {

    @GetExchange("/albums/{id}")
    Albums getAlbumsById1(@PathVariable("id") Integer id);

    @HttpExchange(url = "/albums/{id}",method = "GET" ,contentType = MediaType.APPLICATION_JSON_VALUE)
    Albums getAlbumsById2(@PathVariable("id") Integer id);
}
