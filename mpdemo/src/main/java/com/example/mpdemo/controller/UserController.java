package com.example.mpdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired //注入 UserMapper
    private UserMapper userMapper;

//    获取所有用户
    @GetMapping("/user")
    public List query(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list;
    }
//    上传用户数据
    @PostMapping("/user")
    public String save(User user){
        int i = userMapper.insert(user);
        if(i > 0){
            return "插入成功";
        }
        else {
            return "插入失败";
        }
    }

//    删除用户数据
    @DeleteMapping("/user")
    public int delUser(int id){
        int rows = userMapper.deleteById(id);
        System.out.println("删除条数：" + rows);
        return rows;
    }

//    获取所有用户及其订单
    @GetMapping("/user/findAll")
    public List<User> find(){
        return userMapper.selectAllUserAndOrders();
    }

//    条件查询
    @GetMapping("/user/find")
    public List<User> findByCond(String username, String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username).or().eq("password",password);
//        queryWrapper.eq("password",null);
        return userMapper.selectList(queryWrapper);
    }

//    分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(int pages){
        Page<User> page = new Page<>(pages,2);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

}
