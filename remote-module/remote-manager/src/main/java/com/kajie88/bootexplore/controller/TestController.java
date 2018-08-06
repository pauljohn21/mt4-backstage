package com.kajie88.bootexplore.controller;

import com.kajie88.bootexplore.learntest.LearnTest;
import com.kajie88.user.domain.UserDomain;
import com.kajie88.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author kajie
 * Date: 2018/5/18 0018
 * Time: 9:49
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private LearnTest lt;


    @RequestMapping("showParam")
    public Object testInter(){

        return "111";
    }
}
