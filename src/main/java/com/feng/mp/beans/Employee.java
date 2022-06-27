package com.feng.mp.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

//@TableName("tbl_employee")
public class Employee {


    /*
    * @TableId
    *  value : 指定数据库对应的id
    *   type： 主键生成策略  IdType.Auto：自增
    *
    *
    * */
   // @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    /*
    * @TableField
    *   value: 指定数据库中对应的列 value 可以省略
    *   exist： 指定变量在数据库中是否存在对应的列
    * */
    @TableField(value = "last_name")
    private String lastname;

    @TableField(exist = false)
    private double salary;


    private String email;
    private  Integer gender;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }

    private Integer age;
}
