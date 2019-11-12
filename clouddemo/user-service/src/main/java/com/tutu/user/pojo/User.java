package com.tutu.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data   //没有lombok的同学需要手动添加set get toString方法
@Table(name = "tb_user")
public class User {
    @Id      //设置主键注解
    @KeySql(useGeneratedKeys = true)  //告诉它user的主键id是自增的
    private Long id;
    private String userName;
    private String password;
    private String name;
    private String age;
    //性别  1男性 2女性
    private Integer sex;
    private Date birthday;
    @Transient    //瞬时的，代表这个属性不需要持久化到数据库，意思为表中没有这个属性的字段
    private Date created;
}
