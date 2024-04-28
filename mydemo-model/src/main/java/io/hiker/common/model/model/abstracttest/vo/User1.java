package io.hiker.common.model.model.abstracttest.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class User1 implements Serializable {
    private Integer age = 1;
    private String gender = "man";
    public String gender2 = "man2";


    public Integer getAge() {
        return age;
    }

    public String queryName() {
        return "张三";
    }

}
