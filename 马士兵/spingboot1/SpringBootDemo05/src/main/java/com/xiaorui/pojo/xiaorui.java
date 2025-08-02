package com.xiaorui.pojo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "这里是数据库 xiaorui 里面字段有四个 id name age sex")
public class xiaorui {
    @Schema(description = "这个是用户的id 是主键 不能重复！！！！ 有自增机制")
    private int id;
    @Schema(description = "这个是用户的name 名字 可以重复 varchar(100)")
    private String name;
    @Schema(description = "这个是用户的age 年龄 可以重复 int")
    private int age;
    @Schema(description = "这个是用户的sex 性别 可以重复 varchar(1)")
    private String sex;

}
