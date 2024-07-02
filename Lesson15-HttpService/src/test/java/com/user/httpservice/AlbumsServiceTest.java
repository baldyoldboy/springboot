package com.user.httpservice;

import com.user.httpservice.pojo.Albums;
import com.user.httpservice.service.AlbumsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName AlbumsServiceTest
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@SpringBootTest
public class AlbumsServiceTest {
    @Autowired
    private AlbumsService albumsService;

    @Test
    void testQuery1() {
        Albums albums = albumsService.getAlbumsById1(1);
        System.out.println("albums = " + albums);
    }

    @Test
    void testQuery2() {
        Albums albums = albumsService.getAlbumsById2(12);
        System.out.println("albums = " + albums);
    }
}
