package com.user.httpservice.config;

import com.user.httpservice.service.AlbumsService;
import com.user.httpservice.service.TodoService;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;


/**
 * @ClassName HttpConfiguration
 * @Description
 * @Author 14036
 * @Version: 1.0
 */

@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {

    @Bean
    public TodoService getTodoService(){
        //配置远程代理url
        WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com/").build();
        //HttpServiceProxyFactory.builder()和WebClientAdapter.forClient()失效
        //创建代理工厂
        HttpServiceProxyFactory proxyFactory =HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
        //返回代理对象
        return proxyFactory.createClient(TodoService.class);
    }

    //定制HTTP请求服务
    @Bean
    public AlbumsService getAlbumsService(){
        //超时
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,30000) //连接时间
                .doOnConnected( conn -> {
                    conn.addHandlerLast(new ReadTimeoutHandler(10));//读超时
                    conn.addHandlerLast(new WriteTimeoutHandler(10) );//写超时
                });

        //设置异常
        WebClient webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                    System.out.println("*********WebClient请求异常***********");
                    return Mono.error( new RuntimeException("请求异常" + clientResponse.statusCode().value()));
                }).build();


        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient)).build();

        return proxyFactory.createClient(AlbumsService.class);


    }



}
