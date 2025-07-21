package com.xiaorui.pojo;

public class User {
    private String uname;
    private String pwd;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User() {
        System.out.println("User 的无参构造器");
    }

    public User(String pwd, String uname) {
        System.out.println("User 的有参构造器");
        this.pwd = pwd;
        this.uname = uname;
    }
    public void sheep(){
        System.out.println(this.uname+" User在睡觉");
    }
}
