package io.example.common.model.model.abstracttest.vo;

public class User2 extends AbstractUser{
    private Integer age;

    public User2() {
        super();
        User2.i--;
    }

    public String getMyName(){
        setName("22");
        return name;
    }
}
