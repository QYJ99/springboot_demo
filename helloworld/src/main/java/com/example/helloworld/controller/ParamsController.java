package com.example.helloworld.controller;

import com.example.helloworld.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
public class ParamsController {

    // get 请求
    @ApiOperation("这个是getTest1")
    @RequestMapping(value = "/getTest1",method = RequestMethod.GET)
    public String getTest1(){
        return "GET 请求";
    }

    @RequestMapping(value = "/getTest2",method = RequestMethod.GET)
    public String getTest2(String nickname,String phone){
        System.out.println("nickname:"+nickname);
        System.out.println("phone:"+phone);
        return "GET请求," + "nickname:" + nickname + ",phone:" + phone + '！';

    }

    @RequestMapping(value = "/getTest3",method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname",required = false) String name){
        System.out.println("nickname:" + name);
        return "nickname:" + name;
    }

    // post 请求
    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "POST请求";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(String username,String password){
        System.out.println("username:"+username);
        System.out.println("password:"+password);

        return "POST请求," + "，username:"+username + "，password:"+password;
    }

    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){  // @RequestBody json请求
        System.out.println(user);
        return "POST请求";
    }

    @RequestMapping("/test/*")
    public String test(){ return "调配符请求"; }


}
