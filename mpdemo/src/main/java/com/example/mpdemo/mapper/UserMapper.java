package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    // mybatis的用法
//    // 查询所有用户
//    @Select("select * from user")
//    public List<User> find();
//
//    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
//    public int insert(User user);

//    查询用户，根据用户ID查询信息
    @Select("select * from t_user where id = #{id}")
    User selectById(int id);

//    查询用户及其所有订单
    @Select("select * from t_user")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "username",property = "username"),
                    @Result(column = "password",property = "password"),
                    @Result(column = "birthday",property = "birthday"),
                    @Result(column = "uid",property = "orders",javaType = List.class,
                    many = @Many(select = "com.example.mpdemo.mapper.OrderMapper.selectByUid")
                    )
            }
    )
    List<User> selectAllUserAndOrders();


}
