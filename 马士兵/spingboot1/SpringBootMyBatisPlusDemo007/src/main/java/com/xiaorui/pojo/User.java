package com.xiaorui.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@TableName("xiaorui")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    @TableField(exist = false)
    private String al;
    private Integer id;
    @TableField("name")
    private String uname;
    private Integer age;
    private String sex;



    @Override
    public String toString() {
        return "User{" +
                "al='" + al + '\'' +
                ", id=" + id +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
