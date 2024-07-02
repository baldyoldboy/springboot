package com.user.problemdetail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProblemController
 * @Description
 * @Author 14036
 * @Version: 1.0
 */
@RestController
public class ProblemController {

    @GetMapping("/probs/not-found")
    public String bookNotFount(){
        return "书籍的isbn可能不存在";
    }

}
